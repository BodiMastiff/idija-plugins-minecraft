package ru.bodi.mineworld.core.spawn;

import org.bukkit.command.*;
import ru.bodi.mineworld.*;
import org.bukkit.entity.*;
import org.bukkit.configuration.file.*;
import org.bukkit.*;
import ru.bodi.mineworld.core.main;

public class SpawnUtils
{
    public static void sendMessage(final CommandSender p, final String msg) {
        p.sendMessage(main.getInstance().getConfig().getString(msg).replace("&", "§"));
    }

    public static void setSpawn(final Player p) {
        final FileConfiguration cfg = main.getInstance().getConfig();
        cfg.set("Spawn.Location.world", (Object)String.valueOf(p.getWorld().getName()));
        cfg.set("Spawn.Location.x", (Object)p.getLocation().getX());
        cfg.set("Spawn.Location.y", (Object)p.getLocation().getY());
        cfg.set("Spawn.Location.z", (Object)p.getLocation().getZ());
        cfg.set("Spawn.Location.yaw", (Object)p.getLocation().getYaw());
        cfg.set("Spawn.Location.pitch", (Object)p.getLocation().getPitch());
        main.getInstance().saveConfig();
    }

    public static void teleportSpawn(final Player p) {
        final World w = Bukkit.getWorld(main.getInstance().getConfig().getString("Spawn.Location.world"));
        final double x = main.getInstance().getConfig().getDouble("Spawn.Location.x");
        final double y = main.getInstance().getConfig().getDouble("Spawn.Location.y");
        final double z = main.getInstance().getConfig().getDouble("Spawn.Location.z");
        final double yaw = main.getInstance().getConfig().getDouble("Spawn.Location.yaw");
        final double pitch = main.getInstance().getConfig().getDouble("Spawn.Location.pitch");
        final Location loc = new Location(w, x, y, z, (float)yaw, (float)pitch);
        p.teleport(loc);
        if (main.getInstance().getConfig().getBoolean("Spawn.Sound-enable")) {
            final String sound = main.getInstance().getConfig().getString("Spawn.Sound");
            w.playSound(p.getLocation(), Sound.valueOf(sound), 10.0f, 1.0f);
        }
    }
}
