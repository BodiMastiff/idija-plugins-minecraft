package ru.bodi.mineworld.core.cmds;

import ru.bestrax.core.commands.annotations.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import ru.bestrax.core.config.impl.*;
import ru.bestrax.core.utils.*;
import org.bukkit.*;
import ru.bodi.mineworld.core.cfg;
import ru.bodi.mineworld.core.main;

@CommandName("fly")
public class FlyCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender commandSender, final Command command, final String s, final String[] args) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("You not player.");
            return true;
        }
        final Player player = (Player)commandSender;
        if (!player.hasPermission("core.fly")) {
            cfg.sendConfigMessage(player, "Core.noPerms");
            return true;
        }
        if (args.length != 0 && args.length != 1) {
            player.sendMessage("fly on/off");
            return true;
        }
        if (args.length == 0) {
            if (player.isFlying()) {
                player.setFlying(false);
                player.setAllowFlight(false);
                player.sendMessage("Вы выключили флай" + player.getDisplayName());
            }
            else {
                player.setAllowFlight(true);
                player.setFlying(true);
                player.sendMessage("Вы включили флай" + player.getDisplayName());
            }
        }
        else {
            if (!player.hasPermission("core.fly.other")) {
                cfg.sendConfigMessage(player, "Core.noPerms");
                return true;
            }
            final Player target = Bukkit.getPlayer(args[0]);
            if (target == null || !target.isOnline()) {
                Utils.sendMessage((CommandSender)player, Translations.PLAYER);
                return true;
            }
            if (target.isFlying()) {
                target.setAllowFlight(false);
                target.setFlying(false);
                Utils.sendMessage((CommandSender)player, Translations.FLY_YOU_DISABLE.replace("{player}", target.getDisplayName()));
                Utils.sendMessage((CommandSender)target, Translations.FLY_TARGET_DISABLE);
            }
            else {
                target.setAllowFlight(true);
                target.setFlying(true);
                Utils.sendMessage((CommandSender)player, Translations.FLY_YOU_ENABLE.replace("{player}", target.getDisplayName()));
                Utils.sendMessage((CommandSender)target, Translations.FLY_TARGET_ENABLE);
            }
        }
        return true;
    }
}
