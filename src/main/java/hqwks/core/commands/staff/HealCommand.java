package hqwks.core.commands.staff;

import hqwks.core.utils.Utilities;
import hqwks.core.utils.command.Command;
import hqwks.core.utils.command.CommandInfo;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandInfo(name = "heal", aliases = {"curar"}, playerOnly = false)

public class HealCommand extends Command {

    @Override
    public boolean onCommand(CommandSender sender, String[] args) {

        if (sender instanceof Player) {

            Player p = (Player) sender;

            if (!(p.hasPermission(""))) {
                sender.sendMessage(Utilities.toColor("&8&l「&c&l✘&8&l」 &4¡No tienes permisos para hacer esto!"));
                return true;
            }

            if (args.length == 0) {

                p.setHealth(20);
                p.setFoodLevel(20);
                p.sendMessage(Utilities.toColor("&8&l「&a&l✔&8&l」 &b¡Te has curado!"));
                return true;
            } else {

                if (!(sender.hasPermission("core.heal.others"))){
                    sender.sendMessage(Utilities.toColor("&8&l「&c&l✘&8&l」 &4¡No tienes permisos para hacer esto!"));
                    return true;
                }

                Player t = Bukkit.getPlayer(args[0]);

                if (args.length == 1) {

                    t.setHealth(20);
                    t.setFoodLevel(20);
                    t.sendMessage(Utilities.toColor("&8&l「&a&l✔&8&l」 &b¡Has sido curado!"));
                    sender.sendMessage(Utilities.toColor("&8&l「&a&l✔&8&l」 &b¡Has curado a &9" + t.getName() + "&b!"));
                    return true;
                }
            }
        } else {

            if (args.length == 0 || args.length > 1) {
                sender.sendMessage(Utilities.toColor("&4Formato incorrecto."));
                sender.sendMessage(Utilities.toColor("&4Uso: &a/heal <Jugador>"));
                return true;
            } else {

                Player t = Bukkit.getPlayer(args[0]);

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "heal");
                t.sendMessage(Utilities.toColor("&8&l「&a&l✔&8&l」 &b¡Has sido curado!"));
                sender.sendMessage(Utilities.toColor("&bHas curado a &9" + t.getName()));
                return true;
            }
        }
        return true;
    }
}
