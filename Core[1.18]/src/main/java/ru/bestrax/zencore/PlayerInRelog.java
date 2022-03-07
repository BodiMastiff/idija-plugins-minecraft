package ru.bestrax.zencore;

import java.util.*;

public class PlayerInRelog
{
    private static ArrayList<String> playersInRelog;
    
    public static void addPlayer(final String name) {
        PlayerInRelog.playersInRelog.add(name);
    }
    
    public static void removePlayer(final String name) {
        PlayerInRelog.playersInRelog.remove(name);
    }
    
    public static boolean contains(final String name) {
        return PlayerInRelog.playersInRelog.contains(name);
    }
    
    static {
        PlayerInRelog.playersInRelog = new ArrayList<String>();
    }
}
