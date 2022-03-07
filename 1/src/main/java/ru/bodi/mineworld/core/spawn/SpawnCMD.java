package ru.bodi.mineworld.core.spawn;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import ru.bodi.mineworld.core.cmds.abst;
import ru.bodi.mineworld.*;
import org.bukkit.*;
import ru.bodi.mineworld.core.main;

public class SpawnCMD extends abst
{
    public SpawnCMD() {
        super("spawn");
    }

    @Override
    public void execute(final CommandSender sender, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            SpawnUtils.sendMessage(sender, "Spawn.Messages.consoleSend");
            return;
        }
        final Player p = (Player)sender;
        if (args.length == 0) {
            if (p.hasPermission("core.use")) {
                SpawnUtils.teleportSpawn(p);
                SpawnUtils.sendMessage((CommandSender)p, "Spawn.Messages.tpSpawn");
            }
            else {
                SpawnUtils.sendMessage((CommandSender)p, "Spawn.Messages.noPerm");
            }
            return;
        }
        if (p.hasPermission("core.admin")) {
            final String lowerCase2;
            final String lowerCase = lowerCase2 = args[0].toLowerCase();
            switch (lowerCase2) {
                case "set": {
                    SpawnUtils.setSpawn(p);
                    SpawnUtils.sendMessage((CommandSender)p, "Spawn.Messages.setSpawn");
                    break;
                }
                case "reload": {
                    main.getInstance().reloadConfig();
                    SpawnUtils.sendMessage((CommandSender)p, "Spawn.Messages.reloadPlugin");
                    break;
                }
                default: {
                    final Player p2 = Bukkit.getPlayerExact(args[0]);
                    if (p2 != null) {
                        SpawnUtils.teleportSpawn(p2);
                        SpawnUtils.sendMessage((CommandSender)p2, "Spawn.Messages.slaveTeleport");
                        break;
                    }
                    SpawnUtils.sendMessage((CommandSender)p, "Spawn.Messages.notFoundPlayer");
                    break;
                }
            }
            return;
        }
        SpawnUtils.sendMessage((CommandSender)p, "Spawn.Messages.noPerm");
    }
}
