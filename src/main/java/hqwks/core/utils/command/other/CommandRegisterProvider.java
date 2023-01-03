package hqwks.core.utils.command.other;

public class CommandRegisterProvider implements CommandRegistry {

    @SuppressWarnings("unchecked")
    @Override
    public void register(Command... commands) {
        Arrays.stream(commands).forEach(iCommand -> {
            try {
                Server server = Bukkit.getServer();
                Field field = server.getClass().getDeclaredField("commandMap");
                field.setAccessible(true);
                CommandMap commandMap = (CommandMap) field.get(server);

                String name = iCommand.getName();

                org.bukkit.command.Command command = commandMap.getCommand(name);
                if (command != null) {
                    Map<String, Command> map;
                    Field commandField = commandMap.getClass().getDeclaredField("knownCommands");
                    commandField.setAccessible(true);
                    map = (Map<String, Command>) commandField.get(commandMap);
                    command.unregister(commandMap);
                    map.remove(name);
                    iCommand.getAliases().forEach(map::remove);
                }

                commandMap.register(name, iCommand);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
