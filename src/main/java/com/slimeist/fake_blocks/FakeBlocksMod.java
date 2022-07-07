package com.slimeist.fake_blocks;

import eu.pb4.polymer.api.entity.PolymerEntityUtils;
import eu.pb4.polymer.api.resourcepack.PolymerModelData;
import eu.pb4.polymer.api.resourcepack.PolymerRPUtils;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FakeBlocksMod implements DedicatedServerModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "fake_blocks";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitializeServer() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("FakeBlocks loading");

		if (PolymerRPUtils.addAssetSource(MOD_ID)) {
			LOGGER.info("Successfully marked as asset source");
		} else {
			LOGGER.error("Failed to mark FakeBlocks as asset source");
		}
		PolymerRPUtils.markAsRequired();
	}

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}
}
