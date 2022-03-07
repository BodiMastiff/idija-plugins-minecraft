package ru.bodi.mineworld.core.listeners;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import ru.bodi.mineworld.core.main;

public class Void implements Listener {


    @EventHandler
    public void onMove(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        final FileConfiguration cfg = main.getInstance().getConfig();
        cfg.set("Void.world", (Object)String.valueOf(p.getWorld().getName()));
        if (e.getPlayer().getLocation().getY() <= main.getInstance() .getConfig().getInt("Void.Y")) {
            e.getPlayer().performCommand(main.getInstance().getConfig().getString("Void.Command"));
            p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 50, 20));
            p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 150, 60));
            main.instance.saveConfig();
        }
    }
}
