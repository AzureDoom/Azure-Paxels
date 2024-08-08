package mod.azure.azurepaxels.items;

import mod.azure.azurepaxels.AzurePaxel;
import mod.azure.azurepaxels.CommonMod;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class ModItems {
    public static final Supplier<Item> WOODEN_PAXEL = CommonItemRegistryInterface.registerItem(CommonMod.MOD_ID, "wooden_paxel", ()-> new AzurePaxel(
            Tiers.WOOD, 7.0f, CommonMod.config.paxel_wood_durability){
        @Override
        public float getDestroySpeed(@NotNull ItemStack stack, @NotNull BlockState state) {
            return CommonMod.config.paxel_wood_minespeed;
        }});

     public static final Supplier<Item> STONE_PAXEL = CommonItemRegistryInterface.registerItem(CommonMod.MOD_ID, "stone_paxel", ()-> new AzurePaxel(Tiers.STONE, 8.0f, CommonMod.config.paxel_stone_durability){
        @Override
        public float getDestroySpeed(@NotNull ItemStack stack, @NotNull BlockState state) {
            return CommonMod.config.paxel_stone_minespeed;
        }});
     public static final Supplier<Item> IRON_PAXEL = CommonItemRegistryInterface.registerItem(CommonMod.MOD_ID, "iron_paxel", ()-> new AzurePaxel(Tiers.IRON, 7.0f, CommonMod.config.paxel_iron_durability){
        @Override
        public float getDestroySpeed(@NotNull ItemStack stack, @NotNull BlockState state) {
            return CommonMod.config.paxel_iron_minespeed;
        }});
     public static final Supplier<Item> GOLDEN_PAXEL = CommonItemRegistryInterface.registerItem(CommonMod.MOD_ID, "golden_paxel", ()-> new AzurePaxel(Tiers.GOLD, 7.0f, CommonMod.config.paxel_gold_durability){
        @Override
        public float getDestroySpeed(@NotNull ItemStack stack, @NotNull BlockState state) {
            return CommonMod.config.paxel_gold_minespeed;
        }});
     public static final Supplier<Item> DIAMOND_PAXEL = CommonItemRegistryInterface.registerItem(CommonMod.MOD_ID, "diamond_paxel", ()-> new AzurePaxel(Tiers.DIAMOND, 6.0f, CommonMod.config.paxel_diamond_durability){
        @Override
        public float getDestroySpeed(@NotNull ItemStack stack, @NotNull BlockState state) {
            return CommonMod.config.paxel_diamond_minespeed;
        }});
     public static final Supplier<Item> NETHERITE_PAXEL = CommonItemRegistryInterface.registerItem(CommonMod.MOD_ID, "netherite_paxel", ()-> new AzurePaxel(Tiers.NETHERITE, 6.0f, CommonMod.config.paxel_netherrite_durability){
        @Override
        public float getDestroySpeed(@NotNull ItemStack stack, @NotNull BlockState state) {
            return CommonMod.config.paxel_netherrite_minespeed;
        }});

    public static void init() {
    }
}
