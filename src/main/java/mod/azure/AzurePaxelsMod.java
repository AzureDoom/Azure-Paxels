package mod.azure;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;

public class AzurePaxelsMod implements ModInitializer {

	public static final String MODID = "azure-paxels";
	public static AzurePaxel WOODEN_PAXEL;
	public static AzurePaxel STONE_PAXEL;
	public static AzurePaxel IRON_PAXEL;
	public static AzurePaxel GOLDEN_PAXEL;
	public static AzurePaxel DIAMOND_PAXEL;
	public static AzurePaxel NETHERITE_PAXEL;

	@Override
	public void onInitialize() {
		WOODEN_PAXEL = item("wooden_paxel", new AzurePaxel(Tiers.WOOD, 7.0f));
		STONE_PAXEL = item("stone_paxel", new AzurePaxel(Tiers.STONE, 8.0f));
		IRON_PAXEL = item("iron_paxel", new AzurePaxel(Tiers.IRON, 7.0f));
		GOLDEN_PAXEL = item("golden_paxel", new AzurePaxel(Tiers.GOLD, 7.0f));
		DIAMOND_PAXEL = item("diamond_paxel", new AzurePaxel(Tiers.DIAMOND, 6.0f));
		NETHERITE_PAXEL = item("netherite_paxel", new AzurePaxel(Tiers.NETHERITE, 6.0f));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries -> entries.accept(WOODEN_PAXEL));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries -> entries.accept(STONE_PAXEL));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries -> entries.accept(IRON_PAXEL));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries -> entries.accept(GOLDEN_PAXEL));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries -> entries.accept(DIAMOND_PAXEL));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries -> entries.accept(NETHERITE_PAXEL));
	}

	static <T extends Item> T item(String id, T c) {
		Registry.register(BuiltInRegistries.ITEM, AzurePaxelsMod.modResource(id), c);
		return c;
	}

	public static final ResourceLocation modResource(String name) {
		return new ResourceLocation(MODID, name);
	}
}