package com.locydragon.arealand.util;

import com.locydragon.arealand.AreaLand;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SaveUtil {
	public static boolean containsList(String listName, String target) {
		return AreaLand.save.getStringList(listName).contains(target);
	}
    public static void save() {
		try {
			AreaLand.save.save(new File(".//plugins//AreaLand//land//save.yml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void addInList(String listName, String target) {
		List<String> targetList = AreaLand.save.getStringList(listName);
		targetList.add(target);
		AreaLand.save.set(listName, targetList);
	}
}
