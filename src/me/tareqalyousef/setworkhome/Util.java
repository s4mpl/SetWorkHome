package me.tareqalyousef.setworkhome;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class Util {
    public static File getHomeLocationsFile() {
        File file = new File(Settings.HOME_LOCATIONS_PATH);

        if (!file.exists())
            throw new RuntimeException("Failed to load home locations file");

        return file;
    }

    public static File getWorkLocationsFile() {
        File file = new File(Settings.WORK_LOCATIONS_PATH);

        if (!file.exists())
            throw new RuntimeException("Failed to load work locations file");

        return file;
    }

    public static Location getHomeLocation(Player player) {
        File file = Util.getHomeLocationsFile();
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

        if (!config.contains(player.getUniqueId().toString()))
            return null;

        return config.getLocation(player.getUniqueId().toString());
    }

    public static Location getWorkLocation(Player player) {
        File file = Util.getWorkLocationsFile();
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

        if (!config.contains(player.getUniqueId().toString()))
            return null;

        return config.getLocation(player.getUniqueId().toString());
    }

    public static void setHomeLocation(Player player, Location location) {
        File file = Util.getHomeLocationsFile();
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

        config.set(player.getUniqueId().toString(), location);

        try {
            config.save(file);
        } catch (Exception exception) {
            Bukkit.getLogger().info("Could not save home.yml");
        }
    }

    public static void setWorkLocation(Player player, Location location) {
        File file = Util.getWorkLocationsFile();
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

        config.set(player.getUniqueId().toString(), location);

        try {
            config.save(file);
        } catch (Exception exception) {
            Bukkit.getLogger().info("Could not save work.yml");
        }
    }
}
