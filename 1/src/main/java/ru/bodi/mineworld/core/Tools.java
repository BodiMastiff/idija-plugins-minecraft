package ru.bodi.mineworld.core;


import org.bukkit.plugin.java.*;

public class Tools
{
    private static JavaPlugin instance;

    public static JavaPlugin getInstance() {
        return Tools.instance;
    }

    public static void setInstance(final JavaPlugin instance) {
        Tools.instance = instance;
    }
}
