package me.scoreboard.api;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import me.scoreboard.Main;

public class SBManager {

    public static void setScoreBoard(Player p) {

        //    	Date now = new Date();
        //CharSequence format = (CharSequence) new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    	
    	//Nee, want als je hem geanimmeerd wilt hebben, dan gaat hij knipperen. Dus daarvoor heb je zo'n flickerless util nodig. :P

    	//Ja dat. :P
    	
    	//Nou, succes nog. :P Ja, vgm wel.
    	
        ScoreboardManager sbm = Bukkit.getScoreboardManager();
        Scoreboard sbs = sbm.getNewScoreboard();
        Objective obj = sbs.registerNewObjective("StaffScoreBoard", "dummy");
        
        Score blanket = obj.getScore(" " + Main.getInstance().getConfig().getString("ScoreBoard.Blanket"));
        Score lolz = obj.getScore(" " + Main.getInstance().getConfig().getString("ScoreBoard.Lolz"));
        
        String rang = Main.getInstance().getPermission().getPrimaryGroup(p);
        

        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName(Main.getInstance().getConfig().getString("ScoreBoard.Name").replace("&", "§").replace("%arrowright%", "»").replace("&", "§").replace("%arrowright%", "»").replace("&", "§").replace("%arrowright%", "»"));

        blanket.setScore(16);
        
        Score naam = obj.getScore("Naam: " + Main.getInstance().getConfig().getString("ScoreBoard.Player").replace("&", "§").replace("%arrowright%", "»").replaceAll("%player%", p.getDisplayName()));
        naam.setScore(15);
        
        Score rank = obj.getScore("Rank: " + Main.getInstance().getConfig().getString("ScoreBoard.Rank").replace("&", "§").replace("%arrowright%", "»").replaceAll("%Rank%", rang));
        rank.setScore(14);

        Score gamemode = obj.getScore("Server: " + Main.getInstance().getConfig().getString("ScoreBoard.World").replace("&", "§").replace("%arrowright%", "»"));
        gamemode.setScore(13);
        
        Score website = obj.getScore("Website: " + Main.getInstance().getConfig().getString("ScoreBoard.Website").replace("&", "§").replace("%arrowright%", "»"));
        website.setScore(12);
       
        lolz.setScore(11);
        
        Score ipz = obj.getScore("    " + Main.getInstance().getConfig().getString("ScoreBoard.Ip").replace("&", "§"));
        ipz.setScore(10);

        p.setScoreboard(sbs);

    }

    public static void setAdminScoreBoard(Player p) {

        //    	Date now = new Date();
        //CharSequence format = (CharSequence) new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        //En hieronder verander je dan de dingen voor het staff scoreboard!!!
    	
        ScoreboardManager sbm = Bukkit.getScoreboardManager();
        Scoreboard sbs = sbm.getNewScoreboard();
        Objective obj = sbs.registerNewObjective("StaffScoreBoard", "dummy");
        
    	Score blanket = obj.getScore(" " + Main.getInstance().getConfig().getString("ScoreBoard.Blanket"));
    	Score haha = obj.getScore(" " + Main.getInstance().getConfig().getString("ScoreBoard.Lolz"));

    	
        String rang = Main.getInstance().getPermission().getPrimaryGroup(p);


        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName(Main.getInstance().getConfig().getString("ScoreBoard.Name").replace("&", "§").replace("%arrowright%", "»").replace("&", "§").replace("%arrowright%", "»").replace("&", "§").replace("%arrowright%", "»"));
        
        blanket.setScore(16);
        
        Score naam = obj.getScore("Naam: " + Main.getInstance().getConfig().getString("ScoreBoard.Player").replace("&", "§").replace("%arrowright%", "»").replaceAll("%player%", p.getDisplayName()));
        naam.setScore(15);

        Score rank = obj.getScore("Rank: " + Main.getInstance().getConfig().getString("ScoreBoard.Rank").replace("&", "§").replace("%arrowright%", "»").replaceAll("%Rank%", rang));
        rank.setScore(14);
        
        Score world = obj.getScore("Server: " + Main.getInstance().getConfig().getString("ScoreBoard.World").replace("&", "§").replace("%arrowright%", "»"));
        world.setScore(13);
        
        Score server = obj.getScore("Gamemode: " + Main.getInstance().getConfig().getString("ScoreBoard.Gamemode").replace("&", "§").replace("%arrowright%", "»").replaceAll("%gamemode%", p.getGameMode().toString()));
        server.setScore(12);
        
        haha.setScore(11);
        
        Score ip = obj.getScore("    " + Main.getInstance().getConfig().getString("ScoreBoard.Ip").replace("&", "§"));
        ip.setScore(10);

        p.setScoreboard(sbs);

    }

}
