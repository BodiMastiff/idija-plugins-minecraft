package ru.bodi.mcstrafe.mineworld;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Core extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("STARTING");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
