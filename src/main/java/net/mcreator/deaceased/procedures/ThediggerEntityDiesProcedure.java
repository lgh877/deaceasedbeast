package net.mcreator.deaceased.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.deaceased.entity.ThediggerEntity;

public class ThediggerEntityDiesProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((entity instanceof ThediggerEntity _datEntI ? _datEntI.getEntityData().get(ThediggerEntity.DATA_state) : 0) == 1 && (entity instanceof ThediggerEntity _datEntL1 && _datEntL1.getEntityData().get(ThediggerEntity.DATA_actionlock)) == true) {
			if (sourceentity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("deaceased:excavation"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		}
	}
}
