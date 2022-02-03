package framework.command;

public class CommandManager {

    public void submit(Command<?> command) {
        command.execute();
    }
}
