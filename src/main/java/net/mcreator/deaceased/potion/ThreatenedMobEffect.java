
package net.mcreator.deaceased.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class ThreatenedMobEffect extends MobEffect {
	public ThreatenedMobEffect() {
		super(MobEffectCategory.NEUTRAL, -6750208);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
