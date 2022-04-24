package command;

import collections.MovieCollection;


public class AddCommand implements Command{
    private MovieCollection collection;

    public AddCommand(MovieCollection collection){
        this.collection=collection;
    }

    @Override
    public void execute(String arg) {
        collection.add();
    }
}
