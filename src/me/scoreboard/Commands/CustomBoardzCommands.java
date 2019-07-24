package me.scoreboard.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.scoreboard.Main;

public class CustomBoardzCommands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!label.equalsIgnoreCase("customboardz")) return true;
		
		if (args[0].equalsIgnoreCase("viewstaff")) {
			if (sender.hasPermission("cs.viewstaff")) {
				 if (args.length != 2) {
					 sender.sendMessage("§f§l[§c§l!!§f§l] §r§cYou need to use /viewsc §aon §c| §4off");
					 return false;
				 } 
				 
				 if (!(sender instanceof Player)) {
					 sender.sendMessage("§f§l[§c§l!!§f§l] §r§cYou need to be a player to do this.");
					 return false;
				 }
				 
				 Player p = (Player) sender;
				 
				 //LIJST WORDT GECHECKT IN DE MAIN CLASS DOOR DIE UPDATE METHODE!
				 if (args[1].equalsIgnoreCase("on")) {
					 //ON
					 //Voeg hem toe aan de lijst
					 Main.staffspelers.add(p.getUniqueId());
					 sender.sendMessage("§f§l[§c!!§f] §r§cYou have turned §aon §cthe staff scoreboard!");
				 } else {
					 //OFF
					 //Checkt of de speler wel in de lijst staat, anders dan krijg je errors
					 if (Main.staffspelers.contains(p.getUniqueId())) {
						 //Haal hem uit de lijst
						 Main.staffspelers.remove(p.getUniqueId());
						 sender.sendMessage("§f§l[§c!!§f] §r§c§You have turned §4off §cthe staff scoreboard!");
					 }
					 
				 }
				 return true;
			 } else {
				 sender.sendMessage("§f§l[§c!!§f] §r§cYou do not have permission to execute this command!");
				 return false;
			 }
		} else if (args[0].equalsIgnoreCase("reload")) {
			try {
                if (sender.hasPermission("cs.reload")) {
                	sender.sendMessage("§f[§c!!§f] §a§lAll the config files are been reoaded!");
                    Main.getInstance().reloadConfig();
                } else {
                	sender.sendMessage("§f[§c!!§f] §c§lYou do not have permission to execute this command!");
                }
            } catch (Exception ex) {
                Main.Error("§f[§c!!§f] §c§lCannot reload the config files, we are expected an error!");
                sender.sendMessage("§f[§c!!§f] §c§lWe have an error expected. Check the console for the error!");
                ex.printStackTrace();
            }
			return true;
		} else {
			sender.sendMessage("§f[§c!!§f] §c§lThis is the help command!");
			sender.sendMessage("");
			sender.sendMessage("§9Staff Command: /customboardz viewstaff");
			sender.sendMessage("");
			sender.sendMessage("§9Reload Command: /customboardz reload");
			sender.sendMessage("");
			sender.sendMessage("§9Help Command: /customboardz help");
			return true;
		}
	}

}
