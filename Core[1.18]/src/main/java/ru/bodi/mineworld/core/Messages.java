package ru.bodi.mineworld.core;

public class Messages
{
    private static Main plugin;
    private static final Messages instance;
    private static String PREFIX;
    public static String UNKNOWN_COMMAND;
    public static String NO_PERMS;
    public static String USE_USAGE;
    public static String USE_SUCC;
    public static String USE_FAIL;
    public static String NO_PERMS_TIME;
    
    public static Messages getInstance() {
        return Messages.instance;
    }
    
    public static void init(final Main plugin) {
        Messages.plugin = plugin;
        Messages.PREFIX = plugin.getConfig().getString("messages.prefix").replace('&', '§');
        Messages.UNKNOWN_COMMAND = Messages.PREFIX + plugin.getConfig().getString("messages.unknown-command").replace('&', '§');
        Messages.NO_PERMS = Messages.PREFIX + plugin.getConfig().getString("messages.no-perms").replace('&', '§');
        Messages.USE_USAGE = Messages.PREFIX + plugin.getConfig().getString("messages.use.usage").replace('&', '§');
        Messages.USE_SUCC = Messages.PREFIX + plugin.getConfig().getString("messages.use.succ").replace('&', '§');
        Messages.USE_FAIL = Messages.PREFIX + plugin.getConfig().getString("messages.use.fail").replace('&', '§');
        Messages.NO_PERMS_TIME = plugin.getConfig().getString("messages.timeNoPerms").replace('&', '§');
    }
    
    static {
        instance = new Messages();
    }
}
