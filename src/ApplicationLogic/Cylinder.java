package ApplicationLogic;

import Controller.Shape;

public class Cylinder extends Vorm {

    private double radius, height;

    public Cylinder(double radius, double height) {
        this.name = "Cylinder";
        this.radius = radius;
        this.height = height;

        this.volume = calculateVolume();
    }

    @Override
    public double calculateVolume() {
        return Math.PI * Math.pow(this.radius,2.0) * this.height;
    }

    @Override
    public String printInfo() {
        return "       Type: " + name + " r: " + radius + " h: " + height + " Volume = " + volume;
    }

    @Override
    public double getVolume() {
        return volume;
    }
}
