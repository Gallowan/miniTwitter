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
 * ~Visitor Class~
 * Main class for the visitor pattern interface to be
 * implemented. Counts the visits to specific classes.
 */

public interface Visitor {
    int visit(UserCount userTotal);
    int visit(MessageCount messageTotal);
    int visit(GroupCount groupTotal);
    int visit(Percentage positive);
}
