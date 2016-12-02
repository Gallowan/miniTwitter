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
 * ~User Class~
 * Base user class. 
 * Uses the component and observer interfaces, making usage of both
 * the Composite and Observer design patterns. Utilizes DefaultListModel
 * for simple listing.
 */

public class User implements Component, Observer {
    
    //private DefaultListModel componentList = new DefaultListModel();
    private String userName;
    
    private List<String> messages;
    private List<String> followers;
    private List<String> follows;
    private List<String> friendMessages;
    private List<String> newsFeed;
    
    public User(String name) {
        userName = name;
        messages = new ArrayList<String>();
        followers = new ArrayList<String>();
        follows = new ArrayList<String>();
        friendMessages = new ArrayList<String>();
    }
    
    public List<String> getFollowers() {
        return followers;
    }
    public List<String> getMessages() {
        return (ArrayList<String>) messages;
    }
    public List<String> getFollows() {
        return follows;
    }
    public List<String> getFriendMessages() {
        return (ArrayList<String>) friendMessages;
    }
    public List<String> getNewsFeed() { return (ArrayList<String>) newsFeed; }
    
    public void addFollows(String string) {
        follows.add(string);
    }
    public void addFollowers(String string) {
        followers.add(string);
    }
    public void addMessages (String string) {
        messages.add(string);
    }
    public void update(String string) { newsFeed.add(string); }
    
    public String getName() {
        return userName;
    }
    public User getUser() { return User.this; }
    //public User clone() {
    //    User user = new User();
    //    user.clone();
    //    return user;
    //}
    
    public void updateFriendMessages(String string) {
        friendMessages.add(string);
    }
}
