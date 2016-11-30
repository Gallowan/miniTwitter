package pkg356_progassignment_2;

import java.util.List;
import java.util.ArrayList;

/**
 * CS 356.01: Object-Oriented Programming
 * Professor: Yu Sun
 * 
 * Programming Assignment #2
 * <mini-Twitter>
 * 
 * Justin Galloway
 * 
 * ~Group Class~
 * Class that manages the group feature of the program.
 * Implemented on top of the Element interface.
 */

public class Group implements Element {
    
    private String groupName;
    
    private List<Element> userList;
    private List<Element> groupList;

    public Group(String name) {
        groupName = name;
        userList = new ArrayList<Element>();
        groupList = new ArrayList<Element>();
    }
    
    public void newUser(User user) {
        userList.add(user);
    }
    public void newGroup(Group group) {
        groupList.add(group);
    }
    
    public String getID() {
        return groupName;
    }
}
