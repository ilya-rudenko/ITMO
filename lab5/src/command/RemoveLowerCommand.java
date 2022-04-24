package command;

import collections.MovieCollection;

public class RemoveLowerCommand implements Command{
    private MovieCollection collection;

    public RemoveLowerCommand(MovieCollection collection){
        this.collection=collection;
    }

    @Override
    public void execute(String arg) {
        collection.removeLower();
    }
}