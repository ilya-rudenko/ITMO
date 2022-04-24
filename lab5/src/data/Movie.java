package data;

import java.time.format.DateTimeFormatter;
import java.util.Formatter;

public class Movie implements Comparable<Movie> {
    //done
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    //done
    private String name; //Поле не может быть null, Строка не может быть пустой
    //done
    private Coordinates coordinates; //Поле не может быть null
    //done
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    //done
    private Integer oscarsCount; //Значение поля должно быть больше 0, Поле не может быть null
    //done
    private Integer goldenPalmCount; //Значение поля должно быть больше 0, Поле не может быть null
    //done
    private MovieGenre genre; //Поле может быть null
    //done
    private MpaaRating mpaaRating; //Поле может быть null
    //done
    private Person director; //Поле может быть null

    public Movie(String name,Coordinates coordinates,Integer oscarsCount,Integer goldenPalmCount,MovieGenre genre,MpaaRating mpaaRating,Person director){
        this.name=name;
        this.coordinates=coordinates;
        this.oscarsCount=oscarsCount;
        this.goldenPalmCount=goldenPalmCount;
        this.genre=genre;
        this.mpaaRating=mpaaRating;
        this.director=director;
    }
    public Movie(String name){
        this.name=name;
        coordinates=null;
        creationDate=null;
        oscarsCount=1;
        goldenPalmCount=null;
        genre=null;
        mpaaRating=null;
        director=null;
    };
    public Movie(String name,Integer oscarsCount){
        this.name=name;
        coordinates=null;
        creationDate=null;
        this.oscarsCount=oscarsCount;
        goldenPalmCount=null;
        genre=null;
        mpaaRating=null;
        director=null;
    };
    public Movie(String name,Integer oscarsCount,MovieGenre genre){
        this.name=name;
        coordinates=null;
        creationDate=null;
        this.oscarsCount=oscarsCount;
        goldenPalmCount=null;
        this.genre=genre;
        mpaaRating=null;
        director=null;
    };

    public void setId(Integer id) {
        this.id = id;
    }
    public void setTime(java.time.LocalDateTime creationDate){
        this.creationDate=creationDate;
    }
    public Integer getId(){
        return id;
    }
    public Integer getOscarsCount(){
        return oscarsCount;
    }

    @Override
    public int compareTo (Movie o){ return this.id-o.getId();}

    public int compareToByOscarsCount(Movie o){return this.oscarsCount-o.getOscarsCount();}

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return  "--------------------------------------------"+"\n"+
                "id               :" + id + "\n" +
                "name             :" + name + "\n" +
                "coordinates      :" + coordinates + "\n" +
                "creationDate     :" + creationDate.format(formatter) + "\n" +
                "oscarsCount      :" + oscarsCount + "\n" +
                "goldenPalmCount  :" + goldenPalmCount + "\n" +
                "genre            :" + genre + "\n" +
                "mpaaRating       :" + mpaaRating + "\n" +
                "director         :" +"\n"+ director +
                "--------------------------------------------";
    }
}
