package net.fsmdev.biggerbarrels;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BiggerBarrels implements ModInitializer {
	public static final String MOD_ID = "biggerbarrels";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Bigger Barrels initialized!");
	}
}