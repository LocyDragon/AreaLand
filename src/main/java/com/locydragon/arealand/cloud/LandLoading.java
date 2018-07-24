package com.locydragon.arealand.cloud;

import com.locydragon.arealand.api.Land;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class LandLoading {
	public static ConcurrentHashMap<String,Land> landNameSave = new ConcurrentHashMap<>();
	public static ConcurrentHashMap<String,List<Land>> landWorldSave = new ConcurrentHashMap<>();
}
