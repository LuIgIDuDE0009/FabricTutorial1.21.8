package net.luigidude.tutorialmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.luigidude.tutorialmod.TutorialMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block ENDERITE_BLOCK = registerBlock("enderite_block",
            AbstractBlock.Settings.create().strength(5f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK));
    public static final Block ENDERITE_ORE = registerBlock("enderite_ore",
            AbstractBlock.Settings.create().strength(5f).requiresTool().sounds(BlockSoundGroup.STONE));
    public static final Block RAW_SILVER_BLOCK = registerBlock("raw_silver_block",
            AbstractBlock.Settings.create().strength(5f).requiresTool().sounds(BlockSoundGroup.STONE));

    private static Block registerBlock(String name, AbstractBlock.Settings blockSettings) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(TutorialMod.MOD_ID, name));
        Block block = new Block(blockSettings.registryKey(key));
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, key, block);
    }

    private static void registerBlockItem(String name, Block block) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TutorialMod.MOD_ID, name));
        BlockItem item = new BlockItem(block, new Item.Settings().registryKey(key));
        Registry.register(Registries.ITEM, key, item);
    }

    public static void registerModBlocks() {
        TutorialMod.LOGGER.info("Registering Mod Blocks for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.ENDERITE_BLOCK);
            fabricItemGroupEntries.add(ModBlocks.ENDERITE_ORE);
            fabricItemGroupEntries.add(ModBlocks.RAW_SILVER_BLOCK);
        });
    }
}
