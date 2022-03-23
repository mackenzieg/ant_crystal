package ants;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Board {

    private Cell[][] cells;
    private List<Instruction> instructions = new ArrayList<>();
    private int width;
    private int height;
    private Ant ant;
    private Window window;
    private int multX;
    private int multY;

    public Board(File file, Direction start, int width, int height) {
        this.cells = new Cell[width][height];
        this.width = width;
        this.height = height;
        this.ant = new Ant(this, start, width / 2, height / 2);
        try {
            this.readDirections(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                this.cells[x][y] = new Cell(Color.gray, x, y);
            }
        }
        this.ant.init();
    }

    public void setWindow(Window window) {
        this.window = window;
        this.multX = this.window.getWidth() / width;
        this.multY = this.window.getHeight() / height;
    }

    public Cell[][] getCells() {
        return cells;
    }

    private void readDirections(File file) throws Exception {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            this.instructions.add(Instruction.fromString(line));
        }
    }

    public BufferedImage render(BufferedImage bufferedImage) {
        Graphics graphics = bufferedImage.getGraphics();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                graphics.setColor(cells[x][y].getColor());
                graphics.fillRect(x * multX, multY * y, multX * x + multX, multY * y + multY);
            }
        }
        return bufferedImage;
    }

    public void updateAnt() {
        this.ant.calculateDirection(this.instructions);
    }

}
