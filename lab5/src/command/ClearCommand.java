package command;

import collections.MovieCollection;

public class ClearCommand implements Command{
    private MovieCollection collection;

    public ClearCommand(MovieCollection collection){
        this.collection=collection;
    }

    @Override
    public void execute(String arg) {
        collection.clear();
    }
}
