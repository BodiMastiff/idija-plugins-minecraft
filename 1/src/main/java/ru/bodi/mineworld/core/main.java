package ru.bodi.mineworld.core;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import ru.bodi.mineworld.core.Void.VoidCMD;
import ru.bodi.mineworld.core.cmds.core;
import ru.bodi.mineworld.core.listeners.Join;
import ru.bodi.mineworld.core.listeners.other;
import ru.bodi.mineworld.core.spawn.SpawnCMD;

public final class main extends JavaPlugin {

    private final String key = "7IEKi9T3N6n";
    public static main instance;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        onLoad();
        if (this.getConfig().getString("Key").equals("7IEKi9T3N6n")) {
            Bukkit.getConsoleSender().sendMessage("§6§lMINE§e§lWORLD§7: §fAccept key");
            main.instance = this;
            new SpawnCMD();
            new core();
            new VoidCMD();
            main.getInstance().getServer().getPluginManager().registerEvents((Listener) new Join(), this);
            main.getInstance().getServer().getPluginManager().registerEvents((Listener) new other(), this);
        }
        else {
            Bukkit.getConsoleSender().sendMessage("§6§lMINE§e§lWORLD§7: §fIncorrect §cKey");
            this.getServer().getPluginManager().disablePlugin((Plugin)this);
        }
    }

    @Override
    public void onDisable() {
        onUnLoad();
    }

    public void onLoad() {
        Bukkit.getConsoleSender().sendMessage("§6§lMINE§e§lWORLD§7: §fLoading §bcore");
    }

    public void onUnLoad() {
        Bukkit.getConsoleSender().sendMessage("§6§lMINE§e§lWORLD§7: §fUnLoading §bcore");
    }
    public static main getInstance() {
        return instance;
    }
}
