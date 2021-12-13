package me.tareqalyousef.setworkhome;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class SetWorkHome extends JavaPlugin {
    @Override
    public void onEnable() {
        // configs
        saveDefaultConfig();
        verifyDirectories();

        // commands
        getCommand("sethome").setExecutor(new SetHome(this));
        getCommand("setwork").setExecutor(new SetWork(this));
        getCommand("home").setExecutor(new Home(this));
        getCommand("work").setExecutor(new Work(this));
    }

    public void verifyDirectories() {
        File data = new File(Settings.DATA_PATH);
        File home = new File(Settings.HOME_LOCATIONS_PATH);
        File work = new File(Settings.WORK_LOCATIONS_PATH);

        try {
            if (!data.exists()) data.mkdir();
            if (!home.exists()) home.createNewFile();
            if (!work.exists()) work.createNewFile();
        } catch (Exception e) {
            Bukkit.getLogger().info("Error with directory verification");
        }
    }
}
