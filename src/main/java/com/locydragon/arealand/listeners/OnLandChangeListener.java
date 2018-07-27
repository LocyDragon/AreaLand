package com.locydragon.arealand.listeners;

import com.locydragon.arealand.AreaLand;
import com.locydragon.arealand.api.events.LandChangeEvent;
import com.locydragon.arealand.util.ColorUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnLandChangeListener implements Listener {
	@EventHandler
	public void onEvent(LandChangeEvent e) {
		if (e.getBefore() != null) {
			e.getPlayer().sendMessage(ColorUtil
					.getColor(AreaLand.save.getString("lang.ChangeLandMsg.Leave")
							.replace("{LandName}", e.getBefore().landName)));
		}
        if (e.getAfter() != null) {
			e.getPlayer().sendMessage(ColorUtil
					.getColor(AreaLand.save.getString("lang.ChangeLandMsg.Come")
							.replace("{LandName}", e.getBefore().landName)));
		}
	}
 }
