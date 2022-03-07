package ru.bodi.mineworld.core.Void;

import org.bukkit.command.*;
import ru.bodi.mineworld.core.main;

public class VoidUtils
{
    public static void sendMessage(final CommandSender p, final String msg) {
        p.sendMessage(main.getInstance().getConfig().getString(msg).replace("&", "§"));
    }
}
