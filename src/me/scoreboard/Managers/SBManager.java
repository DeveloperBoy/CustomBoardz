package me.scoreboard.Managers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import me.scoreboard.Main;
import me.scoreboard.Utils.MainUtil;

public class SBManager {

    public static void setScoreBoard(Player p) {

        ScoreboardManager sbm = Bukkit.getScoreboardManager();
        Scoreboard sbs = sbm.getNewScoreboard();
        Objective obj = sbs.registerNewObjective("StaffScoreBoard", "dummy");

        Score blanket = obj.getScore(" " + Main.getInstance().getConfig().getString("ScoreBoard.Blanket"));
        Score lolz = obj.getScore(" " + Main.getInstance().getConfig().getString("ScoreBoard.Lolz"));

        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName(Main.getInstance().getConfig().getString("ScoreBoard.Name").replace("&", "§").replace("%arrowright%", "»").replace("&", "§").replace("%arrowright%", "»").replace("&", "§").replace("%arrowright%", "»"));

        blanket.setScore(16);

        Score naam = obj.getScore("Naam: " + MainUtil.replacePlaceholders(Main.getInstance().getConfig().getString("ScoreBoard.Player").replaceAll("&", "§"), p));
        naam.setScore(15);

        Score rank = obj.getScore("Rank: " + MainUtil.replacePlaceholders(Main.getInstance().getConfig().getString("ScoreBoard.Rank").replaceAll("&", "§"), p));
        rank.setScore(14);

        Score world = obj.getScore("Wereld: " + MainUtil.replacePlaceholders(Main.getInstance().getConfig().getString("ScoreBoard.World").replaceAll("&", "§"), p.getWorld()));
        world.setScore(13);

        Score website = obj.getScore("Website: " + Main.getInstance().getConfig().getString("ScoreBoard.Website").replace("&", "§"));
        website.setScore(12);

        lolz.setScore(11);

        Score ipz = obj.getScore("    " + Main.getInstance().getConfig().getString("ScoreBoard.Ip").replace("&", "§"));
        ipz.setScore(10);

        p.setScoreboard(sbs);

    }

    public static void setAdminScoreBoard(Player p) {

        ScoreboardManager sbm = Bukkit.getScoreboardManager();
        Scoreboard sbs = sbm.getNewScoreboard();
        Objective obj = sbs.registerNewObjective("StaffScoreBoard", "dummy");

        Score blanket = obj.getScore(" " + Main.getInstance().getConfig().getString("ScoreBoard.Blanket"));
        Score haha = obj.getScore(" " + Main.getInstance().getConfig().getString("ScoreBoard.Lolz"));


        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName(Main.getInstance().getConfig().getString("ScoreBoard.Name").replaceAll("&", "§"));

        blanket.setScore(16);

        Score naam = obj.getScore("Naam: " + MainUtil.replacePlaceholders(Main.getInstance().getConfig().getString("ScoreBoard.Player").replaceAll("&", "§"), p));
        naam.setScore(15);

        Score rank = obj.getScore("Rank: " + MainUtil.replacePlaceholders(Main.getInstance().getConfig().getString("ScoreBoard.Rank").replaceAll("&", "§"), p));
        rank.setScore(14);

        Score world = obj.getScore("Wereld: " + MainUtil.replacePlaceholders(Main.getInstance().getConfig().getString("ScoreBoard.World").replaceAll("&", "§"), p.getWorld()));
        world.setScore(13);

        Score server = obj.getScore("Gamemode: " + MainUtil.replacePlaceholders(Main.getInstance().getConfig().getString("ScoreBoard.Gamemode").replace("&", "§"), p.getGameMode()));
        server.setScore(12);

        haha.setScore(11);

        Score ip = obj.getScore("    " + Main.getInstance().getConfig().getString("ScoreBoard.Ip").replace("&", "§"));
        ip.setScore(10);

        p.setScoreboard(sbs);

    }

}