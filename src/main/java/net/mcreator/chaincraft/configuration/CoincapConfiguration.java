package net.mcreator.chaincraft.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class CoincapConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Double> BTC_CAP;
	public static final ForgeConfigSpec.ConfigValue<Double> ETH_CAP;
	public static final ForgeConfigSpec.ConfigValue<Double> USDT_CAP;
	public static final ForgeConfigSpec.ConfigValue<Double> SOL_CAP;
	public static final ForgeConfigSpec.ConfigValue<Double> DOGE_CAP;
	public static final ForgeConfigSpec.ConfigValue<Double> ADA_CAP;
	static {
		BUILDER.push("coin_cap");
		BTC_CAP = BUILDER.define("", (double) 0);
		ETH_CAP = BUILDER.define("", (double) 0);
		USDT_CAP = BUILDER.define("", (double) 0);
		SOL_CAP = BUILDER.define("", (double) 0);
		DOGE_CAP = BUILDER.define("", (double) 0);
		ADA_CAP = BUILDER.define("", (double) 0);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
