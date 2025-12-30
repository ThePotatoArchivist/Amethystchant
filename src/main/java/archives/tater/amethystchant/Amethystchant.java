package archives.tater.amethystchant;

import net.fabricmc.api.ModInitializer;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Amethystchant implements ModInitializer {
    public static final String MOD_ID = "amethystchant";

    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final TagKey<Item> ENCHANTMENT_FUEL = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MOD_ID, "enchantment_fuel"));

    public static final ResourceLocation EMPTY_SLOT_AMETHYST = ResourceLocation.withDefaultNamespace("item/empty_slot_amethyst_shard");

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

    }
}
