package ApplicationLogic;

public class Sphere implements Shape {
    private String name;
    private final double radius, volume;


    public Sphere(String name, double radius) {
        this.radius = radius;
        this.name = name;

        this.volume = (4.0/3.0) * Math.PI * Math.pow(radius,3);
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
