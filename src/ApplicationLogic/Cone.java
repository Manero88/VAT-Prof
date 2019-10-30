package ApplicationLogic;

import Controller.Shape;

public class Cone extends Vorm implements Shape {
    private double radius, heigth;

    public Cone(double radius, double heigth) {
        this.name = "Cone";
        this.radius = radius;
        this.heigth = heigth;

        this.volume = calculateVolume();
    }

    @Override
    public double calculateVolume() {
        return (1.0 / 3.0) * Math.PI * Math.pow(this.radius, 2.0) * this.heigth;
    }

    @Override
    public String printInfo() {
        return "       Type: " + name + " r: " + radius + " h: " + heigth + " Volume = " + volume;
    }

    @Override
    public double getVolume() {
        return volume;
    }
}
