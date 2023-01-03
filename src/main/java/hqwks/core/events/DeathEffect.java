package hqwks.core.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEffect implements Listener {

    @EventHandler
    public void DeathEffect(PlayerDeathEvent e){

        if(!(e.getEntity() instanceof Player))
            return;
        e.getEntity().getWorld().strikeLightningEffect(e.getEntity().getLocation());
    }

}