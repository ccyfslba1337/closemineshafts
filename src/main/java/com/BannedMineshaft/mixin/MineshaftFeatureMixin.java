package com.BannedMineshaft.mixin;

import com.BannedMineshaft.BannedMineshaft;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.gen.ChunkRandom;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.MineshaftFeature;
import net.minecraft.world.gen.feature.MineshaftFeatureConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MineshaftFeature.class)
public class MineshaftFeatureMixin {
	@Inject(method = "shouldStartAt", at = @At("HEAD"), cancellable = true)
	private void modifySpawnRate(ChunkGenerator chunkGenerator, BiomeSource biomeSource, long l, ChunkRandom chunkRandom, int i, int j, Biome biome, ChunkPos chunkPos, MineshaftFeatureConfig mineshaftFeatureConfig, CallbackInfoReturnable<Boolean> cir) {
		// 在这里修改废弃矿井的生成概率
		if (Math.random() > BannedMineshaft.abandonedMineshaftSpawnRate) {
			cir.setReturnValue(false);
		}
	}
}