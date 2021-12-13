package me.tareqalyousef.setworkhome;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Home implements CommandExecutor {
    private SetWorkHome plugin;

    public Home(SetWorkHome plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player))
            return true;

        Player player = (Player)commandSender;
        Location loc = Util.getHomeLocation(player);

        if (loc == null) {
            player.sendMessage(Settings.PREFIX_COLOR + plugin.getConfig().getString("prefix") + Settings.DEFAULT_COLOR + " You do not have a home location set");
            return true;
        } else {
            player.sendMessage(Settings.PREFIX_COLOR + plugin.getConfig().getString("prefix") + Settings.DEFAULT_COLOR + " Teleported to home location");
            player.teleport(loc);
        }

        return true;
    }
}
