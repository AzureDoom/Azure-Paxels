package mod.azure.azurepaxels;

import mod.azure.azurelib.common.internal.common.AzureLibMod;
import mod.azure.azurelib.common.internal.common.config.format.ConfigFormats;
import mod.azure.azurepaxels.config.PaxelConfig;
import mod.azure.azurepaxels.items.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTabs;

public final class FabricLibMod implements ModInitializer {

    @Override
    public void onInitialize() {
        CommonMod.init();
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries -> {
            entries.accept(ModItems.WOODEN_PAXEL.get());
            entries.accept(ModItems.STONE_PAXEL.get());
            entries.accept(ModItems.IRON_PAXEL.get());
            entries.accept(ModItems.GOLDEN_PAXEL.get());
            entries.accept(ModItems.DIAMOND_PAXEL.get());
            entries.accept(ModItems.NETHERITE_PAXEL.get());
        });
    }
}
