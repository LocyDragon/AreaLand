package com.locydragon.arealand.api;


import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;

public class Selection {
	private Vector a;
	private Vector b;
	private World where;

	private Selection(Vector a, Vector b, World where) {
		this.a = a;
		this.b = b;
		this.where = where;
	}

	public Vector getA() {
		return a;
	}

	public Vector getB() {
		return b;
	}

	public static Selection createSelection(Vector locA, Vector locB, World world) {
		return new Selection(locA, locB, world);
	}

	public static Selection createSelection(Location locA, Location locB, World world) {
		return createSelection(locA.toVector(), locB.toVector(), world);
	}

	public World getWhere() {
		return where;
	}
}
