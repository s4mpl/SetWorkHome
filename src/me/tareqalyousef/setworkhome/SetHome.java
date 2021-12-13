package me.tareqalyousef.setworkhome;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Set;

public class SetHome implements CommandExecutor {
    private SetWorkHome plugin;

    public SetHome(SetWorkHome plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player))
            return true;

        Player player = (Player)commandSender;
        Location loc = player.getLocation();
        Util.setHomeLocation(player, loc);
        player.sendMessage(Settings.PREFIX_COLOR + plugin.getConfig().getString("prefix") + Settings.DEFAULT_COLOR + " Set home location to " +
                Settings.HIGHLIGHT_COLOR + String.format("(%.2f, %.2f, %.2f)", loc.getX(), loc.getY(), loc.getZ()));

        return true;
    }
}
