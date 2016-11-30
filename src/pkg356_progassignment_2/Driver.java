package pkg356_progassignment_2;

/**
 * CS 356.01: Object-Oriented Programming
 * Professor: Yu Sun
 * 
 * Programming Assignment #2
 * <mini-Twitter>
 * 
 * Justin Galloway
 * 
 * ~Driver Class~
 * A class that essentially runs the program    .
 * Used as a step in implementing a Singleton Design Pattern, which provides
 * a global access point to a single instance of a class.
 */

public class Driver {
    public static void main(String[] args)
    {
        AdminControlPanel.getInst().run();
    }
}
