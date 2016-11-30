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
 * ~VisitProcedure Interface~
 * The interface of the procedure that allows the visitation
 * of other classes. Implemented by the count classes, as well
 * as a few others.
 */

public interface VisitProcedure {
    public int accept (Visitor visitor);
}
