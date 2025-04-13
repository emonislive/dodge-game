package com.project.game;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

// window for the game
public class Window extends Canvas {

    public Window(int width, int height, String title, Game game) {
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);          // to start the window in the middle
        frame.add(game);                          // adding game class to the frame
        frame.setVisible(true);
        game.start();
    }

}
