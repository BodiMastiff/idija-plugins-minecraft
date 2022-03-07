package ru.bestrax.zencore;

import org.bukkit.plugin.java.*;
import net.milkbowl.vault.economy.*;
import org.bukkit.event.*;
import org.bukkit.plugin.*;

public class Main extends JavaPlugin
{
    public static Economy econ;
    
    public void onEnable() {
        this.loadPlugin();
    }
    
    private boolean setupEconomy() {
        if (this.getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        final RegisteredServiceProvider<Economy> rsp = (RegisteredServiceProvider<Economy>)this.getServer().getServicesManager().getRegistration((Class)Economy.class);
        if (rsp == null) {
            return false;
        }
        Main.econ = (Economy)rsp.getProvider();
        return Main.econ != null;
    }
    
    void loadPlugin() {
        this.loadConfig();
        this.loadMessages();
        this.setupEconomy();
        this.loadUtils();
        this.loadCommands();
        this.loadListeners();
    }
    
    void loadConfig() {
        this.saveDefaultConfig();
    }
    
    void loadUtils() {
        Utils.init(this);
    }
    
    void loadCommands() {
        new NearCmd(this);
        new DayCmd(this);
        new NightCmd(this);
    }
    
    void loadListeners() {
        this.getServer().getPluginManager().registerEvents((Listener)new EventCrossbreeding(this), (Plugin)this);
    }
    
    void loadMessages() {
        Messages.init(this);
    }
}
