package ru.bodi.mineworld.core.Void;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.bodi.mineworld.core.cmds.abst;
import ru.bodi.mineworld.core.main;

import java.util.Locale;

public class VoidCMD extends abst {
    public VoidCMD() {
        super("mwvoid");
    }

    @Override
    public void execute(final CommandSender sender, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§6§lMINE§e§lWORLD§7: §fError no console use.");
            return;
        }
        final Player p = (Player)sender;
        if (p.isOp() && args.length != 0) {
            if (!p.hasPermission("core.void")) {
                sender.sendMessage("§6§lMINE§e§lWORLD§7: §fУ вас §cнедостаточно§f прав.");
                return;
            }
            final String lowerCase = args[0].toLowerCase();
            switch (lowerCase) {
                case "reload": {
                    main.instance.reloadConfig();
                    p.sendMessage(main.instance.getConfig().getString("Void.Messages.reload"));
                    break;
                }
            }
        }
        return;
    }
}