package me.scoreboard.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.scoreboard.Main;

public class StaffScoreboardCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("staff")) {
				 if (p.hasPermission("cs.viewstaff")) {
					 if (args.length != 1) {
						 p.sendMessage("§f§l[§c§l!!§f§l] §r§cYou need to use /viewsc §aon §c| §4off");
						 return false;
					 } 
					 //LIJST WORDT GECHECKT IN DE MAIN CLASS DOOR DIE UPDATE METHODE!
					 if (args[0].equalsIgnoreCase("on")) {
						 //ON
						 //Voeg hem toe aan de lijst
						 Main.staffspelers.add(p.getUniqueId());
						 p.sendMessage("§f§l[§c!!§f] §r§cYou have turned §aon §cthe staff scoreboard!");
					 } else {
						 //OFF
						 //Checkt of de speler wel in de lijst staat, anders dan krijg je errors
						 if (Main.staffspelers.contains(p.getUniqueId())) {
							 //Haal hem uit de lijst
							 Main.staffspelers.remove(p.getUniqueId());
							 p.sendMessage("§f§l[§c!!§f] §r§c§You have turned §4off §cthe staff scoreboard!");
						 }
						 
					 }
					 return true;
				 } else {
					 p.sendMessage("§f§l[§c!!§f] §r§cYou do not have permission to execute this command!");
					 return true;
				 }
		}
		return false;
	}
}
