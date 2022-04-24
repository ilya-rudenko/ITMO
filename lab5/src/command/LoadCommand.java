package command;

import collections.MovieCollection;

public class LoadCommand implements Command{
    private MovieCollection collection;

    public LoadCommand(MovieCollection collection){
        this.collection=collection;
    }

    @Override
    public void execute(String arg) {
        collection.load(arg);
    }
}
