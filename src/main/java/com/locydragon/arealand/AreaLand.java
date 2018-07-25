package com.locydragon.arealand;

import com.locydragon.arealand.api.Land;
import com.locydragon.arealand.api.LandApi;
import com.locydragon.arealand.cloud.LandLoading;
import com.locydragon.arealand.commands.CommandMenu;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LocyDragon
 */
public class AreaLand extends JavaPlugin {
	public static FileConfiguration save = null;
	public static FileConfiguration config = null;
	public static double readPerSecond = -1;
	public static AreaLand instance;
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
		for (String eachLand : getConfig().getStringList("created")) {
			Land target = LandApi.getByName(eachLand);
			LandLoading.landNameSave.put(eachLand, target);
			List<Land> worldLand = LandLoading.landWorldSave.get(target.inWhich.getName());
			if (worldLand == null) {
				worldLand = new ArrayList<>();
			}
			worldLand.add(target);
			LandLoading.landWorldSave.replace(target.inWhich.getName(), worldLand);
		}
		//Read config
		readPerSecond = getConfig().getDouble("read.second");

		instance = this;
	}
}
