package mod.azure;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(AzurePaxelsMod.MODID)
public class AzurePaxelsMod {

	public static final String MODID = "azurepaxels";
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
	public static final RegistryObject<Item> WOODEN_PAXEL = ITEMS.register("wooden_paxel", () -> new AzurePaxel(Tiers.WOOD, 7.0f));
	public static final RegistryObject<Item> STONE_PAXEL = ITEMS.register("stone_paxel", () -> new AzurePaxel(Tiers.STONE, 8.0f));
	public static final RegistryObject<Item> IRON_PAXEL = ITEMS.register("iron_paxel", () -> new AzurePaxel(Tiers.IRON, 7.0f));
	public static final RegistryObject<Item> GOLDEN_PAXEL = ITEMS.register("golden_paxel", () -> new AzurePaxel(Tiers.GOLD, 7.0f));
	public static final RegistryObject<Item> DIAMOND_PAXEL = ITEMS.register("diamond_paxel", () -> new AzurePaxel(Tiers.DIAMOND, 6.0f));
	public static final RegistryObject<Item> NETHERITE_PAXEL = ITEMS.register("netherite_paxel", () -> new AzurePaxel(Tiers.NETHERITE, 6.0f));
	public static final TagKey<Block> PAXEL_BLOCKS = TagKey.create(Registries.BLOCK, AzurePaxelsMod.modResource("paxel_blocks"));

	public AzurePaxelsMod() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ITEMS.register(modEventBus);
		MinecraftForge.EVENT_BUS.register(this);
		modEventBus.addListener(this::addCreative);
	}

	private void addCreative(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			event.accept(WOODEN_PAXEL);
			event.accept(STONE_PAXEL);
			event.accept(IRON_PAXEL);
			event.accept(GOLDEN_PAXEL);
			event.accept(DIAMOND_PAXEL);
			event.accept(NETHERITE_PAXEL);
		}
	}

	public static final ResourceLocation modResource(String name) {
		return new ResourceLocation(MODID, name);
	}
}