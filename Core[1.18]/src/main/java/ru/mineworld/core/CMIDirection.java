package ru.mineworld.core;

import org.bukkit.*;
import org.bukkit.util.*;

public enum CMIDirection
{
    N("N", 0, Utils.NORTH, 0, 0, -1), 
    NE("NE", 1, Utils.NORTH_EAST, 45, 1, -1), 
    E("E", 2, Utils.EAST, 90, 1, 0), 
    SE("SE", 3, Utils.SOUTH_EAST, 135, 1, 1), 
    S("S", 4, Utils.SOUTH, 180, 0, 1), 
    SW("SW", 5, Utils.SOUTH_EAST, 225, -1, 1), 
    W("W", 6, Utils.WEST, 270, -1, 0), 
    NW("NW", 7, Utils.NORTH_WEST, 315, -1, 1);
    
    private int angle;
    private String name;
    private int x;
    private int z;
    
    private CMIDirection(final String s, final int n, final String name, final int angle, final int x, final int z) {
        this.x = 0;
        this.z = 0;
        this.name = name;
        this.angle = angle;
        this.x = x;
        this.z = z;
    }
    
    private CMIDirection(final String s, final int n, final String name, final int angle) {
        this.x = 0;
        this.z = 0;
        this.name = name;
        this.angle = angle;
    }
    
    public static CMIDirection getFromAngle(final double n) {
        CMIDirection[] values;
        for (int length = (values = values()).length, i = 0; i < length; ++i) {
            final CMIDirection cmiDirection = values[i];
            final double n2 = cmiDirection.getAngle() - n;
            if (((n2 < 0.0) ? (-n2) : n2) <= 22.5) {
                return cmiDirection;
            }
        }
        return CMIDirection.N;
    }
    
    public int getAngle() {
        return this.angle;
    }
    
    public String getName() {
        return this.name;
    }
    
    public static Location rotateOnAxisDistance(final Location location, final double n, final double n2, final double n3) {
        return location.clone().add(rotateOnAxisDistanceVector(location, n, n2, n3));
    }
    
    public static Vector rotateOnAxisDistanceVector(final Location location, final double n, final double n2, final double n3) {
        final double n4 = location.getYaw() / 180.0 * 3.141592653589793;
        final double n5 = location.getPitch() / 180.0 * 3.141592653589793;
        final double radians = Math.toRadians(n2);
        final Vector vector = new Vector(Math.sin(radians) * n * Math.cos(0.017453292519943295 * n3), Math.cos(radians) * n, Math.sin(radians) * n * Math.sin(0.017453292519943295 * n3));
        vector.setY(Math.cos(n5) * vector.getY() - Math.sin(n5) * vector.getZ()).setZ(Math.sin(n5) * vector.getY() + Math.cos(n5) * vector.getZ());
        vector.setX(Math.cos(-n4) * vector.getX() + Math.sin(-n4) * vector.getZ()).setZ(-Math.sin(-n4) * vector.getX() + Math.cos(-n4) * vector.getZ());
        return vector;
    }
    
    public static float getAngle(final Location location, final Location location2) {
        final Vector subtract = location.toVector().subtract(location2.toVector());
        final Location clone = location.clone();
        clone.setDirection(subtract);
        return (clone.getYaw() + 540.0f) % 360.0f;
    }
    
    public static float getAngle(final float n) {
        return (n + 540.0f) % 360.0f;
    }
    
    public static CMIDirection getFromLocations(final Location location, final Location location2) {
        return getFromAngle(getAngle(location, location2));
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getZ() {
        return this.z;
    }
    
    public CMIDirection rotate90ClockWise() {
        final int n = this.getAngle() + 90;
        return getFromAngle((n > 360) ? (360 - n) : ((double)n));
    }
    
    public CMIDirection rotate90CounterClockWise() {
        final int n = this.getAngle() - 90;
        return getFromAngle((n < 0) ? (360 + n) : ((double)n));
    }
}
