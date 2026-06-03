package net.mcreator.deaceased.ai;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;

import java.util.EnumSet;

public class FlyToTargetGoal extends Goal {
	private final Mob mob;
	private LivingEntity target;
	private final double minDistance;

	public FlyToTargetGoal(Mob mob, double minDistance) {
		this.mob = mob;
		this.minDistance = minDistance;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
	}

	@Override
	public boolean canUse() {
		LivingEntity t = mob.getTarget();
		if (t == null || !t.isAlive())
			return false;
		this.target = t;
		return true;
	}

	@Override
	public boolean canContinueToUse() {
		return target != null && target.isAlive();
	}

	@Override
	public void tick() {
		if (target == null)
			return;
		// ✅ Get speed from attribute
		double speed = mob.getAttributeValue(Attributes.MOVEMENT_SPEED);
		Vec3 mobPos = mob.position();
		Vec3 targetPos = target.position().add(0, target.getBbHeight() * 0.5, 0);
		Vec3 dir = targetPos.subtract(mobPos);
		double distance = dir.length();
		// Close-range hover jitter
		Vec3 forward = dir.normalize();
		Vec3 sideways = new Vec3(-forward.z, 0, forward.x).scale((mob.getRandom().nextDouble() - 0.5) * 0.6);
		Vec3 vertical = new Vec3(0, (mob.getRandom().nextDouble() - 0.5) * 0.4, 0);
		double burst = mob.getRandom().nextDouble() < 0.08 ? 1.8 : 1.0;
		Vec3 desiredMotion = forward.scale(speed * burst).add(sideways).add(vertical);
		mob.setDeltaMovement(mob.getDeltaMovement().scale(0.7).add(desiredMotion));
		mob.getLookControl().setLookAt(target, 30.0F, 30.0F);
	}

	@Override
	public boolean requiresUpdateEveryTick() {
		return true;
	}
}
