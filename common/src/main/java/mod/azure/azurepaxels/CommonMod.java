package mod.azure.azurepaxels;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.Block;

public class CommonMod {
    public static final String MOD_ID = "azurepaxels";
    public static final TagKey<Block> PAXEL_BLOCKS = TagKey.create(Registries.BLOCK, modResource("paxel_blocks"));
    public static final Item WOODEN_PAXEL = new AzurePaxel(Tiers.WOOD, 7.0f);
    public static final Item STONE_PAXEL = new AzurePaxel(Tiers.STONE, 8.0f);
    public static final Item IRON_PAXEL = new AzurePaxel(Tiers.IRON, 7.0f);
    public static final Item GOLDEN_PAXEL = new AzurePaxel(Tiers.GOLD, 7.0f);
    public static final Item DIAMOND_PAXEL = new AzurePaxel(Tiers.DIAMOND, 6.0f);
    public static final Item NETHERITE_PAXEL = new AzurePaxel(Tiers.NETHERITE, 6.0f);

    public static ResourceLocation modResource(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }
}
