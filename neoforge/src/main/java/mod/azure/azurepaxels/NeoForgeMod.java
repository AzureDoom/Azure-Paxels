package mod.azure.azurepaxels;

import mod.azure.azurelib.common.internal.common.AzureLibMod;
import mod.azure.azurelib.common.internal.common.config.format.ConfigFormats;
import mod.azure.azurepaxels.config.PaxelConfig;
import mod.azure.azurepaxels.items.ModItems;
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

    public NeoForgeMod(IEventBus modEventBus) {
        CommonMod.init();
        ITEM_DEFERRED_REGISTER.register(modEventBus);
        modEventBus.addListener(this::addCreativeTabs);
    }

    public void addCreativeTabs(final BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.WOODEN_PAXEL.get());
            event.accept(ModItems.STONE_PAXEL.get());
            event.accept(ModItems.IRON_PAXEL.get());
            event.accept(ModItems.GOLDEN_PAXEL.get());
            event.accept(ModItems.DIAMOND_PAXEL.get());
            event.accept(ModItems.NETHERITE_PAXEL.get());
        }
    }
}
