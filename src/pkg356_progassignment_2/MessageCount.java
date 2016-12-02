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
 * ~MessageCount Class~
 * Accepts and counts visits from the visitor pattern interface.
 */

public class MessageCount implements VisitProcedure{
    public static int messageCount;
    public void accept() { messageCount++; }
    //public int accept(Visitor visitor) {
    //    return visitor.visit(this);
    //}
    public int get() { return messageCount; }
}
