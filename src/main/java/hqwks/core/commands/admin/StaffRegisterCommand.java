package hqwks.core.commands.admin;

import hqwks.core.utils.Utilities;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class StaffRegisterCommand implements CommandExecutor {

    private HashMap<String, String> Staff = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player p = (Player) sender;

            if (!(p.hasPermission("core.staffregister"))) {
                p.sendMessage(Utilities.toColor("&8&l「&c&l✘&8&l」 &4¡No tienes permisos para hacer esto!"));
                return true;
            }

            if (args.length == 0 || args.length > 3) {
                sender.sendMessage(Utilities.toColor("&8&l「&c&l✘&8&l」 &4¡Formato de argumentos incorrecto!"));
                sender.sendMessage(Utilities.toColor("&8&l「&a&l✔&8&l」 &9Uso: &a/staffregister <Usuario> <Contraseña>"));
                return true;

            } else {

                if (args.length == 2) {

                    String jugador = p.getName();
                    String contraseña = args[2];

                    Staff.put(jugador, contraseña);
                    p.sendMessage("&8&l「&a&l✔&8&l」 &b¡El jugador &e" + jugador + " &bha sido agregado como Staff!");

                }
            }
        }

        return true;
    }
}
