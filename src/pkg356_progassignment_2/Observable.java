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
 * ~Observable Interface~
 * Creates an interface of the name "Observable" as a watcher for updates.
 * Used as a step in implementing an Observer Design Pattern, which updates
 * objects based on their dependence to others.
 */

public interface Observable {
    public void regObserver(Observer observer);
    public void tellObserver();
    public void remObserver(Observer observer);
}
