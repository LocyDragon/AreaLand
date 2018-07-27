package com.locydragon.arealand.commands;

import com.locydragon.arealand.AreaLand;
import com.locydragon.arealand.listeners.LandGuiMain;
import com.locydragon.arealand.util.ColorUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandMenu implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("如果您是后台,无法打开Land界面.");
			return false;
		}
		((Player) sender).openInventory(LandGuiMain.landGui); //Not complete yet.
		sender.sendMessage(ColorUtil.getColor(AreaLand.config.getString("OnOpen")));
		return false;
	}
}
