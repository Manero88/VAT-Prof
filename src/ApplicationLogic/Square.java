package ApplicationLogic;

public class Square implements Shape{
    private String name;
    private double length, width, volume;

    public Square(String name, double length, double width) {
        this.name = name;
        this.length = length;
        this.width = width;

        this.volume = length * width;

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
