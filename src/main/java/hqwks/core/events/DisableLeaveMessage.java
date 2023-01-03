package hqwks.core.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class DisableLeaveMessage implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onLeave(PlayerQuitEvent e){
        e.setQuitMessage(null);
    }

}
