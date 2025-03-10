package com.teamabnormals.neapolitan.core;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import org.apache.commons.lang3.tuple.Pair;

public class NeapolitanConfig {
	public static class Common {
		public final ConfigValue<Boolean> milkCauldron;
		public final ConfigValue<Boolean> milkFromDripstones;
		public final ConfigValue<Boolean> milkingWithGlassBottles;
		public final ConfigValue<Boolean> milkshakeCauldrons;

		public final ConfigValue<Integer> whiteStrawberryMinHeight;
		public final ConfigValue<Boolean> strawberryBushArthropodInvisibility;

		public final ConfigValue<Boolean> plantainSpidersFromBundles;
		public final ConfigValue<Boolean> plantainSpidersGiveSlipping;

		public final ConfigValue<Double> chimpanzeeGroupChance;
		public final ConfigValue<Integer> chimpanzeeMaxGroupSize;
		public final ConfigValue<Integer> chimpanzeeMinSpawnAttempts;
		public final ConfigValue<Integer> chimpanzeeMaxSpawnAttempts;

		public final ConfigValue<Boolean> suspiciousBananaPlants;
		public final ConfigValue<Double> suspiciousBananaPlantChance;
		public final ConfigValue<Integer> suspiciousGravelMin;
		public final ConfigValue<Integer> rareSuspiciousGravelMin;

		Common(ForgeConfigSpec.Builder builder) {
			builder.push("items");
			builder.push("milk_bottles");
			milkCauldron = builder.comment("If milk can be inserted into cauldrons").define("Milk Cauldron", true);
			milkFromDripstones = builder.comment("If cauldrons are filled with milk dropping from a dripstone").define("Milk from Dripstone", true);
			milkingWithGlassBottles = builder.comment("If milkable mobs can be milked with empty glass bottles").define("Milking with Glass Bottles", false);
			milkshakeCauldrons = builder.comment("If milkshakes can be inserted into cauldrons").define("Milkshake Cauldrons", true);
			builder.pop();
			builder.pop();
			builder.push("blocks");
			builder.push("strawberry_bush");
			whiteStrawberryMinHeight = builder.comment("The minimum height required for Strawberry Bushes to grow White Strawberries").define("White Strawberry minimum height", 256);
			strawberryBushArthropodInvisibility = builder.comment("If arthropods that go through Strawberry Bushes are given Invisibility").define("Strawberry Bushes give arthropods Invisibility", true);
			builder.pop();
			builder.pop();
			builder.push("mobs");
			builder.push("plantain_spider");
			plantainSpidersFromBundles = builder.define("Plantain Spider spawn from Banana Bundles", true);
			plantainSpidersGiveSlipping = builder.define("Plantain Spiders give Slipping", true);
			builder.pop();
			builder.push("chimpanzee");
			chimpanzeeGroupChance = builder.comment("The percentage chance for a Banana Plant to generate with a group of Chimpanzees").define("Chimpanzee group chance", 0.25D);
			chimpanzeeMaxGroupSize = builder.comment("The maximum amount of Chimpanzees that can spawn with a Banana Plant").define("Chimpanzee maximum group size", 10);
			chimpanzeeMinSpawnAttempts = builder.comment("The minimum attempts for Chimpanzees to spawn with a Banana Plant").define("Chimpanzee minimum spawn attempts", 12);
			chimpanzeeMaxSpawnAttempts = builder.comment("The maximum attempts for Chimpanzees to spawn with a Banana Plant").define("Chimpanzee maximum spawn attempts", 24);
			builder.pop();
			builder.pop();
			builder.push("worldgen");
			builder.push("suspicious_banana_plant");
			suspiciousBananaPlants = builder.comment("If Banana Plants can rarely generate with Suspicious Gravel and archaeology").define("Suspicious Banana Plants", true);
			suspiciousBananaPlantChance = builder.comment("The percentage chance for a Suspicious Banana Plant to generate").define("Suspicious Banana Plant chance", 0.08D);
			suspiciousGravelMin = builder.comment("The minimum amount of Suspicious Gravel total that can spawn at a Suspicious Banana Plant").define("Common Suspicious Gravel minimum", 8);
			rareSuspiciousGravelMin = builder.comment("The minimum amount of Suspicious Gravel with the rare archaeology loot table that can spawn at a Suspicious Banana Plant").define("Rare Suspicious Gravel minimum", 2);
			builder.pop();
			builder.pop();
		}
	}

	public static final ForgeConfigSpec COMMON_SPEC;
	public static final Common COMMON;

	static {
		final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
		COMMON_SPEC = specPair.getRight();
		COMMON = specPair.getLeft();
	}
}
