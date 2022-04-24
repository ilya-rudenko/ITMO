package data;

public class Location {
    private Long x; //Поле не может быть null
    private float y;
    private long z;
    public Location(Long x,float y, long z){
        this.x=x;
        this.y=y;
        this.z=z;
    }

    @Override
    public String toString() {
        return "x: " + x + ", y: " + y + ", z: " + z;
    }
}
