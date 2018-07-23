package com.locydragon.arealand.api;

import com.locydragon.arealand.AreaLand;
import com.locydragon.arealand.util.SaveUtil;
import org.bukkit.util.Vector;

public class LandApi {
	public static Land createLand(Selection selection, String landName) {
		if (isLandCreated(landName)) {
			return null;
		}
		SaveUtil.addInList("created", landName);
		AreaLand.save.set("land."+landName+".world", selection.getWhere().getName());
		Land createLand = new Land(selection.getA(), selection.getB(), landName);
		createLand.save();
		return createLand;
	}
    public static boolean isLandCreated(String landName) {
		return AreaLand.save.getStringList("created").contains(landName);
	}
	public static Land getByName(String landName) {
		if (!isLandCreated(landName)) {
			return null;
		}
		Vector locA = new Vector();
	}
}
