package ants;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Window extends JFrame {

    private Board board;

    public Window(Board board, String name, int width, int height) {
        this.board = board;
        this.setTitle(name);
        this.setSize(width, height);
        this.setResizable(false);
        this.setBackground(Color.gray);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawImage(this.board.render(new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB)), 0, 0, null);
    }

}
