package command;

import collections.MovieCollection;


public class MinByOscarsCountCommand implements Command{
    private MovieCollection collection;

    public MinByOscarsCountCommand(MovieCollection collection){
        this.collection=collection;
    }

    @Override
    public void execute(String arg) {
        collection.minByOscarsCount();
    }
}
