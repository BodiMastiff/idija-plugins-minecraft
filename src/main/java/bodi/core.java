package bodi;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class core extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("test");
        Bukkit.getConsoleSender().sendMessage("test");
        Bukkit.getConsoleSender().sendMessage("test");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
