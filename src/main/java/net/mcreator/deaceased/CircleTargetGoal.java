/**
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside net.mcreator.deaceased as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
*/
package net.mcreator.deaceased;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;

import java.util.EnumSet;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CircleTargetGoal extends Goal {
	private final Mob mob;
	private LivingEntity target;
	private final double radius;
	private final double speed;
	private float angle;
	private final boolean clockwise;

	public CircleTargetGoal(Mob mob, double radius, double speed, boolean clockwise) {
		this.mob = mob;
		this.radius = radius;
		this.speed = speed;
		this.clockwise = clockwise;
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
	public void start() {
		angle = mob.getRandom().nextFloat() * 360f;
	}

	@Override
	public void tick() {
		if (target == null)
			return;
		angle += (clockwise ? 1 : -1) * 3.5f;
		double rad = Math.toRadians(angle);
		double tx = target.getX() + Math.cos(rad) * radius;
		double tz = target.getZ() + Math.sin(rad) * radius;
		double ty = target.getY();
		mob.getNavigation().moveTo(tx, ty, tz, speed);
		mob.getLookControl().setLookAt(target, 30.0F, 30.0F);
	}
}
