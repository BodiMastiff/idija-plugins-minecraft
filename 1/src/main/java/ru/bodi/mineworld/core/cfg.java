package ru.bodi.mineworld.core;

import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import com.google.common.collect.*;
import java.util.*;

public class cfg
{
    private static String getPrefix() {
        return color(main.getInstance().getConfig().getString("prefix"));
    }

    public static String color(final String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static void sendMessage(final CommandSender sender, final List<String> message) {
        for (String line : message) {
            line = line.replace("%prefix%", getPrefix());
            sender.sendMessage(color(line));
        }
    }

    public static void sendMessage(final Player player, final List<String> message) {
        for (String line : message) {
            line = line.replace("%prefix%", getPrefix());
            player.sendMessage(color(line));
        }
    }

    public static void sendMessage(final Player player, final List<String> message, final ImmutableMap<String, String> placeholders) {
        for (String line : message) {
            line = line.replace("%prefix%", getPrefix());
            for (final Map.Entry<String, String> placeholder : placeholders.entrySet()) {
                line = line.replace(placeholder.getKey(), placeholder.getValue());
            }
            player.sendMessage(color(line));
        }
    }

    public static void sendMessage(final CommandSender sender, final List<String> message, final ImmutableMap<String, String> placeholders) {
        for (String line : message) {
            line = line.replace("%prefix%", getPrefix());
            for (final Map.Entry<String, String> placeholder : placeholders.entrySet()) {
                line = line.replace(placeholder.getKey(), placeholder.getValue());
            }
            sender.sendMessage(color(line));
        }
    }

    public static void sendConfigMessage(final CommandSender sender, final String path) {
        for (String line : main.getInstance().getConfig().getStringList(path)) {
            line = line.replace("%prefix%", getPrefix());
            sender.sendMessage(color(line));
        }
    }

    public static void sendConfigMessage(final Player player, final String path) {
        for (String line : main.getInstance().getConfig().getStringList(path)) {
            line = line.replace("%prefix%", getPrefix());
            player.sendMessage(color(line));
        }
    }

    public static void sendConfigMessage(final Player player, final String path, final ImmutableMap<String, String> placeholders) {
        for (String line : main.getInstance().getConfig().getStringList(path)) {
            line = line.replace("%prefix%", getPrefix());
            for (final Map.Entry<String, String> placeholder : placeholders.entrySet()) {
                line = line.replace(placeholder.getKey(), placeholder.getValue());
            }
            player.sendMessage(color(line));
        }
    }

    public static void sendConfigMessage(final CommandSender sender, final String path, final ImmutableMap<String, String> placeholders) {
        for (String line : main.getInstance().getConfig().getStringList(path)) {
            line = line.replace("%prefix%", getPrefix());
            for (final Map.Entry<String, String> placeholder : placeholders.entrySet()) {
                line = line.replace(placeholder.getKey(), placeholder.getValue());
            }
            sender.sendMessage(color(line));
        }
    }
}
