package me.scoreboard.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import me.scoreboard.Main;
import me.scoreboard.Managers.SBManager;

public class JoinListener implements Listener {


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        SBManager.setScoreBoard(p);
        Main.getInstance().updateScoreboard(p);
    }

}