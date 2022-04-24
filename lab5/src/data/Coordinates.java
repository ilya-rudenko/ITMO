package data;

public class Coordinates {
    private long x; //Максимальное значение поля: 293
    private Integer y; //Максимальное значение поля: 686, Поле не может быть null

    public Coordinates (long x,Integer y){
        this.x=x;
        this.y=y;
    }

    @Override
    public String toString() {
        return "x: " + x + ", y: " + y;
    }
}
