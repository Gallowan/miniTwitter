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
 * ~Observer Interface~
 * Creates an interface of the name "Observer" as an update receiver.
 * Used as a step in implementing an Observer Design Pattern, which updates
 * objects based on their dependence to others.
 */

public interface Observer {
    public void update(String string);
}
