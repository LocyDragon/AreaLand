package com.locydragon.arealand.api;


import org.bukkit.Location;
import org.bukkit.util.Vector;

public class Selection {
	private Vector a;
	private Vector b;

	private Selection(Vector a, Vector b) {
		this.a = a;
		this.b = b;
	}

	public Vector getA() {
		return a;
	}

	public Vector getB() {
		return b;
	}

	public static Selection createSelection(Vector locA, Vector locB) {
		return new Selection(locA, locB);
	}

	public static Selection createSelection(Location locA, Location locB) {
		return createSelection(locA.toVector(), locB.toVector());
	}
}
