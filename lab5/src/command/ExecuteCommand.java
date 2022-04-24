package command;

import collections.MovieCollection;

public class ExecuteCommand implements Command{
    private MovieCollection collection;
    private Console console;

    public ExecuteCommand(Console console){
        this.console=console;
    }

    @Override
    public void execute(String arg) {
        console.executeScript(arg);
    }
}
