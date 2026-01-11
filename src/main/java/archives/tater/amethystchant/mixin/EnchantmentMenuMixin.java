package archives.tater.amethystchant.mixin;

import archives.tater.amethystchant.Amethystchant;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import com.mojang.datafixers.util.Pair;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.EnchantmentMenu;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

@Mixin(EnchantmentMenu.class)
@Debug(export = true)
public class EnchantmentMenuMixin {
    @WrapOperation(
            method = "quickMoveStack",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z")
    )
    private boolean checkTag(ItemStack instance, Item item, Operation<Boolean> original) {
        return instance.is(Amethystchant.ENCHANTMENT_FUEL);
    }

    @ModifyArg(
            method = "<init>(ILnet/minecraft/world/entity/player/Inventory;Lnet/minecraft/world/inventory/ContainerLevelAccess;)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/inventory/EnchantmentMenu;addSlot(Lnet/minecraft/world/inventory/Slot;)Lnet/minecraft/world/inventory/Slot;", ordinal = 1),
            index = 0
    )
    private Slot wrapSlot(Slot original) {
        return new Slot(original.container, original.getContainerSlot(), original.x, original.y) {
            @Override
            public boolean mayPlace(ItemStack itemStack) {
                return itemStack.is(Amethystchant.ENCHANTMENT_FUEL);
            }

            @Override
            public Pair<ResourceLocation, ResourceLocation> getNoItemIcon() {
                return Pair.of(InventoryMenu.BLOCK_ATLAS, Amethystchant.EMPTY_SLOT_AMETHYST);
            }
        };
    }
}