package net.mcreator.deaceased.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class DeceasedmobsConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Double> FCD;
	public static final ForgeConfigSpec.ConfigValue<Double> CSN;
	public static final ForgeConfigSpec.ConfigValue<Double> GBN;
	public static final ForgeConfigSpec.ConfigValue<Double> GBR;
	public static final ForgeConfigSpec.ConfigValue<Double> DAD;
	public static final ForgeConfigSpec.ConfigValue<Double> AWA;
	public static final ForgeConfigSpec.ConfigValue<Double> BDAD;
	public static final ForgeConfigSpec.ConfigValue<Double> BAWA;
	public static final ForgeConfigSpec.ConfigValue<Double> BSC;
	static {
		FCD = BUILDER.comment("Note that the thinner the cooldown, the more unlikely the face will avoid the target at close range since its prob gonna be busy throwing things").define("The Face throwing cool down", (double) 0);
		CSN = BUILDER.comment("Having this value less than 3 will cause the game to crash, remember that the more segment, the more longer the distance things have to render. (keep it not more than 15)").define("Centipede segments number",
				(double) 15);
		GBN = BUILDER.comment("This only apply upon spawning, settign this lower than one would prob cause a crash").define("Guardian default amount of buggers", (double) 8);
		GBR = BUILDER.comment("The amount of bugger will be randomized in the range for example 2 with default 8 buggers amount will range from 6-8").define("Guardian buggers amount range", (double) 2);
		DAD = BUILDER.define("Digger's Wave DMG", (double) 3);
		AWA = BUILDER.define("Digger's Wave Area", (double) 3);
		BDAD = BUILDER.define("Black Digger's Wave DMG", (double) 3);
		BAWA = BUILDER.define("Black Digger's Wave DMG", (double) 5);
		BSC = BUILDER.define("Black Digger Spawning Chance", (double) 0.12);

		SPEC = BUILDER.build();
	}

}
