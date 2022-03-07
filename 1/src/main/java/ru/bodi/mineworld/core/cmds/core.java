package ru.bodi.mineworld.core.cmds;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class core extends abst {

    public core() {
        super("MWcore");
    }

    @Override
    public void execute(CommandSender sender, String label, String[] args) {
        Player p = (Player) sender;
        if (sender.hasPermission("core.admin")) {
            p.sendMessage("§aпроверка");
        } else {
            p.sendMessage("§cн проверка");
            return;
        }
        return;
    }
}
