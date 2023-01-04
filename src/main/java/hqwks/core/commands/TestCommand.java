package hqwks.core.commands;

import hqwks.core.utils.command.Command;
import hqwks.core.utils.command.CommandInfo;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandInfo(name = "example", aliases = {"test"}, playerOnly = true)
public class TestCommand extends Command {

    @Override
    public void onCommand(CommandSender sender, String[] args) {
      Player player = (Player) sender;
      sender.sendMessage(ChatColor.GREEN + "This is a test command.");
    }
}
