package net.mcreator.deaceased;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.ArrayList;

public class WaveEffect {
	public static void createShockwave(Level world, BlockPos center, int maxRadius, int damage, LivingEntity owner, LivingEntity damageTarget // 👈 NEW PARAMETER
	) {
		if (!(world instanceof ServerLevel level))
			return;
		for (int radius = 2; radius <= maxRadius; radius++) {
			int delay = radius * 4;
			for (BlockPos pos : getRing(center, radius)) {
				DeaceasedMod.queueServerWork(delay, () -> {
					// ======================
					// BLOCK PARTICLES
					// ======================
					BlockPos groundPos = pos.below();
					if (!world.isEmptyBlock(groundPos)) {
						BlockState state = world.getBlockState(groundPos);
						level.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, state), pos.getX() + 0.5, pos.getY() + 1.05, pos.getZ() + 0.5, 12, 0.4, 0.2, 0.4, 0.15);
					}
					// ======================
					// DAMAGE + KNOCK-UP
					// ======================
					AABB aabb = new AABB(pos).inflate(0.75);
					for (LivingEntity entity : world.getEntitiesOfClass(LivingEntity.class, aabb)) {
						// ❌ Never damage owner
						if (entity == owner)
							continue;
						// 🎯 If a specific target is set, only damage that one
						if (damageTarget != null && entity != damageTarget)
							continue;
						entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FALL)), damage);
						entity.setDeltaMovement(entity.getDeltaMovement().x(), 1.1, entity.getDeltaMovement().z());
					}
				});
			}
		}
	}

	// ======================
	// RING CALCULATION
	// ======================
	private static Iterable<BlockPos> getRing(BlockPos center, int radius) {
		List<BlockPos> positions = new ArrayList<>();
		for (int dx = -radius; dx <= radius; dx++) {
			for (int dz = -radius; dz <= radius; dz++) {
				double dist = Math.sqrt(dx * dx + dz * dz);
				if (dist >= radius - 0.5 && dist <= radius + 0.5) {
					positions.add(center.offset(dx, 0, dz));
				}
			}
		}
		return positions;
	}
}
