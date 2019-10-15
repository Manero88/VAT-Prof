package ApplicationLogic;

public class Cylinder implements Shape {
    private String name;
    private double radius, height, volume;

    public Cylinder(String name, double radius, double height) {
        this.name = name;
        this.radius = radius;
        this.height = height;

        this.volume = Math.PI * Math.pow(radius,2.0) * height;
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
