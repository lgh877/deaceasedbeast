package net.mcreator.deaceased.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.deaceased.entity.BuggerEntity;

import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;

public class BuggerOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity instancehead_entity = null;
		ArrayList<Object> intancehead = new ArrayList<>();
		double dsx = 0;
		double dsz = 0;
		double dsy = 0;
		double endz = 0;
		double endy = 0;
		double endx = 0;
		double eyg = 0;
		double ezg = 0;
		double ex = 0;
		double ey = 0;
		double startz = 0;
		double exg = 0;
		double ez = 0;
		double distpullsafe = 0;
		double starty = 0;
		double sdist = 0;
		double dist_pull = 0;
		double startx = 0;
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity) {
			if (entity.isAlive()) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(0.8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == entityiterator) {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity),
									(float) (entity instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity5.getAttribute(Attributes.ATTACK_DAMAGE).getValue() : 0));
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 60, 0));
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 300, 0));
						}
					}
				}
			}
		}
		if ((entity instanceof BuggerEntity _datEntL11 && _datEntL11.getEntityData().get(BuggerEntity.DATA_rage)) == true) {
			if (entity instanceof BuggerEntity animatable)
				animatable.setTexture("bugger_enraged");
			if (entity instanceof LivingEntity _livingEntity13 && _livingEntity13.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
				_livingEntity13.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.08);
			if (Math.random() < 0.1) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.ANGRY_VILLAGER, x, y, z, 2, 1, 1, 1, 1);
			}
		}
	}
}
