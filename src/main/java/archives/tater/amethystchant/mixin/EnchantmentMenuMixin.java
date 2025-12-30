package archives.tater.amethystchant.mixin;

import archives.tater.amethystchant.Amethystchant;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.world.inventory.EnchantmentMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

@Mixin(EnchantmentMenu.class)
public class EnchantmentMenuMixin {
    @WrapOperation(
            method = "quickMoveStack",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z")
    )
    private boolean checkTag(ItemStack instance, Item item, Operation<Boolean> original) {
        return instance.is(Amethystchant.ENCHANTMENT_FUEL);
    }
}