package ru.bodi.mineworld.core;

import java.lang.annotation.*;

public class CommandAnnotation
{
    public static String getCommandName(final Class<?> c) {
        if (!c.isAnnotationPresent(CommandName.class)) {
            return null;
        }
        final CommandName commandName = c.getAnnotation(CommandName.class);
        return commandName.value();
    }
}
