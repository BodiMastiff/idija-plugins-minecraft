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
        cfg.set("HyperSpawn.Spawn.world", (Object)String.valueOf(p.getWorld().getName()));
        cfg.set("HyperSpawn.Spawn.x", (Object)p.getLocation().getX());
        cfg.set("HyperSpawn.Spawn.y", (Object)p.getLocation().getY());
        cfg.set("HyperSpawn.Spawn.z", (Object)p.getLocation().getZ());
        cfg.set("HyperSpawn.Spawn.yaw", (Object)p.getLocation().getYaw());
        cfg.set("HyperSpawn.Spawn.pitch", (Object)p.getLocation().getPitch());
        Main.instance.saveConfig();
    }

    public static void teleportSpawn(final Player p) {
        final World w = Bukkit.getWorld(Main.instance.getConfig().getString("HyperSpawn.Spawn.world"));
        final double x = Main.instance.getConfig().getDouble("HyperSpawn.Spawn.x");
        final double y = Main.instance.getConfig().getDouble("HyperSpawn.Spawn.y");
        final double z = Main.instance.getConfig().getDouble("HyperSpawn.Spawn.z");
        final double yaw = Main.instance.getConfig().getDouble("HyperSpawn.Spawn.yaw");
        final double pitch = Main.instance.getConfig().getDouble("HyperSpawn.Spawn.pitch");
        final Location loc = new Location(w, x, y, z, (float)yaw, (float)pitch);
        p.teleport(loc);
        if (Main.instance.getConfig().getBoolean("HyperSpawn.Sound-enable")) {
            final String sound = Main.instance.getConfig().getString("HyperSpawn.Sound");
            w.playSound(p.getLocation(), Sound.valueOf(sound), 10.0f, 1.0f);
        }
    }
}
