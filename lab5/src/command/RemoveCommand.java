package command;

import collections.MovieCollection;

public class RemoveCommand implements Command{
    private MovieCollection collection;

    public RemoveCommand(MovieCollection collection){
        this.collection=collection;
    }

    @Override
    public void execute(String arg) {
        collection.remove(arg);
    }
}