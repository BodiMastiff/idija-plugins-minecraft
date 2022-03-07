package ru.mineworld.core.spawn;


import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.configuration.file.*;
import org.bukkit.*;
import ru.mineworld.core.Main;

public class Utils
{
    public static void sendMessage(final CommandSender p, final String msg) {
        p.sendMessage(Main.instance.getConfig().getString(msg).replace("&", "§"));
    }

    public static void setSpawn(final Player p) {
        final FileConfiguration cfg = Main.instance.getConfig();
        cfg.set("Spawn.Spawn.world", (Object)String.valueOf(p.getWorld().getName()));
        cfg.set("Spawn.Spawn.x", (Object)p.getLocation().getX());
        cfg.set("Spawn.Spawn.y", (Object)p.getLocation().getY());
        cfg.set("Spawn.Spawn.z", (Object)p.getLocation().getZ());
        cfg.set("Spawn.Spawn.yaw", (Object)p.getLocation().getYaw());
        cfg.set("Spawn.Spawn.pitch", (Object)p.getLocation().getPitch());
        Main.instance.saveConfig();
    }

    public static void teleportSpawn(final Player p) {
        final World w = Bukkit.getWorld(Main.instance.getConfig().getString("Spawn.Spawn.world"));
        final double x = Main.instance.getConfig().getDouble("Spawn.Spawn.x");
        final double y = Main.instance.getConfig().getDouble("Spawn.Spawn.y");
        final double z = Main.instance.getConfig().getDouble("Spawn.Spawn.z");
        final double yaw = Main.instance.getConfig().getDouble("Spawn.Spawn.yaw");
        final double pitch = Main.instance.getConfig().getDouble("Spawn.Spawn.pitch");
        final Location loc = new Location(w, x, y, z, (float)yaw, (float)pitch);
        p.teleport(loc);
        if (Main.instance.getConfig().getBoolean("Spawn.Sound-enable")) {
            final String sound = Main.instance.getConfig().getString("HyperSpawn.Sound");
            w.playSound(p.getLocation(), Sound.valueOf(sound), 10.0f, 1.0f);
        }
    }
}
