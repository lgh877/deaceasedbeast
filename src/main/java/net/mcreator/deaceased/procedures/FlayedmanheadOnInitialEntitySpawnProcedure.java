package net.mcreator.deaceased.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.deaceased.init.DeaceasedModEntities;
import net.mcreator.deaceased.entity.FlayedmantailEntity;
import net.mcreator.deaceased.entity.FlayedmansectionsEntity;
import net.mcreator.deaceased.entity.FlayedmanheadEntity;
import net.mcreator.deaceased.configuration.DeceasedmobsConfiguration;

public class FlayedmanheadOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double yawStart = 0;
		double size = 0;
		double id = 0;
		entity.getPersistentData().putUUID("id", entity.getUUID());
		if (entity instanceof FlayedmanheadEntity _datEntSetI)
			_datEntSetI.getEntityData().set(FlayedmanheadEntity.DATA_sections, (int) (double) DeceasedmobsConfiguration.CSN.get());
		for (int index0 = 0; index0 < (int) (entity instanceof FlayedmanheadEntity _datEntI ? _datEntI.getEntityData().get(FlayedmanheadEntity.DATA_sections) : 0); index0++) {
			if (index0 == (entity instanceof FlayedmanheadEntity _datEntI ? _datEntI.getEntityData().get(FlayedmanheadEntity.DATA_sections) : 0)) {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entityinstance = DeaceasedModEntities.FLAYEDMANTAIL.get().create(_serverLevel, null, null,
							BlockPos.containing(x - entity.getLookAngle().x * (entity instanceof FlayedmanheadEntity _datEntI ? _datEntI.getEntityData().get(FlayedmanheadEntity.DATA_sections) : 0), y,
									z - entity.getLookAngle().z * (entity instanceof FlayedmanheadEntity _datEntI ? _datEntI.getEntityData().get(FlayedmanheadEntity.DATA_sections) : 0)),
							MobSpawnType.MOB_SUMMONED, false, false);
					if (entityinstance != null) {
						entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
						{
							Entity _ent = entityinstance;
							_ent.setYRot(entity.getYRot());
							_ent.setXRot(entity.getXRot());
							_ent.setYBodyRot(_ent.getYRot());
							_ent.setYHeadRot(_ent.getYRot());
							_ent.yRotO = _ent.getYRot();
							_ent.xRotO = _ent.getXRot();
							if (_ent instanceof LivingEntity _entity) {
								_entity.yBodyRotO = _entity.getYRot();
								_entity.yHeadRotO = _entity.getYRot();
							}
						}
						entityinstance.getPersistentData().putUUID("id", entity.getUUID());
						if (entityinstance instanceof FlayedmantailEntity _datEntSetI)
							_datEntSetI.getEntityData().set(FlayedmantailEntity.DATA_endnum, (int) index0);
						_serverLevel.addFreshEntity(entityinstance);
					}
				}
			} else {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entityinstance = DeaceasedModEntities.FLAYEDMANSECTIONS.get().create(_serverLevel, null, null, BlockPos.containing(x - entity.getLookAngle().x * index0, y, z - entity.getLookAngle().z * index0), MobSpawnType.MOB_SUMMONED,
							false, false);
					if (entityinstance != null) {
						entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
						{
							Entity _ent = entityinstance;
							_ent.setYRot(entity.getYRot());
							_ent.setXRot(entity.getXRot());
							_ent.setYBodyRot(_ent.getYRot());
							_ent.setYHeadRot(_ent.getYRot());
							_ent.yRotO = _ent.getYRot();
							_ent.xRotO = _ent.getXRot();
							if (_ent instanceof LivingEntity _entity) {
								_entity.yBodyRotO = _entity.getYRot();
								_entity.yHeadRotO = _entity.getYRot();
							}
						}
						entityinstance.getPersistentData().putUUID("id", entity.getUUID());
						if (entityinstance instanceof FlayedmansectionsEntity _datEntSetI)
							_datEntSetI.getEntityData().set(FlayedmansectionsEntity.DATA_sectionnum, (int) index0);
						_serverLevel.addFreshEntity(entityinstance);
					}
				}
			}
		}
	}
}
