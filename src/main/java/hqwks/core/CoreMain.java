package hqwks.core;

import hqwks.core.commands.ResetKitCommand;
import hqwks.core.commands.TrashCommand;
import hqwks.core.commands.staff.GameModeCommand;
import hqwks.core.commands.staff.HealCommand;
import hqwks.core.commands.staff.StaffChatCommand;
import hqwks.core.events.DeathEffect;
import hqwks.core.events.DisableJoinMessage;
import hqwks.core.events.DisableLeaveMessage;
import hqwks.core.utils.Utilities;
import hqwks.core.utils.command.other.CommandRegisterProvider;
import hqwks.core.utils.command.other.CommandRegistry;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;

public class CoreMain extends JavaPlugin {

    private JDA jda;
    private TextChannel canal;

    private String webhookURL = "https://discord.com/api/webhooks/1059771140412801124/U5NO_Sk39QS8pS__hdEDkzO5-RGwLGId_U7oJyPjqLZ_ftREdYCYj04kKx-HJsUhAAXm";

    @Override
    public void onEnable() {
        saveDefaultConfig();

        registerListeners(new Listener[]{(Listener)new SpigotListener(), (Listener)new DisableJoinMessage(), (Listener) new DisableLeaveMessage(), (Listener) new DeathEffect()});

        CommandRegistry commandRegistry = new CommandRegisterProvider();

        commandRegistry.register(
                new GameModeCommand(),
                new TrashCommand(),
                new ResetKitCommand(),
                new HealCommand(),
                new StaffChatCommand()
        );

        String botToken = getConfig().getString("bot-token");

        jda = JDABuilder.createDefault(botToken)
                .setActivity(Activity.playing("Hqwks coding."))
                .addEventListeners(new DiscordListener())
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build();

        getLogger().info("Iniciado correctamente.");
    }

    @Override
    public void onDisable() {
        getLogger().info("Desactivado correctamente.");
    }

    private void registerListeners(Listener... listeners) {
        byte b;
        int i;
        Listener[] arrayOfListener;
        for (i = (arrayOfListener = listeners).length, b = 0; b < i; ) {
            Listener listener = arrayOfListener[b];
            getServer().getPluginManager().registerEvents(listener, (Plugin) this);
            b++;
        }
    }

    public final class DiscordListener extends ListenerAdapter {

        @SuppressWarnings("null")
        @Override
        public void onMessageReceived(MessageReceivedEvent e) {

            Member usuario = e.getMember();

            if(!e.getChannel().getId().equals("1046188119709470873") || usuario.getUser() == null || usuario.getUser().isBot()) return;

            String mensaje = e.getMessage().getContentDisplay();

            for (Player onlineStaffs : Bukkit.getOnlinePlayers()) {
                if (onlineStaffs.isOp() || onlineStaffs.hasPermission("core.staffchat.receive")) {
                    onlineStaffs.sendMessage(Utilities.toColor("&8&l[&4&lSC&8&l] &8&l[&9&lDISCORD&8&l] &b" + e.getAuthor().getName() + ": &f" + mensaje));
                }
            }
        }
    }

    private void sendMessage(Player player, String content, boolean contentInAuthorLine, Color color) {

        Guild guild = jda.getGuildById("1046188119709470870");
        TextChannel channel = guild.getTextChannelById("1046188119709470873");

        EmbedBuilder builder = new EmbedBuilder()
                .setAuthor(
                        contentInAuthorLine ? content : player.getDisplayName(),
                        null,
                        "http://minepic.org/avatar/" + player.getName() + "/50"
                )
                .setColor(Color.ORANGE);

        if (!contentInAuthorLine) {
            builder.setDescription(content);
        }

        channel.sendMessageEmbeds(builder.build()).queue();

    }

    public final class SpigotListener implements Listener {

        @SuppressWarnings("null")
        @EventHandler
        private void onChat(AsyncPlayerChatEvent e){

            String[] args = null;
            Player p = e.getPlayer();

                if (p.hasPermission("core.staffchat")) {

                    sendMessage(e.getPlayer(), e.getMessage(), false, Color.ORANGE);
                }
        }
    }

}
