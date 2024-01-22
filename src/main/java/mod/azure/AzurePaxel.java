package mod.azure;

import java.util.Map;
import java.util.function.Consumer;

import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;

public class AzurePaxel extends DiggerItem {
	protected static final Map<Block, BlockState> SHOVEL_LOOKUP = Shovel.getFlattenables();
	protected static final Map<Block, Block> BLOCK_STRIPPING_MAP = Axe.getStrippables();

	public AzurePaxel(Tier tier, Float damage) {
		super(damage, -2.8f, tier, AzurePaxelsMod.PAXEL_BLOCKS, new Item.Properties().stacksTo(1));
	}

	@Override
	public float getDestroySpeed(ItemStack stack, BlockState state) {
		return 30;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		final var world = context.getLevel();
		final var blockPos = context.getClickedPos();
		final var player = context.getPlayer();
		final var blockstate = world.getBlockState(blockPos);
		BlockState resultToSet = null;
		final var strippedResult = BLOCK_STRIPPING_MAP.get(blockstate.getBlock());
		if (strippedResult != null) {
			world.playSound(player, blockPos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
			resultToSet = strippedResult.defaultBlockState().setValue(RotatedPillarBlock.AXIS, blockstate.getValue(RotatedPillarBlock.AXIS));
		} else if (context.getClickedFace() != Direction.DOWN) {
			final var foundResult = SHOVEL_LOOKUP.get(blockstate.getBlock());
			if (foundResult != null && world.getBlockState(blockPos.above()).isAir()) {
				world.playSound(player, blockPos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
				resultToSet = foundResult;
			} else if (blockstate.getBlock() instanceof CampfireBlock && blockstate.getValue(CampfireBlock.LIT))
				resultToSet = blockstate.setValue(CampfireBlock.LIT, false);
		}
		if (resultToSet == null)
			return InteractionResult.PASS;
		if (!world.isClientSide()) {
			world.setBlock(blockPos, resultToSet, 11);
			if (player != null)
				context.getItemInHand().hurtAndBreak(1, (LivingEntity) player, (Consumer<LivingEntity>) p -> {
					p.broadcastBreakEvent(context.getHand());
				});
		}
		return InteractionResult.SUCCESS;
	}

	private static final class Axe extends AxeItem {
		public static Map<Block, Block> getStrippables() {
			return AxeItem.STRIPPABLES;
		}

		private Axe(Tier tier, float f, float g, Properties properties) {
			super(tier, f, g, properties);
		}
	}

	private static final class Shovel extends ShovelItem {
		public static Map<Block, BlockState> getFlattenables() {
			return ShovelItem.FLATTENABLES;
		}

		private Shovel(Tier tier, float f, float g, Properties properties) {
			super(tier, f, g, properties);
		}
	}
}