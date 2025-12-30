package archives.tater.amethystchant.mixin;

import archives.tater.amethystchant.Amethystchant;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

@Mixin(targets = "net/minecraft/world/inventory/EnchantmentMenu$3")
public class EnchantmentMenuSlot2Mixin {
    @WrapOperation(
            method = "mayPlace",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z")
    )
    private boolean checkTag(ItemStack instance, Item item, Operation<Boolean> original) {
        return instance.is(Amethystchant.ENCHANTMENT_FUEL);
    }

    @ModifyExpressionValue(
            method = "getNoItemIcon",
            at = @At(value = "FIELD", target = "Lnet/minecraft/world/inventory/EnchantmentMenu;EMPTY_SLOT_LAPIS_LAZULI:Lnet/minecraft/resources/ResourceLocation;")
    )
    private ResourceLocation replaceIcon(ResourceLocation original) {
        return Amethystchant.EMPTY_SLOT_AMETHYST;
    }
}
