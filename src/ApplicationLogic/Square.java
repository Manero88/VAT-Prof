package ApplicationLogic;

import Controller.Shape;

public class Square extends Vorm implements Shape {
    private double length, width;

    public Square(double length, double width) {

        super();
        this.name = "Square";
        this.length = length;
        this.width = width;

    }


    @Override
    public double calculateVolume() {
        return this.length * this.width;
    }

    @Override
    public String printInfo() {
        return "       Type: " + name + " l " + length + " w " + width + " Volume = " + super.volume;
    }

    @Override
    public double getVolume() {
        return volume;
    }
}


//class unkown {
//    public static void main(String[] args) {
//
//        Square square = new Square(20,20);
//        System.out.println(square.printInfo());
//
//    }
//}