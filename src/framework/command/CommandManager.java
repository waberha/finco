package framework.command;

public class CommandManager {

    public void execute(Command<?> command) {
        command.execute();
    }
}
