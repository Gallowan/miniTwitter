package pkg356_progassignment_2;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import javax.swing.*;


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
    private JTextField followUserInput;
    private JButton followUser;

    private HashMap<String, User> userMap = AdminCP.getUserMap();
    private String tweet;
    private User user;

    private JLabel currentFollows;
    private ArrayList<String> followNameList;
    private DefaultListModel followsListModel;
    private JList followsList;

    private JLabel newsFeedLabel;
    private List<String> newsFeed;
    private DefaultListModel newsFeedModel;
    private JList newsFeedList;

    private JTextField tweetInput;
    private JButton postTweet;

    private String nameFollow;

    public UserUI(User user) {

        //Generate GUI components
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 450);

        user = user.getUser();

        window = new JPanel();
        setContentPane(window);
        window.setLayout(null);

        newsFeedModel = new DefaultListModel();

        followUserInput = new JTextField();
        followUserInput.setBounds(10, 10, 270, 20);
        window.add(followUserInput);

        followUser = new JButton("Follow User");
        followUser.setBounds(290, 10, 115, 25);
        followUser.addActionListener(new FollowUserListener());
        window.add(followUser);

        currentFollows = new JLabel("Currently Following:");
        //20 to 10
        currentFollows.setBounds(10, 45, 175, 15);
        window.add(currentFollows);

        followsListModel = new DefaultListModel();
        followsList = new JList(followsListModel);
        followsList.setBounds(10, 65, 415, 145);
        window.add(followsList);
        followNameList = (ArrayList<String>) user.getFollows();
        //followNameList = (ArrayList<String>) user.getFollows().clone();

        //Add followings to list
        for (int i = 0; i < followNameList.size(); i++){
            followsListModel.addElement(followNameList.get(i));
        }

        tweetInput = new JTextField();
        tweetInput.setBounds(10, 230, 270, 20);
        window.add(tweetInput);

        postTweet = new JButton("Post tweet");
        postTweet.setBounds(290, 230, 115, 25);
        postTweet.addActionListener(new PostTweetListener());
        window.add(postTweet);

        newsFeedLabel = new JLabel("News Feed:");
        newsFeedLabel.setBounds(10, 265, 210, 15);
        window.add(newsFeedLabel);

        newsFeedList = new JList(newsFeedModel);
        newsFeedList.setBounds(10, 290, 415, 115);
        newsFeed = (ArrayList<String>) user.getNewsFeed();
        //newsFeed = (ArrayList<String>) user.getNewsFeed().clone();
        window.add(newsFeedList);

        //Adds tweets to the newsfeed
        for (int i = 0; i < newsFeed.size(); i++){
            newsFeedModel.addElement(newsFeed.get(i));
        }

        //followScrollPane = new JScrollPane(followsList);
        //followScrollPane.setBounds(10, 65, 415, 145);
        //window.add(followingScrollPane);

        //newsFeedScrollPane = new JScrollPane(newsFeedList);
        //newsFeedScrollPane.setBounds(10, 290, 415, 115);
        //window.add(newsFeedScrollPane);
    }

    //Notifies observers of a new tweet for updating.
    public void tellObserver(String tweet) {
        for (int i = 0; i < user.getFollowers().size(); i++) {
            String follower = user.getFollowers().get(i);
            userMap.get(follower).update(tweet);
        }
    }

    //Adds the follow to the corresponding user
    public void followConfirm(String name){
        user.addFollows(name);
        userMap.get(name).addFollows(user.getName());
    }

    //Listens for following and handles accordingly
    private class FollowUserListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            //Set the user ID of the user to follow
            nameFollow = followUserInput.getText();

            if(!userMap.containsKey(nameFollow)) {
                JOptionPane.showMessageDialog(null, "User doesn't exist!");
            } else if (nameFollow.equals(user.getName())) {
                JOptionPane.showMessageDialog(null, "You can't follow yourself!");
            } else if(user.getFollows().contains(nameFollow)){
                JOptionPane.showMessageDialog(null, "You already follow this user.");
            } else {
                followConfirm(nameFollow);
                JOptionPane.showMessageDialog(null, "You are now following this user.");
                followsListModel.addElement(nameFollow);
            }
        }
    }

    private class PostTweetListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            //Formats tweet
            tweet = "@" + user.getName() + "\n   " + tweetInput.getText();

            //User sends tweet to all observers (followers)
            tellObserver(tweet);
            user.update(tweet);
            newsFeedModel.addElement(tweet);;

            //Visit total
            MessageCount tweetTotal = new MessageCount();
            tweetTotal.accept();
            //int total = visit(tweetTotal);

            //Check for postivity percentage?
            String[] words = {"positive"};

            Percentage positiveTotal = new Percentage();

            for (int i = 0; i < words.length; i++) {
                if (tweet.contains(words[i])) {
                    positiveTotal.accept();
                }
            }
        };
    }

}
