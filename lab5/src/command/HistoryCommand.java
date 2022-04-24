package command;

import collections.MovieCollection;

public class HistoryCommand implements Command{
    private Console console;

    public HistoryCommand(Console console){
        this.console=console;
    }

    @Override
    public void execute(String arg) {
        console.returnHistory();
    }
}