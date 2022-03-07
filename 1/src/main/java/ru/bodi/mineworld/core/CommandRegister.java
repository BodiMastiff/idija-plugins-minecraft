package ru.bodi.mineworld.core;


import org.bukkit.command.*;
import java.util.*;

public class CommandRegister
{
    public static void register(final CommandExecutor[] commands) {
        Arrays.asList(commands).forEach(x -> {
            if (x instanceof CommandExecutor) {
                Tools.getInstance().getCommand(CommandAnnotation.getCommandName(x.getClass())).setExecutor(x);
            }
        });
    }
}
