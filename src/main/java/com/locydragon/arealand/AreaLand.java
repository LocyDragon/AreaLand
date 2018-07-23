package com.locydragon.arealand;

import com.locydragon.arealand.commands.CommandMenu;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

/**
 * @author LocyDragon
 */
public class AreaLand extends JavaPlugin {
	public static FileConfiguration save = null;
	public static FileConfiguration config = null;
	@Override
	public void onEnable() {
		Bukkit.getLogger().info("Land领地插件已经启动");
		Bukkit.getLogger().info("作者: LocyDragon");
		saveDefaultConfig();
		config = getConfig();
		File saveFile = new File(".//plugins//AreaLand//land//save.yml");
		if (!saveFile.exists()) {
			saveFile.getParentFile().mkdirs();
			try {
				saveFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		save = YamlConfiguration.loadConfiguration(saveFile);
		Bukkit.getPluginCommand("land").setExecutor(new CommandMenu());
	}
}
