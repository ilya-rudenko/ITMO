package command;

import collections.MovieCollection;

public class HelpCommand implements Command{
    private MovieCollection collection;

    public HelpCommand(MovieCollection collection){
        this.collection=collection;
    }

    @Override
    public void execute(String arg) {
        collection.help();
    }
}
