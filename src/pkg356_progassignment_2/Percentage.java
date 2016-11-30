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
 * ~Percentage Class~
 * Accepts and counts visits from the visitor pattern interface.
 */

public class Percentage implements VisitProcedure{

    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
