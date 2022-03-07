package ru.bodi.mineworld.core;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import java.util.*;

public class NearCmd implements CommandExecutor
{
    private Main plugin;

    public NearCmd(final Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("near").setExecutor((CommandExecutor)this);
    }

    public boolean onCommand(final CommandSender commandSender, final Command command, final String s, final String[] args) {
        if (!(commandSender instanceof Player)) {
            System.out.println("NEAR | Додик что-ли?");
        }
        final Player player = (Player)commandSender;
        if (!player.hasPermission(Utils.PERMISSION)) {
            player.sendMessage(Utils.NO_PERMS);
            return false;
        }
        final StringBuilder message = new StringBuilder();
        int findPlayers = 0;
        final int dis = 200;
        final TreeMap<Double, Player> treeMap = new TreeMap<Double, Player>();
        final Location location = player.getLocation();
        for (final Player p : Bukkit.getOnlinePlayers()) {
            if (!location.getWorld().equals(p.getLocation().getWorld())) {
                continue;
            }
            if (p.getUniqueId().equals(player.getUniqueId())) {
                continue;
            }
            final double distance = location.distance(p.getLocation());
            if (dis < distance) {
                continue;
            }
            if (!player.canSee(p)) {
                continue;
            }
            treeMap.put(distance, p);
        }
        for (final Map.Entry<Double, Player> entry : treeMap.entrySet()) {
            ++findPlayers;
            entry.getKey();
            final Double aDouble = entry.getKey() * 100.0 / 100.0;
            final int dost = (int)(Object)aDouble;
            message.append(Utils.NEAR.replace("%player%", entry.getValue().getName()).replace("%distance%", "" + dost).replace("%gamemode%", (entry.getValue().getGameMode() == GameMode.CREATIVE) ? Utils.CREATIVE : "").replace("%where%", CMIDirection.getFromLocations(entry.getValue().getLocation(), player.getLocation()).getName()));
            message.append(". ");
        }
        if (findPlayers == 0) {
            player.sendMessage(Utils.NO_PLAYERS);
            return false;
        }
        player.sendMessage(Utils.RESULT.replace("%count%", "" + findPlayers));
        player.sendMessage(message.toString());
        return true;
    }
}
