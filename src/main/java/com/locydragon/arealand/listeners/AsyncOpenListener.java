package com.locydragon.arealand.listeners;

import com.locydragon.arealand.async.PlayerLandFindThread;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;

public class AsyncOpenListener implements Listener {
	HashMap<String,PlayerLandFindThread> threadCache = new HashMap<>();
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		for (String obj : threadCache.keySet()) {
			if (obj.equalsIgnoreCase(e.getPlayer().getName())) {
				threadCache.remove(obj);
			}
		}
		PlayerLandFindThread thread = new PlayerLandFindThread(e.getPlayer().getName());
		thread.start();
		threadCache.put(e.getPlayer().getName(), thread);
	}
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		PlayerLandFindThread thread = threadCache.get(e.getPlayer().getName());
		thread.stopMe();
		threadCache.remove(e.getPlayer().getName());
	}
	@EventHandler
	public void onBeingKicked(PlayerKickEvent e) {
		PlayerLandFindThread thread = threadCache.get(e.getPlayer().getName());
		thread.stopMe();
		threadCache.remove(e.getPlayer().getName());
	}
}
