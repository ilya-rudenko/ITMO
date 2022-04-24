package command;

import collections.MovieCollection;

public class SaveCommand implements Command{
    private MovieCollection collection;

    public SaveCommand(MovieCollection collection){
        this.collection=collection;
    }

    @Override
    public void execute(String arg) {
        collection.save(arg);
    }
}

