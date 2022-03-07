package ru.mineworld.core;

public class Utils
{
    private static Utils instance;
    public static String NEAR;
    public static String PERMISSION;
    public static String NORTH;
    public static String NORTH_EAST;
    public static String EAST;
    public static String SOUTH_EAST;
    public static String SOUTH;
    public static String SOUTH_WEST;
    public static String WEST;
    public static String NORTH_WEST;
    public static String NO_PERMS;
    public static String CREATIVE;
    public static String NO_PLAYERS;
    public static String RESULT;
    
    public static Utils getInstance() {
        return Utils.instance;
    }
    
    public static void init(final Main plugin) {
        Utils.NEAR = plugin.getConfig().getString("messages.near").replace('&', '§');
        Utils.PERMISSION = plugin.getConfig().getString("settings.permission");
        Utils.NORTH = plugin.getConfig().getString("settings.north").replace('&', '§');
        Utils.NORTH_EAST = plugin.getConfig().getString("settings.north_east").replace('&', '§');
        Utils.EAST = plugin.getConfig().getString("settings.east").replace('&', '§');
        Utils.SOUTH_EAST = plugin.getConfig().getString("settings.south_east").replace('&', '§');
        Utils.SOUTH = plugin.getConfig().getString("settings.south").replace('&', '§');
        Utils.SOUTH_WEST = plugin.getConfig().getString("settings.south_west").replace('&', '§');
        Utils.WEST = plugin.getConfig().getString("settings.west").replace('&', '§');
        Utils.NORTH_WEST = plugin.getConfig().getString("settings.north_west").replace('&', '§');
        Utils.NO_PERMS = plugin.getConfig().getString("messages.no-perms").replace('&', '§');
        Utils.CREATIVE = plugin.getConfig().getString("settings.creative").replace('&', '§');
        Utils.NO_PLAYERS = plugin.getConfig().getString("messages.no-players").replace('&', '§');
        Utils.RESULT = plugin.getConfig().getString("messages.result").replace('&', '§');
    }
    
    static {
        Utils.instance = new Utils();
    }
}
