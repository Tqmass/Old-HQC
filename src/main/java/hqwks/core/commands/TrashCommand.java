package hqwks.core.commands;

import hqwks.core.CoreMain;
import hqwks.core.utils.Utilities;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TrashCommand implements CommandExecutor {

    private CoreMain plugin;

    public TrashCommand(CoreMain plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        p.sendMessage(Utilities.toColor("&8&l「&a&l✔&8&l」&b¡Has abierto el basurero!"));
        p.openInventory(Bukkit.createInventory(null, 9, Utilities.toColor("&e&lϟ &4&lBasurero &e&lϟ")));
        return true;
    }
}