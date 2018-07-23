package com.locydragon.arealand.api;

import com.locydragon.arealand.AreaLand;

public class LandApi {
	public static Land createLand(Selection selection, String landName) {
		if (isLandCreated(landName)) {
			return null;
		}

	}
    public static boolean isLandCreated(String landName) {
		return AreaLand.save.getStringList("created").contains(landName);
	}
}
