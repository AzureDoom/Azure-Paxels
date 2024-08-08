package mod.azure.azurepaxels;

import mod.azure.azurelib.common.internal.common.AzureLibMod;
import mod.azure.azurelib.common.internal.common.config.format.ConfigFormats;
import mod.azure.azurepaxels.config.PaxelConfig;
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
    public static final Item WOODEN_PAXEL = new AzurePaxel(Tiers.WOOD, 7.0f, config.paxel_wood_durability){
        @Override
        public float getDestroySpeed(@NotNull ItemStack stack, @NotNull BlockState state) {
            return CommonMod.config.paxel_wood_minespeed;
    }};
    public static final Item STONE_PAXEL = new AzurePaxel(Tiers.STONE, 8.0f, config.paxel_stone_durability){
        @Override
        public float getDestroySpeed(@NotNull ItemStack stack, @NotNull BlockState state) {
            return CommonMod.config.paxel_stone_minespeed;
        }};
    public static final Item IRON_PAXEL = new AzurePaxel(Tiers.IRON, 7.0f, config.paxel_iron_durability){
        @Override
        public float getDestroySpeed(@NotNull ItemStack stack, @NotNull BlockState state) {
            return CommonMod.config.paxel_iron_minespeed;
        }};
    public static final Item GOLDEN_PAXEL = new AzurePaxel(Tiers.GOLD, 7.0f, config.paxel_gold_durability){
        @Override
        public float getDestroySpeed(@NotNull ItemStack stack, @NotNull BlockState state) {
            return CommonMod.config.paxel_gold_minespeed;
        }};
    public static final Item DIAMOND_PAXEL = new AzurePaxel(Tiers.DIAMOND, 6.0f, config.paxel_diamond_durability){
        @Override
        public float getDestroySpeed(@NotNull ItemStack stack, @NotNull BlockState state) {
            return CommonMod.config.paxel_diamond_minespeed;
        }};;
    public static final Item NETHERITE_PAXEL = new AzurePaxel(Tiers.NETHERITE, 6.0f, config.paxel_netherrite_durability){
        @Override
        public float getDestroySpeed(@NotNull ItemStack stack, @NotNull BlockState state) {
            return CommonMod.config.paxel_netherrite_minespeed;
        }};

    public static ResourceLocation modResource(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }

    public static void init() {
        CommonMod.config = AzureLibMod.registerConfig(PaxelConfig.class, ConfigFormats.json()).getConfigInstance();
    }
}
