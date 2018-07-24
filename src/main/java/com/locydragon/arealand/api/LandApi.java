package com.locydragon.arealand.api;

import com.locydragon.arealand.AreaLand;
import com.locydragon.arealand.cloud.LandLoading;
import com.locydragon.arealand.util.SaveUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class LandApi {
	public static Land createLand(Selection selection, String landName, Player creater) {
		if (isLandCreated(landName)) {
			return null;
		}
		SaveUtil.addInList("created", landName);
		AreaLand.save.set("land."+landName+".world", selection.getWhere().getName());
		AreaLand.save.set("land."+landName+".owner", creater.getName());
		Land createLand = new Land(selection.getA(), selection.getB(), landName);
		createLand.ownerName = creater.getName();
		createLand.inWhich = Bukkit.getWorld(selection.getWhere().getName());
		createLand.save();
		LandLoading.landNameSave.put(landName, createLand);
		List<Land> worldLand = LandLoading.landWorldSave.get(selection.getWhere().getName());
		if (worldLand == null) {
			worldLand = new ArrayList<>();
		}
		worldLand.add(createLand);
		LandLoading.landWorldSave.replace(selection.getWhere().getName(), worldLand);
		return createLand;
	}
    public static boolean isLandCreated(String landName) {
		return AreaLand.save.getStringList("created").contains(landName);
	}
	public static Land getByName(String landName) {
		if (!isLandCreated(landName)) {
			return null;
		}
		Vector locA = new Vector(AreaLand.save.getInt("land."+landName+".A.x"),
				AreaLand.save.getInt("land."+landName+".A.y"), AreaLand.save.getInt("land."+landName+".A.z"));
		Vector locB = new Vector(AreaLand.save.getInt("land."+landName+".B.x"),
				AreaLand.save.getInt("land."+landName+".B.y"), AreaLand.save.getInt("land."+landName+".B.z"));
		return new Land(locA, locB, landName);
	}
}
