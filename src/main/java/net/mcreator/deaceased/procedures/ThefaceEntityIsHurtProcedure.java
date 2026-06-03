package net.mcreator.deaceased.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import java.util.ArrayList;

public class ThefaceEntityIsHurtProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ArrayList<Object> mobs = new ArrayList<>();
		ArrayList<Object> nonobmobs = new ArrayList<>();
		Entity targetmob = null;
		Entity chosenmobs = null;
		double dsx = 0;
		double dist = 0;
		double dsz = 0;
		double dsy = 0;
		double horizontalpower = 0;
		double endz = 0;
		double endy = 0;
		double endx = 0;
		double dx = 0;
		double dy = 0;
		double startz = 0;
		double dz = 0;
		double verticlepower = 0;
		double starty = 0;
		double sdist = 0;
		double startx = 0;
		if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 100) * 40 >= (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("deaceased:facepain")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("deaceased:facepain")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		}
	}
}
