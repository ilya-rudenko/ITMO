package command;

import collections.MovieCollection;

public class InfoCommand implements Command{
    private MovieCollection collection;

    public InfoCommand(MovieCollection collection){
        this.collection=collection;
    }

    @Override
    public void execute(String arg) {
        collection.info();
    }
}