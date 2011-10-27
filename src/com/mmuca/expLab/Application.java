package com.mmuca.expLab;

import com.mmuca.expLab.ui.ApplicationFrame;

import javax.swing.*;

public class Application{

    public static void main(String[] args) {
        JFrame frame = new ApplicationFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(1024, 800);
        frame.setVisible(true);
    }
}
