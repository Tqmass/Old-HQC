package hqwks.core.commands;

import hqwks.core.CoreMain;
import hqwks.core.utils.command.Command;
import hqwks.core.utils.command.CommandInfo;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
@CommandInfo(name = "resetkit", aliases = {"rk"}, playerOnly = true)
public class ResetKitCommand extends Command {

    @Override
    public boolean onCommand(CommandSender sender, String[] args) {

        Player p = (Player) sender;
        if(sender instanceof Player){
            p.chat("/kitbattle spawn");
        } else {
            Bukkit.getConsoleSender().sendMessage("¡Este comando no puede usarse en consola!");
        }

        return true;
    }
}
