package ru.mineworld.core;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class DayCmd implements CommandExecutor
{
    private Main plugin;
    
    public DayCmd(final Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("day").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender commandSender, final Command command, final String s, final String[] args) {
        if (!(commandSender instanceof Player)) {
            return false;
        }
        final Player p = (Player)commandSender;
        if (p.hasPermission("zencore.day")) {
            final int dayTick = 0;
            p.getWorld().setTime(0L);
            for (final String line : this.plugin.getConfig().getStringList("messages.dayChangedMessage")) {
                Bukkit.broadcastMessage(this.parseColor(line.replace("%player%", p.getPlayer().getName())));
            }
            p.playSound(p.getLocation(), Sounds.VILLAGER_YES.bukkitSound(), 2.0f, 1.0f);
        }
        else {
            p.sendMessage(this.parseColor(Messages.NO_PERMS_TIME));
            p.playSound(p.getLocation(), Sounds.VILLAGER_NO.bukkitSound(), 2.0f, 1.0f);
        }
        return true;
    }
    
    public String parseColor(final String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }
}
