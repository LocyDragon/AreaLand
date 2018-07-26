package com.locydragon.arealand.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemStackBuilder {
	private ItemStack item;

	private ItemStackBuilder(Material material) {
		this.item = new ItemStack(material);
	}

	public ItemStackBuilder name(String name) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);
		return this;
	}

	public ItemStackBuilder lore(List<String> lore) {
		ItemMeta meta = item.getItemMeta();
		meta.setLore(lore);
		item.setItemMeta(meta);
		return this;
	}

	public ItemStack build() {
		return this.item;
	}

	public static ItemStackBuilder getBuilder(Material itemMaterial) {
		return new ItemStackBuilder(itemMaterial);
	}
}
