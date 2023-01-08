package hqwks.core.commands.staff;

import hqwks.core.utils.Utilities;
import hqwks.core.utils.command.Command;
import hqwks.core.utils.command.CommandInfo;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

@CommandInfo(name = "staffchat", aliases = {"sc"}, playerOnly = false)

public class StaffChatCommand extends Command implements Listener {

    @Override
    public boolean onCommand(CommandSender sender, String[] args) {

        String mensaje = String.join(" ", args);

        if (sender instanceof Player) {

            Player p = (Player) sender;

            if (!(p.hasPermission("core.staffchat"))) {
                p.sendMessage(Utilities.toColor("&8&l「&c&l✘&8&l」 &4¡No tienes permisos para hacer esto!"));
                return true;
            }

            if(args.length != 0) {

                for (Player onlineStaffs : Bukkit.getOnlinePlayers()) {
                    if (onlineStaffs.isOp() || onlineStaffs.hasPermission("core.staffchat.receive")) {
                        onlineStaffs.sendMessage(Utilities.toColor("&8&l[&4&lSC&8&l] &b" + p.getName() + ": &f" + mensaje));
                        onlineStaffs.playSound(onlineStaffs.getLocation(), Sound.NOTE_PLING, 1, 1);
                    }
                }

            } else {
                p.sendMessage(Utilities.toColor("&8&l「&c&l✘&8&l」 &4¡Formato incorrecto!"));
                p.sendMessage(Utilities.toColor("&8&l「&a&l✔&8&l」 &7Uso: &b/sc <Mensaje>"));
                return true;
            }

        } else {

            if (args.length != 0) {

                for (Player onlineStaffs : Bukkit.getOnlinePlayers()) {
                    if (onlineStaffs.isOp() || onlineStaffs.hasPermission("core.staffchat.receive")) {
                        onlineStaffs.sendMessage(Utilities.toColor("&8&l[&4&lSC&8&l] &8&l[&c&lCONSOLA&8&l]&b: &f" + mensaje));
                        onlineStaffs.playSound(onlineStaffs.getLocation(), Sound.NOTE_PLING, 1, 1);
                    }
                }

            } else {
                sender.sendMessage(ChatColor.RED + "Formato incorrecto.");
                sender.sendMessage(ChatColor.RED + "Uso: " + ChatColor.AQUA + "/sc <Mensaje>");
                return true;
            }
        }
        return true;
    }

}
