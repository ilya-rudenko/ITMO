package command;

import collections.MovieCollection;

public class CountGreaterCommand implements Command{
    private MovieCollection collection;

    public CountGreaterCommand(MovieCollection collection){
        this.collection=collection;
    }

    @Override
    public void execute(String arg) {
        collection.countGreater(arg);
    }
}