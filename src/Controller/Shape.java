package Controller;

/**
 * Shape interface. Elke klasse die deze interface implementeert MOET de methodes calculateVolume en printInfo hebben.
 * In printInfo komen de waardes uit die nodig zijn om te vorm te berekenen. Dit is om op te slaan in de DB.
 */

public interface Shape {
    double calculateVolume();
    double getVolume();
    String printInfo();
}
