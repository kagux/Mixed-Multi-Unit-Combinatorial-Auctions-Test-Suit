package com.mmuca.expLab;

import com.mmuca.expLab.ui.frames.ApplicationFrame;

import javax.swing.*;

public class Application{
    public static void main(String[] args) {
        JFrame frame = new ApplicationFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
