package ApplicationLogic;

public class Cuboid implements Shape {
    private final String name;
    private final double height, length, width, volume;


    public Cuboid(String name, double height, double length, double width){

        this.name = name;
        this.height = height;
        this.length = length;
        this.width = width;

        this.volume = length * height * width;

    }


    @Override
    public String getName() {
        return name;

    }

    @Override
    public double getVolume() {
        return volume;
    }
}

