package com.locydragon.arealand.api;

import java.util.Vector;

public class Land {
	private Vector locA;
	private Vector locB;
	private String landName;
	protected Land(Vector locA, Vector locB, String landName) {
		this.locA = locA;
		this.locB = locB;
		this.landName = landName;
	}
	public static boolean save() {
		return true;
	}
	public static int getSize() {
		return -1;
	}
}
