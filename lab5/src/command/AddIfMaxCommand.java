package command;

import collections.MovieCollection;

public class AddIfMaxCommand implements Command{
    private MovieCollection collection;

    public AddIfMaxCommand(MovieCollection collection){
        this.collection=collection;
    }

    @Override
    public void execute(String arg) {
        collection.addIfMax();
    }
}