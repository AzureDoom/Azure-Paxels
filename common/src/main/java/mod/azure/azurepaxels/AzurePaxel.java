package mod.azure.azurepaxels;

import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class AzurePaxel extends DiggerItem {

    protected static final Map<Block, BlockState> SHOVEL_LOOKUP = Shovel.getFlattenables();
    protected static final Map<Block, Block> BLOCK_STRIPPING_MAP = Axe.getStrippables();

    public AzurePaxel(Tier tier, Float damage) {
        super(tier, CommonMod.PAXEL_BLOCKS, new Item.Properties().stacksTo(1));
    }

    @Override
    public float getDestroySpeed(@NotNull ItemStack stack, @NotNull BlockState state) {
        return 30;
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        final var world = context.getLevel();
        final var blockPos = context.getClickedPos();
        final var player = context.getPlayer();
        final var blockstate = world.getBlockState(blockPos);
        BlockState resultToSet = null;
        final var strippedResult = BLOCK_STRIPPING_MAP.get(blockstate.getBlock());
        if (strippedResult != null) {
            world.playSound(player, blockPos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
            resultToSet = strippedResult.defaultBlockState().setValue(RotatedPillarBlock.AXIS,
                    blockstate.getValue(RotatedPillarBlock.AXIS));
        } else if (context.getClickedFace() != Direction.DOWN) {
            final var foundResult = SHOVEL_LOOKUP.get(blockstate.getBlock());
            if (foundResult != null && world.getBlockState(blockPos.above()).isAir()) {
                world.playSound(player, blockPos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
                resultToSet = foundResult;
            } else if (blockstate.getBlock() instanceof CampfireBlock && Boolean.TRUE.equals(blockstate.getValue(CampfireBlock.LIT)))
                resultToSet = blockstate.setValue(CampfireBlock.LIT, false);
        }
        if (resultToSet == null) return InteractionResult.PASS;
        if (!world.isClientSide()) {
            world.setBlock(blockPos, resultToSet, 11);
            if (player != null) context.getItemInHand().hurtAndBreak(1, player,
                    LivingEntity.getSlotForHand(context.getHand()));
        }
        return InteractionResult.SUCCESS;
    }

    private static final class Axe extends AxeItem {
        public static Map<Block, Block> getStrippables() {
            return AxeItem.STRIPPABLES;
        }

        private Axe(Tier tier, Properties properties) {
            super(tier, properties);
        }
    }

    private static final class Shovel extends ShovelItem {
        public static Map<Block, BlockState> getFlattenables() {
            return ShovelItem.FLATTENABLES;
        }

        private Shovel(Tier tier, Properties properties) {
            super(tier, properties);
        }
    }

}