package net.luigidude.tutorialmod.item;


import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.luigidude.tutorialmod.TutorialMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ENDERITE_INGOT = registerItem("enderite_ingot", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TutorialMod.MOD_ID,"enderite_ingot")))));
    public static final Item ENDERITE_GOO = registerItem("enderite_goo", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TutorialMod.MOD_ID,"enderite_goo")))));
    public static final Item RAW_SILVER = registerItem("raw_silver", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TutorialMod.MOD_ID,"raw_silver")))));
    public static final Item SILVER_BAR = registerItem("silver_bar", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TutorialMod.MOD_ID,"silver_bar")))));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ENDERITE_INGOT);
            fabricItemGroupEntries.add(ENDERITE_GOO);
            fabricItemGroupEntries.add(RAW_SILVER);
            fabricItemGroupEntries.add(SILVER_BAR);
        });
    }


}
