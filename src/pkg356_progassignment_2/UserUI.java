package pkg356_progassignment_2;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;


/**
 * CS 356.01: Object-Oriented Programming
 * Professor: Yu Sun
 *
 * Programming Assignment #2
 * <mini-Twitter>
 *
 * Justin Galloway
 *
 * ~UserUI Class~
 * User interface that faces the user.
 */

public class UserUI extends JFrame implements Observable {

    private JPanel window;
    private JTextArea userNameEntry;
    private JTextArea messageEntry;
    private JList listFollowing;
    private JList listNews;
    private DefaultListModel listNewsModel = new DefaultListModel();
    private DefaultListModel listFollowingModel = new DefaultListModel();
}
