package fun.aqurik.pr;

import io.papermc.paper.event.player.PlayerTradeEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Pr extends JavaPlugin implements Listener {
    Logger logger = Bukkit.getLogger();
    private static Pr pestrun; // отменяется
    @Override
    public void onEnable() {
        pestrun = this;
        getServer().getPluginManager().registerEvents(this, this);
        logger.info("Запускаюсь");
    }

    @Override
    public void onDisable() {
        logger.info("Выключаюсь");
    }

    @EventHandler
    public void trade(PlayerTradeEvent event) {

        if (event.getPlayer().hasPermission("pr.unlimited")) {
            event.getTrade().setUses(0);
        }
    }

    public static Pr naitiPestrun() {
        return pestrun;
    }


}
