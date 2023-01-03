package hqwks.core.commands;

@CommandInfo(name = "example", aliases = {"test"}, playerOnly = true)
public class TestCommand extends Command {

    @Override
    public void onCommand(CommandSender sender, String[] args) {
      Player player = (Player) sender;
      sender.sendMessage(ChatColor.GREEN + "This is a test command.");
    }
}
