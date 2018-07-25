package com.locydragon.arealand.api.events;

import com.locydragon.arealand.api.Land;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class LandChangeEvent extends PlayerEvent {
	private static final HandlerList handlers = new HandlerList();
	private Player who;
	private Land before;
	private Land after;

	public LandChangeEvent(Player who) {
		super(who);
		this.who = who;
	}

	public void setBefore(Land before) {
		this.before = before;
	}

	public Land getBefore() {
		return before;
	}

	public void setAfter(Land after) {
		this.after = after;
	}

	public Land getAfter() {
		return after;
	}

	public Player getWho() {
		return who;
	}

	/* 这两个方法绝对不能少 */
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}
