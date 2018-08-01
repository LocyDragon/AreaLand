package com.locydragon.arealand.listeners;

import com.locydragon.arealand.AreaLand;
import com.locydragon.arealand.util.ColorUtil;
import com.locydragon.arealand.util.ItemStackBuilder;
import com.locydragon.arealand.util.ListUtil;
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
import java.util.Vector;


public class LandGuiMain implements Listener {
	public static Inventory landGui = Bukkit.createInventory(null,
			54, ChatColor.translateAlternateColorCodes('&'
					, AreaLand.config.getString("lang.landUI.Title")));
	public static ItemStack getStickItem = null;
	public static ItemStack stickItem = null;
	public static Vector<String> wasGotItem = new Vector<>();

	static {
		getStickItem = ItemStackBuilder.getBuilder(Material.STICK)
				.name(ColorUtil.getColor(AreaLand.config.getString("lang.landUI.StickItem.name")))
				.lore(ColorUtil.addColor(AreaLand.config.getStringList("lang.landUI.StickItem.lore")))
				.build();
		stickItem = ItemStackBuilder.getBuilder(Material.STICK)
				.name(ColorUtil.getConfigColor("lang.Items.StickItem.name"))
				.lore(ColorUtil.getListConfigColor("lang.Items.StickItem.lore"))
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
				String playerName = e.getWhoClicked().getName();
				if (ListUtil.hasInGroup(wasGotItem, playerName)) {
					e.getWhoClicked().sendMessage(ColorUtil.getConfigColor("lang.landUI.StickItem.CannotGetNotice"));
					return;
				} else {
					e.getWhoClicked().sendMessage(ColorUtil.getConfigColor("lang.landUI.StickItem.GetItem"));
					target.getInventory().addItem(stickItem);
					try {
						target.updateInventory();
					} catch (Exception exc) {} finally {
						return;
					}
				}
			}
		} else {

		}
		target.updateInventory();
	}
}
