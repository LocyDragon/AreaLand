package com.locydragon.arealand.async;

import com.locydragon.arealand.AreaLand;
import com.locydragon.arealand.api.Land;
import com.locydragon.arealand.api.events.LandChangeEvent;
import com.locydragon.arealand.util.LandUtil;
import org.bukkit.Bukkit;

public class PlayerLandFindThread extends Thread {
	public Land lastLand = null;
	public Land nowLand = null;
	public String playerName = null;
	private boolean breakMe = false;
	public PlayerLandFindThread(String playerName) {
		this.playerName = playerName;
	}
	@Override
	public void run() {
		while (!breakMe) {
			try {
				lastLand = nowLand;
				nowLand = LandUtil.checkNowLand(this.playerName);
				if (!lastLand.equals(nowLand)) {
					Bukkit.getScheduler().runTask(AreaLand.instance, new Runnable() {
						@Override
						public void run() {
							LandChangeEvent event = new LandChangeEvent(Bukkit.getPlayer(playerName));
							event.setBefore(lastLand);
							event.setAfter(nowLand);
							Bukkit.getPluginManager().callEvent(event);
						}
					});
				}
				Thread.sleep((long)(1000 * AreaLand.readPerSecond));
				if (Bukkit.getPlayer(this.playerName) == null) {
					this.breakMe = true;
				}
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		}
	}
	public void stopMe() {
		this.breakMe = true;
	}
}
