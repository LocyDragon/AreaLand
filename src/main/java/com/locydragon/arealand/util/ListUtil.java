package com.locydragon.arealand.util;

import java.util.Vector;

public class ListUtil {
	public static boolean hasInGroup(Vector<String> group, String who) {
		for (String obj : group) {
			if (obj.equalsIgnoreCase(who)) {
				return true;
			}
		}
		return false;
	}
}
