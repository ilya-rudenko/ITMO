package collections;

import data.*;
import stream.StreamManager;
import java.util.TreeSet;
import java.util.Vector;




public class MovieCollection {
    TreeSet<Movie> collection;
    StreamManager streamManager;
    java.time.LocalDateTime collectionCreationDate;

    private Integer lastId;

    public MovieCollection(StreamManager streamManager){
        collection =new TreeSet<Movie>();
        this.streamManager=streamManager;
        collectionCreationDate=java.time.LocalDateTime.now();
        lastId=0;
    }

    public void setStreamManager(StreamManager streamManager) {
        this.streamManager = streamManager;
    }

    public void add() {
        Movie temp = collectMovie();

        temp.setId(lastId+1);
        lastId+=1;
        temp.setTime(java.time.LocalDateTime.now());
        collection.add(temp);

        streamManager.print("Element was successfully added",1);
    }

    public void addIfMax(){
        Movie temp = collectMovie();

        temp.setId(lastId+1);
        lastId+=1;
        temp.setTime(java.time.LocalDateTime.now());

        for(Movie movie: collection){
            if (movie.compareToByOscarsCount(temp)>0){
                streamManager.print("Element wasn't added",1);
                return;
            }
        }

        collection.add(temp);
        streamManager.print("Element was successfully added",1);
    }

    public void removeLower(){
        Movie temp = collectMovie();
        Vector<Integer> vec = new Vector<Integer>();

        for(Movie movie: collection){
            if (movie.compareToByOscarsCount(temp)<0){
                vec.add(movie.getId());
            }
        }
        vec.forEach(arg->delete(arg));
        streamManager.print("Elements were successfully deleted",1);
    }

    public void minByOscarsCount(){
        if (collection.isEmpty()){
            streamManager.print("Collection is empty",2);
            return;
        }
        Movie temp=collection.first();

        for (Movie movie: collection){
            if (movie.compareToByOscarsCount(temp)<0){
                temp=movie;
            }
        }
        streamManager.print(temp,2);

    }

    public void update(String arg){
        try{
            Integer id=Integer.valueOf(arg);
            if (delete(id)){

                Movie temp =collectMovie();
                temp.setId(id);
                collection.add(temp);
                streamManager.print("Element was successfully updated",1);
            }
            else {
                streamManager.print("No such ID in collection",0);
            }
        }
        catch (Exception e){
            streamManager.print("Argument is not an integer",0);
        }
    }

    public void remove(String arg){
        try{
            Integer id=Integer.valueOf(arg);
            if (delete(id)){
                streamManager.print("Element was successfully deleted",1);
            }
            else {
                streamManager.print("No such ID in collection",0);
            }
        }
        catch (Exception e){
            streamManager.print("Argument is not an integer",0);
        }
    }
    public void countGreater(String arg){
        try {
            Integer count = Integer.valueOf(arg);
            Integer res = 0;
            for (Movie movie : collection) {
                if (movie.getOscarsCount()>count) res+=1;
            }
            streamManager.print(String.valueOf(res),2);
        }
        catch(Exception e) {
            streamManager.print("Argument is not a number",0);
        }
    }
    public void printAscending(){
        print();
    }

    public boolean delete(Integer id){
        if (collection.isEmpty()){
            streamManager.print("Collection is empty",1);
            return true;
        }
        for (Movie movie: collection){
            if (movie.getId()==id){
                collection.remove(movie);
                streamManager.print("Element was successfully deleted",1);
                return true;
            }
        }
        return false;
    }

    public void clear(){
        collection.clear();
        streamManager.print("Collection was cleared successfully",1);

    }

    public boolean save(String path){
        if (streamManager.writeToFile(path,collection)) {
            streamManager.print("Collection was saved successfully",1);
            return true;
        }
        streamManager.print("Collection wasn't saved",0);
        return false;
    }

    public boolean load(String path){
        if (streamManager.loadFromFile(path)!=null){
            collection =streamManager.loadFromFile(path);
            lastId=0;
            for (Movie movie: collection){
                if (movie.getId()>=lastId) lastId=movie.getId()+1;
            }
            streamManager.print("Collection was loaded successfully",1);
            return true;
        }
        streamManager.writeToFile(path,collection);
        return true;
    }

    public void print(){
        if (collection.isEmpty()){
            streamManager.print("Collection is empty",2);
        }
        else collection.forEach((temp)->streamManager.print(temp,2));
    }

    public void help(){
        streamManager.print(
                    "help                                           : just help" + "\n"+
                        "info                                           : information about collection" + "\n"+
                        "show                                           : show all elements of collection" +"\n"+
                        "add {element}                                  : add element to collection" +"\n"+
                        "update id {element}                            : update element by id" +"\n"+
                        "remove_by_id id                                : remove element by id" +"\n"+
                        "clear                                          : clear collection" +"\n"+
                        "save                                           : save collection to the file" + "\n"+
                        "execute_script file_name                       : execute script" +"\n"+
                        "exit                                           : exit from application" + "\n"+
                        "add_if_max {element}                           : add element if it has max oscars count" + "\n"+
                        "remove_lower {element}                         : remove all elements that lower than inputed element" + "\n"+
                        "history                                        : print last 13 commands" + "\n"+
                        "min_by_oscars_count                            : print element that has minimum of oscars count" + "\n"+
                        "count_greater_than_oscars_count oscarsCount    : print the amount of elements that has oscars more than oscarsCount" + "\n"+
                        "print_ascending                                : print elements in ascending order",2);
    }
    public void info(){
        streamManager.print(
                    "Collection Type     : TreeSet"+"\n"+
                        "Amount of elements  : " + collection.size()+"\n"+
                        "Date of creation    : " + collectionCreationDate,2);
    }


    public Movie collectMovie(){
        String movieName = streamManager.stringRequest("Input movie name: ",false);

        Integer xCoordinate = streamManager.intRequest("Input movie X coordinate: ",false,null,293);
        Integer yCoordinate = streamManager.intRequest("Input movie Y coordinate: ",false,null,686);


        Integer movieOscarsCount = streamManager.intRequest("Input movie number of oscars: ",false,1,null);
        Integer goldenPalmCount = streamManager.intRequest("Input movie number of golden palms: ",false,1,null);


        MovieGenre movieGenre = MovieGenre.getEnum(
                streamManager.enumRequest("Input movie genre (ACTION, MUSICAL, THRILLER, HORROR, FANTASY): ",MovieGenre.ACTION,true),true
        );
        MpaaRating mpaaRating= MpaaRating.getEnum(
                streamManager.enumRequest("Input movie MPAA Rating (G, PG, PG_13): ",MpaaRating.G,true),true
        );

        //person
        String personName = streamManager.stringRequest("Input director's name: ",false);
        Integer personHeight = streamManager.intRequest("Input director's height: ",false,1,null);
        Color eyeColor = Color.getEnum(
                streamManager.enumRequest("Input director's color of eyes (GREEN, RED, ORANGE, WHITE): ",Color.GREEN,false),false
        );
        Color hairColor = Color.getEnum(
                streamManager.enumRequest("Input director's color of hair (GREEN, RED, ORANGE, WHITE): ",Color.GREEN,false),false
        );
        Country nationality = Country.getEnum(
                streamManager.enumRequest("Input director's nationality (RUSSIA, USA, CHINA, ITALY, THAILAND): ",Country.USA,true),true
        );

        Integer personX = streamManager.intRequest("Input person X coordinate: ",false,null,null);
        Integer personY = streamManager.intRequest("Input person Y coordinate: ",false,null,null);
        Integer personZ = streamManager.intRequest("Input person Z coordinate: ",false,null,null);

        return new Movie(movieName,new Coordinates(xCoordinate,yCoordinate),movieOscarsCount,goldenPalmCount,movieGenre,mpaaRating,new Person(personName,(long)personHeight,eyeColor,hairColor,nationality,new Location((long)personX,personY,personZ)));
    }

}