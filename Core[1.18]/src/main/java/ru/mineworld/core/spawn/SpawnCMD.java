package ru.mineworld.core.spawn;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import ru.mineworld.core.Main;

public class SpawnCMD implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            Utils.sendMessage(sender, "HyperSpawn.Messages.consoleSend");
            return false;
        }
        final Player p = (Player)sender;
        if (args.length == 0) {
            if (p.hasPermission("hyperspawn.use")) {
                Utils.teleportSpawn(p);
                Utils.sendMessage((CommandSender)p, "HyperSpawn.Messages.tpSpawn");
            }
            else {
                Utils.sendMessage((CommandSender)p, "HyperSpawn.Messages.noPerm");
            }
            return true;
        }
        if (p.hasPermission("hyperspawn.admin")) {
            final String lowerCase = args[0].toLowerCase();
            switch (lowerCase) {
                case "set": {
                    Utils.setSpawn(p);
                    Utils.sendMessage((CommandSender)p, "HyperSpawn.Messages.setSpawn");
                    break;
                }
                case "reload": {
                    Main.instance.reloadConfig();
                    Utils.sendMessage((CommandSender)p, "HyperSpawn.Messages.reloadPlugin");
                    break;
                }
                default: {
                    final Player p2 = Bukkit.getPlayerExact(args[0]);
                    if (p2 != null) {
                        Utils.teleportSpawn(p2);
                        Utils.sendMessage((CommandSender)p2, "HyperSpawn.Messages.slaveTeleport");
                        break;
                    }
                    Utils.sendMessage((CommandSender)p, "HyperSpawn.Messages.notFoundPlayer");
                    break;
                }
            }
            return false;
        }
        Utils.sendMessage((CommandSender)p, "HyperSpawn.Messages.noPerm");
        return true;
    }
}
