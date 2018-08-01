package com.locydragon.arealand.util;

import com.locydragon.arealand.AreaLand;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class ColorUtil {
	public static List<String> addColor(List<String> needAdd) {
		List<String> newList = new ArrayList<>();
		for (String each : needAdd) {
			newList.add(ChatColor.translateAlternateColorCodes('&', each));
		}
		return newList;
	}
	public static String getColor(String needColor) {
		return ChatColor.translateAlternateColorCodes('&', needColor);
	}
	public static String getConfigColor(String path) {
		return getColor(AreaLand.save.getString(path));
	}
	public static List<String> getListConfigColor(String path) {
		return addColor(AreaLand.save.getStringList(path));
	}
}
