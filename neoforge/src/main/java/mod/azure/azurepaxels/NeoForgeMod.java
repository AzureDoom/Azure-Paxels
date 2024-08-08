package mod.azure.azurepaxels;

import mod.azure.azurelib.common.internal.common.AzureLibMod;
import mod.azure.azurelib.common.internal.common.config.format.ConfigFormats;
import mod.azure.azurepaxels.config.PaxelConfig;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

@Mod(CommonMod.MOD_ID)
public final class NeoForgeMod {

    public static final DeferredRegister<Item> ITEM_DEFERRED_REGISTER = DeferredRegister.create(Registries.ITEM,
            CommonMod.MOD_ID);
    public static final Supplier<Item> WOODEN_PAXEL = ITEM_DEFERRED_REGISTER.register("wooden_paxel",
            () -> CommonMod.WOODEN_PAXEL);
    public static final Supplier<Item> STONE_PAXEL = ITEM_DEFERRED_REGISTER.register("stone_paxel",
            () -> CommonMod.STONE_PAXEL);
    public static final Supplier<Item> IRON_PAXEL = ITEM_DEFERRED_REGISTER.register("iron_paxel",
            () -> CommonMod.IRON_PAXEL);
    public static final Supplier<Item> GOLDEN_PAXEL = ITEM_DEFERRED_REGISTER.register("golden_paxel",
            () -> CommonMod.GOLDEN_PAXEL);
    public static final Supplier<Item> DIAMOND_PAXEL = ITEM_DEFERRED_REGISTER.register("diamond_paxel",
            () -> CommonMod.DIAMOND_PAXEL);
    public static final Supplier<Item> NETHERITE_PAXEL = ITEM_DEFERRED_REGISTER.register("netherite_paxel",
            () -> CommonMod.NETHERITE_PAXEL);

    public NeoForgeMod(IEventBus modEventBus) {
        ITEM_DEFERRED_REGISTER.register(modEventBus);
        CommonMod.config = AzureLibMod.registerConfig(PaxelConfig.class, ConfigFormats.json()).getConfigInstance();
        modEventBus.addListener(this::addCreativeTabs);
    }

    public void addCreativeTabs(final BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(WOODEN_PAXEL.get());
            event.accept(STONE_PAXEL.get());
            event.accept(IRON_PAXEL.get());
            event.accept(GOLDEN_PAXEL.get());
            event.accept(DIAMOND_PAXEL.get());
            event.accept(NETHERITE_PAXEL.get());
        }
    }
}
