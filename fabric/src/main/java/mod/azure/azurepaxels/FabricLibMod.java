package mod.azure.azurepaxels;

import mod.azure.azurelib.common.internal.common.AzureLibMod;
import mod.azure.azurelib.common.internal.common.config.format.ConfigFormats;
import mod.azure.azurepaxels.config.PaxelConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTabs;

public final class FabricLibMod implements ModInitializer {

    @Override
    public void onInitialize() {
        CommonMod.init();
        Registry.register(BuiltInRegistries.ITEM, CommonMod.modResource("wooden_paxel"), CommonMod.WOODEN_PAXEL);
        Registry.register(BuiltInRegistries.ITEM, CommonMod.modResource("stone_paxel"), CommonMod.STONE_PAXEL);
        Registry.register(BuiltInRegistries.ITEM, CommonMod.modResource("iron_paxel"), CommonMod.IRON_PAXEL);
        Registry.register(BuiltInRegistries.ITEM, CommonMod.modResource("golden_paxel"), CommonMod.GOLDEN_PAXEL);
        Registry.register(BuiltInRegistries.ITEM, CommonMod.modResource("diamond_paxel"), CommonMod.DIAMOND_PAXEL);
        Registry.register(BuiltInRegistries.ITEM, CommonMod.modResource("netherite_paxel"), CommonMod.NETHERITE_PAXEL);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries -> {
            entries.accept(CommonMod.WOODEN_PAXEL);
            entries.accept(CommonMod.STONE_PAXEL);
            entries.accept(CommonMod.IRON_PAXEL);
            entries.accept(CommonMod.GOLDEN_PAXEL);
            entries.accept(CommonMod.DIAMOND_PAXEL);
            entries.accept(CommonMod.NETHERITE_PAXEL);
        });
    }
}
