package net.mcreator.deaceased.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.deaceased.init.DeaceasedModParticleTypes;

public class GooWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (DeaceasedModParticleTypes.GOPART.get()), x, y, z, 2, 0.2, 0.2, 0.2, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (DeaceasedModParticleTypes.GOPART_2.get()), x, y, z, 2, 0.2, 0.2, 0.2, 0);
	}
}
