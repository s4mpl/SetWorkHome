package me.tareqalyousef.setworkhome;

import org.bukkit.ChatColor;

import static org.bukkit.Bukkit.getServer;

public class Settings {
    public static final String DATA_PATH = getServer().getWorldContainer() + "/plugins/SetWorkHome";
    public static final String HOME_LOCATIONS_PATH = DATA_PATH + "/home.yml";
    public static final String WORK_LOCATIONS_PATH = DATA_PATH + "/work.yml";

    public static final ChatColor PREFIX_COLOR = ChatColor.GOLD;
    public static final ChatColor DEFAULT_COLOR = ChatColor.GRAY;
    public static final ChatColor HIGHLIGHT_COLOR = ChatColor.LIGHT_PURPLE;
}
