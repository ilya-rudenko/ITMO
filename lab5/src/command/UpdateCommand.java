package command;

import collections.MovieCollection;

public class UpdateCommand implements Command{
    private MovieCollection collection;

    public UpdateCommand(MovieCollection collection){
        this.collection=collection;
    }

    @Override
    public void execute(String arg) {
        collection.update(arg);
    }
}