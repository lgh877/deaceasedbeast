package net.mcreator.deaceased.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.deaceased.entity.FlayedmantailEntity;

public class FlayedmantailModel extends GeoModel<FlayedmantailEntity> {
	@Override
	public ResourceLocation getAnimationResource(FlayedmantailEntity entity) {
		return new ResourceLocation("deaceased", "animations/centipedesections_head.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FlayedmantailEntity entity) {
		return new ResourceLocation("deaceased", "geo/centipedesections_head.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FlayedmantailEntity entity) {
		return new ResourceLocation("deaceased", "textures/entities/" + entity.getTexture() + ".png");
	}

}
