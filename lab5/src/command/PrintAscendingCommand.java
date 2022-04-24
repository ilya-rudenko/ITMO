

package command;

import collections.MovieCollection;


public class PrintAscendingCommand implements Command{

    private MovieCollection collection;

    public PrintAscendingCommand(MovieCollection collection){
        this.collection=collection;
    }

    @Override
    public void execute(String arg) {
        collection.printAscending();
    }
}