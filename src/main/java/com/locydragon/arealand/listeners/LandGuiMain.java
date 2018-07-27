package com.locydragon.arealand.listeners;

import com.locydragon.arealand.AreaLand;
import com.locydragon.arealand.util.ColorUtil;
import com.locydragon.arealand.util.ItemStackBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;


public class LandGuiMain implements Listener {
	public static Inventory landGui = Bukkit.createInventory(null,
			54, ChatColor.translateAlternateColorCodes('&'
					, AreaLand.config.getString("lang.landUI.Title")));
	public static ItemStack getStickItem = null;
	public static List<String> wasGotItem = new ArrayList<>();

	static {
		getStickItem = ItemStackBuilder.getBuilder(Material.STICK)
				.name(ColorUtil.getColor(AreaLand.config.getString("lang.landUI.StickItem.name")))
				.lore(ColorUtil.addColor(AreaLand.config.getStringList("lang.landUI.StickItem.lore")))
				.build();
		landGui.setItem(AreaLand.config.getInt("lang.landUI.StickItem.location", 41), getStickItem);
	}
	@EventHandler
	public void onGuiClick(InventoryClickEvent e) {
		e.setCancelled(true);
		if (e.getWhoClicked() instanceof Player) {
			return;
		}
		Player target = (Player)e.getWhoClicked();
		target.updateInventory();
		if (e.getInventory().equals(landGui)) {
			if (e.getCurrentItem().equals(getStickItem)) {

			}
		}
		target.updateInventory();
	}
}
