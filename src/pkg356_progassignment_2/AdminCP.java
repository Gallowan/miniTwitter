package pkg356_progassignment_2;

import javax.swing.*;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.tree.*;

import java.util.HashMap;
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
 * ~AdminControlPanel Class~
 * Implements Question interface to gather multiple choice answers.
 */

public class AdminCP extends JFrame implements Visitor {
    // Initialize control panel instance
    private static AdminCP instance;
    // Initialize window
    private JPanel window;
    // Initialize Data Tree
    private JTree data;
    private TreeModel treeModel;
    private DefaultMutableTreeNode root;
    private DefaultMutableTreeNode currentNode;
    // Initialize IDs
    private String userName;
    private String groupName;

    // Initialize UI Buttons and Text
    private JButton userView;
    private JButton addUser;
    private JButton addGroup;
    private JButton userTotal;
    private JButton groupTotal;
    private JButton totalMessages;
    private JButton percentage;
    private JTextField userText;
    private JTextField groupText;

    // Initialize HashMap
    private static HashMap<String, User> userMap = new HashMap<String, User>();
    private static HashMap<String, Group> groupMap= new HashMap<String, Group>();

    public static AdminCP getInstance(){
        if (instance == null)
            instance = new AdminCP();
        return instance;
    }

    private AdminCP() {
        root = new DefaultMutableTreeNode("Root");
        componentInitial();
    }

    // Initializing the components of the GUI
    public void componentInitial() {
        setBounds(100, 100, 660, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window = new JPanel();
        setContentPane(window);
        window.setLayout(null);

        userText = new JTextField(20);
        userText.setBounds(185, 10, 280, 20);
        window.add(userText);

        addUser = new JButton("Add User");
        addUser.setBounds(470, 10, 160, 25);
        addUser.addActionListener(new userListener());
        window.add(addUser);

        groupText = new JTextField(20);
        groupText.setBounds(185, 40, 280, 20);
        window.add(groupText);

        addGroup = new JButton("Add Group");
        addGroup.setBounds(470, 40, 160, 25);
        addGroup.addActionListener(new AddGroupListener());
        window.add(addGroup);

        userView = new JButton("Open User View");
        userView.setBounds(185, 70, 450, 25);
        userView.addActionListener(new UserUIListener());
        window.add(userView);

        userTotal = new JButton("Show User Total");
        userTotal.setBounds(185, 250, 220, 25);
        userTotal.addActionListener(new userTotalListener());
        window.add(userTotal);

        groupTotal = new JButton("Show Group Total");
        groupTotal.setBounds(415, 250, 220, 25);
        groupTotal.addActionListener(new groupTotalListener());
        window.add(groupTotal);

        totalMessages = new JButton("Show Tweet Total");
        totalMessages.setBounds(185, 280, 220, 25);
        totalMessages.addActionListener(new messageTotalListener());
        window.add(totalMessages);

        percentage = new JButton("Show Positive Percentage");
        percentage.setBounds(415, 280, 220, 25);
        percentage.addActionListener(new percentageListener());
        window.add(percentage);

        data = new JTree(root);
        data.setBounds(10, 5, 150, 295);
        window.add(data);

        treeModel = data.getModel();

        //treeScrollPane = new JScrollPane(tree);
        //treeScrollPane.setBounds(10, 6, 150, 295);
        //window.add(treeScrollPane);
    }

    //Adds User and confirms
    public void addUser(String name, DefaultMutableTreeNode node){
        User newUser = new User(name);
        userMap.put(name, newUser);

        //Counts +1 user
        UserCount userPlus = new UserCount();
        visit(userPlus);

        //Add the user
        node.add(new DefaultMutableTreeNode(name));
        JOptionPane.showConfirmDialog(null, "New user added.");
    }

    //Adds group and confirms
    public void addGroup(String name, DefaultMutableTreeNode node){
        Group newGroup = new Group(name);
        groupMap.put(name, newGroup);

        //Counts +1 Group
        GroupCount groupPlus = new GroupCount();
        visit(groupPlus);

        //Add the group
        node.add(new DefaultMutableTreeNode(name));
        JOptionPane.showMessageDialog(null, "New group created!");
    }

    private class userListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            //Listens to perform GUI functions in tandem with data
            userName = userText.getText();
            currentNode = (DefaultMutableTreeNode) data.getLastSelectedPathComponent();

            if (userName.isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "Enter a user to continue");
            } else if (userMap.containsKey(userName)) {
                JOptionPane.showMessageDialog(null, "Username already taken.");
            } else if (currentNode == null) {
                addUser(userName, root);
            } else if (userMap.containsKey(currentNode.toString())) {
                JOptionPane.showMessageDialog(null, "You can only create users in the Root or groups");
            } else {
                addUser(userName, currentNode);
            }
        }
    }

    private class AddGroupListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            //Same as previous, but for group input
            groupName = groupText.getText();
            currentNode = (DefaultMutableTreeNode) data.getLastSelectedPathComponent();

            if (groupName.isEmpty() == true){
                JOptionPane.showMessageDialog(null, "Please enter a group name!");
            } else if (groupMap.containsKey(groupName)){
                JOptionPane.showMessageDialog(null, "Group name already exists, please enter another.");
            } else if (currentNode == null){
                addGroup(groupName, root);
            } else if (userMap.containsKey(currentNode.toString())){
                JOptionPane.showMessageDialog(null, "You can only create groups in the Root or other groups");
            } else{
                addGroup(groupName, currentNode);
            }
        }
    }

    //Displays user UI according to the user chosen
    private class UserUIListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            //Checks the node
            currentNode = (DefaultMutableTreeNode) data.getLastSelectedPathComponent();

            //Checks if a user is selected
            if (currentNode == null || groupMap.containsKey(currentNode.toString())){
                JOptionPane.showMessageDialog(null, "Select a user.");
            } else {
                //Selects the node for ui use
                User user = userMap.get(currentNode.toString());
                UserUI userUI = new UserUI(user);
                userUI.setVisible(true);
            }
        }
    }

    private class userTotalListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            UserCount userCount = new UserCount();
            JOptionPane.showMessageDialog(null, "Total number of users: " + userCount.get());
        }
    }

    private class groupTotalListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            GroupCount groupCount = new GroupCount();
            JOptionPane.showMessageDialog(null, "Total number of groups: " + groupCount.get());
        }
    }

    private class messageTotalListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            MessageCount messageCount = new MessageCount();
            JOptionPane.showMessageDialog(null, "Total number of tweets: " + messageCount.get());
        }
    }

    private class percentageListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            Percentage percentage = new Percentage();
            JOptionPane.showMessageDialog(null, "Percent positive tweets: " + percentage.get());
        }
    }

    public static HashMap<String, User> getUserMap () {
        return userMap;
    }

    public void visit (UserCount users) {
        users.accept();
    }

    public void visit (GroupCount groups) {
        groups.accept();
    }

    public void visit (MessageCount messages) {
    }

    public void visit (Percentage per) {
    }
}
