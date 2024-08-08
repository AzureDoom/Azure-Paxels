package mod.azure.azurepaxels;

import mod.azure.azurelib.common.internal.common.AzureLibMod;
import mod.azure.azurelib.common.internal.common.config.format.ConfigFormats;
import mod.azure.azurepaxels.config.PaxelConfig;
import mod.azure.azurepaxels.items.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class CommonMod {
    public static PaxelConfig config = AzureLibMod.registerConfig(PaxelConfig.class, ConfigFormats.json()).getConfigInstance();
    public static final String MOD_ID = "azurepaxels";
    public static final TagKey<Block> PAXEL_BLOCKS = TagKey.create(Registries.BLOCK, modResource("paxel_blocks"));

    public static ResourceLocation modResource(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }

    public static void init() {
        CommonMod.config = AzureLibMod.registerConfig(PaxelConfig.class, ConfigFormats.json()).getConfigInstance();
        ModItems.init();
    }
}
