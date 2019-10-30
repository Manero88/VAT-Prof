package ApplicationLogic;

import Controller.Shape;

public class Cuboid extends Vorm implements Shape {

    private final double height, length, width;


    public Cuboid(double height, double length, double width){
        this.name = "Cuboid";
        this.height = height;
        this.length = length;
        this.width = width;

        this.volume = calculateVolume();

    }


    @Override
    public double calculateVolume() {
        return this.length * this.height * this.width;
    }

    @Override
    public String printInfo() {
        return "       Type: " + name + " h: " + height + " l: " + length + " w: " + width + " Volume = " + volume;
    }

    @Override
    public double getVolume(){
        return volume;
    }

}

