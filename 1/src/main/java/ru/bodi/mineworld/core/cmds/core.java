package ru.bodi.mineworld.core.cmds;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.bodi.mineworld.core.cfg;
import ru.bodi.mineworld.core.main;

public class core extends abst {

    public core() {
        super("MWcore");
    }

    @Override
    public void execute(CommandSender sender, String label, String[] args) {
        Player p = (Player) sender;
        if (sender.hasPermission("core.admin")) {
            cfg.sendConfigMessage(p, "Core.help");
        } else {
            cfg.sendConfigMessage(p, "Core.noPerms");
            return;
        }
        return;
    }
}
