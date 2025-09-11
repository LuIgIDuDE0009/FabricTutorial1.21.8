package net.luigidude.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.luigidude.tutorialmod.TutorialMod;
import net.luigidude.tutorialmod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup Tutorial_Mod_Group = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "tutorial_mod_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.ENDERITE_GOO))
                    .displayName(Text.translatable("itemgroup.tutorialmod.tutorial_mod_items"))
                    .entries((displayContext, entries) -> {
                      entries.add(ModItems.ENDERITE_GOO);
                      entries.add(ModItems.ENDERITE_INGOT);
                      entries.add(ModItems.SILVER_BAR);
                      entries.add(ModItems.RAW_SILVER);
                      entries.add(ModBlocks.ENDERITE_BLOCK);
                      entries.add(ModBlocks.ENDERITE_ORE);
                      entries.add(ModBlocks.RAW_SILVER_BLOCK);
                    }).build());




    public static void registerItemGroups(){
        TutorialMod.LOGGER.info("Registering Item Groups for " + TutorialMod.MOD_ID);
    }
}
