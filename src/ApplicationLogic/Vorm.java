package ApplicationLogic;

import Controller.Shape;

/**
 * De abstracte klasse Vorm. Elke modelklasse die deze abstracte klasse extends hoeft
 * geen name en volume in de constructor te zetten. De name wordt automatisch gemaakt
 * als de klasse geinstantieerd wordt en de volume wordt berekend d.m.v. de methode calculateVolume.
 */

abstract public class Vorm implements Shape {
    protected String name;
    protected double volume;


    public Vorm(){
        this.volume = calculateVolume();
    }
}
