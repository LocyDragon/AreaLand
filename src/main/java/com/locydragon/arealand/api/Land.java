package com.locydragon.arealand.api;


import com.locydragon.arealand.AreaLand;
import com.locydragon.arealand.util.SaveUtil;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.util.Vector;

public class Land {
	public Vector locA;
	public Vector locB;
	public String landName;
	public World inWhich;
	public String ownerName;
	protected Land(Vector locA, Vector locB, String landName) {
		if (StringUtils.isBlank(landName)) {
			throw new NullPointerException("Name cannot be null");
		}
		this.locA = locA;
		this.locB = locB;
		this.landName = landName;
		this.inWhich = Bukkit.getWorld(AreaLand.save.getString("land."+landName+".world"));
		this.ownerName = AreaLand.save.getString("land."+landName+".owner");
	}
	public void setOwnerName(String who) {
		this.ownerName = who;
	}
	public boolean save() {
		AreaLand.save.set("land."+landName+".A.x", locA.getBlockX());
		AreaLand.save.set("land."+landName+".A.y", locA.getBlockY());
		AreaLand.save.set("land."+landName+".A.z", locA.getBlockZ());
		AreaLand.save.set("land."+landName+".B.x", locB.getBlockX());
		AreaLand.save.set("land."+landName+".B.y", locB.getBlockY());
		AreaLand.save.set("land."+landName+".B.z", locB.getBlockZ());
		AreaLand.save.set("land."+landName+".owner", this.ownerName);
		AreaLand.save.set("land."+landName+".world", this.inWhich.getName());
		SaveUtil.save();
		return true;
	}
	public int getSize() {
		return Math.abs(locA.getBlockX() - locB.getBlockX()) * Math.abs(locA.getBlockY() - locB.getBlockY()) *
				Math.abs(locA.getBlockZ() - locB.getBlockZ());
	}
}
