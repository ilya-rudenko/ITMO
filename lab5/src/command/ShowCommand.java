package command;

import collections.MovieCollection;

public class ShowCommand implements Command{
    private MovieCollection collection;

    public ShowCommand(MovieCollection collection){
        this.collection=collection;
    }

    @Override
    public void execute(String arg) {
        collection.print();
    }
}
