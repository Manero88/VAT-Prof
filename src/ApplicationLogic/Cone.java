package ApplicationLogic;

public class Cone implements Shape{
    private String name;
    private double radius, heigth, volume;

    public Cone(String name, double radius, double heigth) {
        this.name = name;
        this.radius = radius;
        this.heigth = heigth;

        this.volume = (1.0 / 3.0) * Math.PI * Math.pow(radius,2.0) * heigth;
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
