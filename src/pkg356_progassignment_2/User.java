/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * ~User Class~
 * Base user class. 
 * Uses the component and observer interfaces, making usage of both
 * the Composite and Observer design patterns. Utilizes DefaultListModel
 * for simple listing.
 */

public class User implements Component, Observer {
    
    private DefaultListModel componentList = new DefaultListModel();
    private String userName;
    
    private List<String> messages;
    private List<String> followers;
    private List<String> follows;
    private List<String> friendMessages;
    
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
    
    public void addFollows(String string) {
        follows.add(string);
    }
    public void addFollowers(String string) {
        followers.add(string);
    }
    public void addMessages (String string) {
        messages.add(string);
    }
    
    public String getName() {
        return userName;
    }
    
    public void updateFriendMessages(String string) {
        friendMessages.add(string);
    }
}
