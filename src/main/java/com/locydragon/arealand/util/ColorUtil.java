package com.locydragon.arealand.util;

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
}
