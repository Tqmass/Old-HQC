package hqwks.core.commands;

import hqwks.core.utils.Utilities;
import org.bukkit.Bukkit;
import hqwks.core.utils.command.Command;
import hqwks.core.utils.command.CommandInfo;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandInfo(name = "trash", aliases = {"basurero"}, playerOnly = true)
public class TrashCommand extends Command {

    @Override
    public boolean onCommand(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        p.sendMessage(Utilities.toColor("&8&l「&a&l✔&8&l」&b¡Has abierto el basurero!"));
        p.openInventory(Bukkit.createInventory(null, 9, Utilities.toColor("&e&lϟ &4&lBasurero &e&lϟ")));
        return true;
    }
}
