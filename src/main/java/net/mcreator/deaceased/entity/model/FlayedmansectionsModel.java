package net.mcreator.deaceased.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.deaceased.entity.FlayedmansectionsEntity;

public class FlayedmansectionsModel extends GeoModel<FlayedmansectionsEntity> {
	@Override
	public ResourceLocation getAnimationResource(FlayedmansectionsEntity entity) {
		return new ResourceLocation("deaceased", "animations/centipedesections_head.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FlayedmansectionsEntity entity) {
		return new ResourceLocation("deaceased", "geo/centipedesections_head.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FlayedmansectionsEntity entity) {
		return new ResourceLocation("deaceased", "textures/entities/" + entity.getTexture() + ".png");
	}

}
