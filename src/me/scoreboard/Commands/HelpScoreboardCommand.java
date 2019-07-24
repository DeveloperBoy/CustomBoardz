package me.scoreboard.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpScoreboardCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("helpscoreboard")) {
			p.sendMessage("§f[§c!!§f] §c§lThis is the help command!");
			p.sendMessage("");
			p.sendMessage("§9Reload Command: reloadsc, rlscoreboard, rlsc (Reload's the plugin!)");
			p.sendMessage("");
			p.sendMessage("reloadsc, rlscoreboard, rlsc (Reload's the plugin!)");
			p.sendMessage("§9Help Command: ");
			p.sendMessage("");
			p.sendMessage("helpsc, hscoreboard, csshelp (Get help about the plugin!)");
		}
		return false;
	}
}
