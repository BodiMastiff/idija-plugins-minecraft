package bodi;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class core extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
