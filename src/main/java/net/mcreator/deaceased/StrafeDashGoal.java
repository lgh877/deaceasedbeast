package net.mcreator.deaceased;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.util.Mth;

import net.mcreator.deaceased.procedures.CloseproxProcedure;

import java.util.EnumSet;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class StrafeDashGoal extends Goal {
	private final Mob mob;
	private LivingEntity target;
	private final double desiredDistance;
	private final double dashSpeed;
	private final int dashCooldownTicks;
	private int dashCooldown = 0;
	private boolean strafeLeft = true;

	public StrafeDashGoal(Mob mob, double desiredDistance, double dashSpeed, int dashCooldownTicks) {
		this.mob = mob;
		this.desiredDistance = desiredDistance;
		this.dashSpeed = dashSpeed;
		this.dashCooldownTicks = dashCooldownTicks;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
	}

	@Override
	public boolean canUse() {
		target = mob.getTarget();
		return target != null && target.isAlive() && mob.distanceTo(target) <= 16;
	}

	@Override
	public boolean canContinueToUse() {
		return target != null && target.isAlive() && mob.distanceTo(target) <= 16;
	}

	@Override
	public void start() {
		dashCooldown = 0;
		strafeLeft = mob.getRandom().nextBoolean();
		mob.getNavigation().stop();
	}

	@Override
	public void tick() {
		if (target == null)
			return;
		// --- FORCE LOOK AT TARGET ---
		mob.getLookControl().setLookAt(target, 30.0F, 30.0F);
		double dx = target.getX() - mob.getX();
		double dz = target.getZ() - mob.getZ();
		float targetYaw = (float) (Mth.atan2(dz, dx) * (180F / Math.PI)) - 90F;
		mob.setYRot(targetYaw);
		mob.yBodyRot = targetYaw;
		mob.yHeadRot = targetYaw;
		double dist = mob.distanceTo(target);
		Vec3 move = Vec3.ZERO;
		// --- BACK OFF IF TOO CLOSE ---
		if (dist < desiredDistance) {
			Vec3 away = mob.position().subtract(target.position()).normalize();
			move = move.add(away.scale(0.08));
		}
		// --- STRAFE DASH ---
		if (dashCooldown-- <= 0) {
			dashCooldown = dashCooldownTicks;
			strafeLeft = !strafeLeft;
			Vec3 toTarget = target.position().subtract(mob.position()).normalize();
			Vec3 side = new Vec3(-toTarget.z, 0, toTarget.x);
			if (!strafeLeft)
				side = side.scale(-1);
			move = move.add(side.normalize().scale(dashSpeed));
		}
		mob.setDeltaMovement(move);
	}
}
