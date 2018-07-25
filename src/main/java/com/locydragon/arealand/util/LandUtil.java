package com.locydragon.arealand.util;

import com.locydragon.arealand.api.Land;
import com.locydragon.arealand.cloud.LandLoading;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.List;


public class LandUtil {
	public static Land checkNowLand(String who) {
		Player target = Bukkit.getPlayer(who);
		Vector playerVec = target.getLocation().toVector();
		String inWorld = target.getWorld().getName();
		List<Land> allInWorld = LandLoading.landWorldSave.get(inWorld);
		for (Land each : allInWorld) {
			if (playerVec.isInAABB(each.locA, each.locB)) {
				return each;
			}
		}
		return null;
	}
}
