package hqwks.core.commands;

import hqwks.core.CoreMain;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class ResetKitCommand implements CommandExecutor {

    private CoreMain plugin;

    public ResetKitCommand(CoreMain plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        if(sender instanceof Player){
            p.chat("/kitbattle spawn");
        } else {
            Bukkit.getConsoleSender().sendMessage("¡Este comando no puede usarse en consola!");
        }

        return true;
    }
}
