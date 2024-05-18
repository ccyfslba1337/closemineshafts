package com.BannedMineshaft;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

import java.io.FileReader;
import java.io.IOException;

public class BannedMineshaft implements ModInitializer {
	public static double abandonedMineshaftSpawnRate;

	@Override
	public void onInitialize() {
		try {
			FileReader reader = new FileReader(FabricLoader.getInstance().getConfigDir().resolve("config.json").toFile());
			JsonObject config = new Gson().fromJson(reader, JsonObject.class);
			abandonedMineshaftSpawnRate = config.get("abandoned_mineshaft_spawn_rate").getAsDouble();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
