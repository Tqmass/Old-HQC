package hqwks.core;

import hqwks.core.commands.ResetKitCommand;
import hqwks.core.commands.TrashCommand;
import hqwks.core.commands.staff.GameModeCommand;
import hqwks.core.commands.staff.HealCommand;
import hqwks.core.events.DeathEffect;
import hqwks.core.events.DisableJoinMessage;
import hqwks.core.events.DisableLeaveMessage;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class CoreMain extends JavaPlugin {

    private String webhookURL = "https://discord.com/api/webhooks/1059771140412801124/U5NO_Sk39QS8pS__hdEDkzO5-RGwLGId_U7oJyPjqLZ_ftREdYCYj04kKx-HJsUhAAXm";

    @Override
    public void onEnable() {
        registerListeners(new Listener[] { (Listener)new DisableJoinMessage(), (Listener)new DisableLeaveMessage(), (Listener)new DeathEffect()});
        registerCommands();
        
        CommandRegistry commandRegistry = new CommandRegisterProvider();
        
        commandRegistry.register(            
            new TestCommand()
        );
        
        DiscordWebhook webhook = new DiscordWebhook(webhookURL);
        webhook.addEmbed(new DiscordWebhook.EmbedObject().setDescription("¡Plugin iniciado correctamente!"));

        try{
            webhook.execute();
        }

        catch (java.io.IOException e){
            getLogger().severe(e.getStackTrace().toString());
        }

        getLogger().info("Iniciado correctamente.");
    }
    public void registerCommands() {

        getCommand("resetkit").setExecutor((CommandExecutor)new ResetKitCommand(this));
        getCommand("trash").setExecutor((CommandExecutor)new TrashCommand(this));
        getCommand("gamemode").setExecutor((CommandExecutor)new GameModeCommand(this));
        getCommand("heal").setExecutor((CommandExecutor)new HealCommand(this));

    } private void registerListeners(Listener... listeners) {
        byte b;
        int i;
        Listener[] arrayOfListener;
        for (i = (arrayOfListener = listeners).length, b = 0; b < i; ) { Listener listener = arrayOfListener[b];
            getServer().getPluginManager().registerEvents(listener, (Plugin)this);
            b++; }
    }

    @Override
    public void onDisable() {
        getLogger().info("Desactivado correctamente.");
    }
}
