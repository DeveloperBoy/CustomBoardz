package me.scoreboard.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.scoreboard.Main;

public class ReloadScoreboardCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("reloadscoreboard")) {
            try {
                if (p.hasPermission("cs.reload")) {
                    p.sendMessage("§f[§c!!§f] §a§lAll the config files are been reoaded!");
                    Main.getInstance().reloadConfig();
                } else {
                    p.sendMessage("§f[§c!!§f] §c§lYou do not have permission to execute this command!");
                }
            } catch (Exception ex) {
                Main.Error("§f[§c!!§f] §c§lCannot reload the config files, we are expected an error!");
                p.sendMessage("§f[§c!!§f] §c§lWe have an error expected. Check the console for the error!");
                ex.printStackTrace();
            }
        }
        return false;
    }
}