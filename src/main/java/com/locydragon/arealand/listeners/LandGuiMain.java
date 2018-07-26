package com.locydragon.arealand.listeners;

import com.locydragon.arealand.AreaLand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

public class LandGuiMain implements Listener {
	public static Inventory landGui = Bukkit.createInventory(null,
			54, ChatColor.translateAlternateColorCodes('&'
					, AreaLand.config.getString("lang.landUI.Title")));

}
