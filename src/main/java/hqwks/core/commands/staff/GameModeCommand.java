package hqwks.core.commands.staff;

import hqwks.core.utils.Utilities;
import hqwks.core.utils.command.Command;
import hqwks.core.utils.command.CommandInfo;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandInfo(name = "gamemode", aliases = {"gm"}, playerOnly = false)

public class GameModeCommand extends Command {

    @Override
    public boolean onCommand(CommandSender sender, String[] args) {

        if (sender instanceof Player) {

            Player p = (Player) sender;

            if (!(p.hasPermission("core.gamemode"))) {
                sender.sendMessage(Utilities.toColor("&8&l「&c&l✘&8&l」 &4¡No tienes permisos para hacer esto!"));
                return true;
            }

            if (args.length == 0 || args.length > 2) {
                sender.sendMessage(Utilities.toColor("&8&l「&c&l✘&8&l」 &4¡Formato de argumentos incorrecto!"));
                sender.sendMessage(Utilities.toColor("&8&l「&a&l✔&8&l」 &9Uso: &a/gm <1, 2, 3> "));
                return true;

            } else {

                if (args.length == 1) {

                    if (args[0].equalsIgnoreCase("s") || args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("supervivencia") || args[0].equalsIgnoreCase("survival")) {
                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage(Utilities.toColor("&8&l「&a&l✔&8&l」 &b¡Has cambiado tu modo de juego a &aSupervivencia&b!"));
                        return true;
                    }

                    if (args[0].equalsIgnoreCase("c") || args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creativo") || args[0].equalsIgnoreCase("creative")) {
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage(Utilities.toColor("&8&l「&a&l✔&8&l」 &b¡Has cambiado tu modo de juego a &aCreativo&b!"));
                        return true;
                    }

                    if (args[0].equalsIgnoreCase("a") || args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("aventura") || args[0].equalsIgnoreCase("adventure")) {
                        p.setGameMode(GameMode.ADVENTURE);
                        p.sendMessage(Utilities.toColor("&8&l「&a&l✔&8&l」 &b¡Has cambiado tu modo de juego a &aAventura&b!"));
                        return true;
                    }

                    if (args[0].equalsIgnoreCase("sp") || args[0].equalsIgnoreCase("e") || args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("espectador") || args[0].equalsIgnoreCase("espectator")) {
                        p.setGameMode(GameMode.SPECTATOR);
                        p.sendMessage(Utilities.toColor("&8&l「&a&l✔&8&l」 &b¡Has cambiado tu modo de juego a &aCreativo&b!"));
                        return true;
                    }

                } else {

                    Player t = Bukkit.getPlayer(args[1]);

                    if (!(sender.hasPermission("core.gamemode.others"))) {
                        sender.sendMessage(Utilities.toColor("&8&l「&c&l✘&8&l」 &4¡No tienes permisos para hacer esto!"));
                        return true;
                    }

                    if (t != null) {

                        if (args[0].equalsIgnoreCase("s") || args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("supervivencia") || args[0].equalsIgnoreCase("survival")) {
                            t.setGameMode(GameMode.SURVIVAL);
                            t.sendMessage(Utilities.toColor("&8&l「&a&l✔&8&l」 &b¡Tu modo de juego ha sido cambiado a &aSupervivencia&b!"));
                            p.sendMessage(Utilities.toColor("&8&l「&a&l✔&8&l」 &b¡Has cambiado el modo de juego de &9" + t.getName() + " &ba &aSupervivencia&b!"));
                            return true;
                        }

                        if (args[0].equalsIgnoreCase("c") || args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creativo") || args[0].equalsIgnoreCase("creative")) {
                            t.setGameMode(GameMode.CREATIVE);
                            t.sendMessage(Utilities.toColor("&8&l「&a&l✔&8&l」 &b¡Tu modo de juego ha sido cambiado a &aCreativo&b!"));
                            p.sendMessage(Utilities.toColor("&8&l「&a&l✔&8&l」 &b¡Has cambiado el modo de juego de &9" + t.getName() + " &ba &aCreativo&b!"));
                            return true;
                        }

                        if (args[0].equalsIgnoreCase("a") || args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("aventura") || args[0].equalsIgnoreCase("adventure")) {
                            p.setGameMode(GameMode.ADVENTURE);
                            t.sendMessage(Utilities.toColor("&8&l「&a&l✔&8&l」 &b¡Tu modo de juego ha sido cambiado a &aAventura&b!"));
                            p.sendMessage(Utilities.toColor("&8&l「&a&l✔&8&l」 &b¡Has cambiado el modo de juego de &9" + t.getName() + " &ba &aAventura&b!"));
                            return true;
                        }

                        if (args[1].equalsIgnoreCase("sp") || args[0].equalsIgnoreCase("e") || args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("espectador") || args[0].equalsIgnoreCase("espectator")) {
                            p.setGameMode(GameMode.SPECTATOR);
                            t.sendMessage(Utilities.toColor("&8&l「&a&l✔&8&l」 &b¡Tu modo de juego ha sido cambiado a &aEspectador&b!"));
                            p.sendMessage(Utilities.toColor("&8&l「&a&l✔&8&l」 &b¡Has cambiado el modo de juego de &9" + t.getName() + " &ba &aEspectador&b!"));
                            return true;
                        }
                    } else {
                        sender.sendMessage(Utilities.toColor("&8&l「&c&l✘&8&l」 &4¡El jugador no existe o no está conectado!"));
                        return true;
                    }
                }
            }
        } else {
            if (args.length == 0 || args.length == 1 || args.length > 2) {
                sender.sendMessage(Utilities.toColor("&4Formato de argumentos incorrecto."));
                sender.sendMessage(Utilities.toColor("&4Uso: &a/gm <1, 2, 3> <Jugador>"));
                return true;
            } else {

                Player t = Bukkit.getPlayer(args[1]);

                if (t != null) {

                    if (args[0].equalsIgnoreCase("s") || args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("supervivencia") || args[0].equalsIgnoreCase("survival")) {
                        Bukkit.dispatchCommand(t, "gm 0");
                        t.sendMessage(Utilities.toColor("&8&l「&a&l✔&8&l」 &b¡Tu modo de juego ha sido cambiado a &aSupervivencia&b!"));
                        sender.sendMessage(Utilities.toColor("&bHas cambiado el modo de juego de &9" + t.getName() + " &ba &aSupervivencia"));
                        return true;
                    }

                    if (args[0].equalsIgnoreCase("c") || args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creativo") || args[0].equalsIgnoreCase("creative")) {
                        Bukkit.dispatchCommand(t, "gm 1");
                        t.sendMessage(Utilities.toColor("&8&l「&a&l✔&8&l」 &b¡Tu modo de juego ha sido cambiado a &aCreativo&b!"));
                        sender.sendMessage(Utilities.toColor("&bHas cambiado el modo de juego de &9" + t.getName() + " &ba &aCreativo"));
                        return true;
                    }

                    if (args[0].equalsIgnoreCase("a") || args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("aventura") || args[0].equalsIgnoreCase("adventure")) {
                        Bukkit.dispatchCommand(t, "gm 2");
                        t.sendMessage(Utilities.toColor("&8&l「&a&l✔&8&l」 &b¡Tu modo de juego ha sido cambiado a &aAventura&b!"));
                        sender.sendMessage(Utilities.toColor("&bHas cambiado el modo de juego de &9" + t.getName() + " &ba &aAventura"));
                        return true;
                    }

                    if (args[1].equalsIgnoreCase("sp") || args[0].equalsIgnoreCase("e") || args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("espectador") || args[0].equalsIgnoreCase("espectator")) {
                        Bukkit.dispatchCommand(t, "gm 3");
                        t.sendMessage(Utilities.toColor("&8&l「&a&l✔&8&l」 &b¡Tu modo de juego ha sido cambiado a &aEspectador&b!"));
                        sender.sendMessage(Utilities.toColor("Has cambiado el modo de juego de &9" + t.getName() + " &ba &aEspectador"));
                        return true;
                    }
                } else {
                    sender.sendMessage(Utilities.toColor("&4El jugador no existe o no esta conectado."));
                    return true;
                }
            }
        }
        return true;
    }
}
