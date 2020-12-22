package com.basic.firstPage;

import javax.swing.*;
import java.awt.*;

public class FirstPage {
    private JButton addButton;
    private JButton deleteButton;
    private JButton pauseButton;
    private JButton unpauseButton;

    JTable initialTable;

    // Initializing the frame for
    JFrame frameTable;

    FirstPage() {

        frameTable = new JFrame();
        frameTable.setTitle("The Current List of Entries");

        //Adding 4-5 rows to display

        String[][] initialData = {{"Mridula", "mridular@buffalo.edu", "Un-paused"}, {"Mridula", "mridular@buffalo.edu", "Un-paused"},
                {"Mridula", "mridular@buffalo.edu", "Un-paused"}, {"Mridula", "mridular@buffalo.edu", "Un-paused"}};

        // adding headers for the table

        String[] columnHeaders = {"Name", "Email", "Queue Status"};

        //Creating the table

        initialTable = new JTable(initialData, columnHeaders);
        initialTable.setBounds(30, 40, 100, 300);


    }

    public static void main(String[] args)
    {
        new FirstPage();
    }


}
