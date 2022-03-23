package ants;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        File file = new File(System.getProperty("user.dir") + "/instructions.txt");
        int pixelWidth = 1000;
        int pixelHeight = 1000;
        int width = 200;
        int height = 200;
        boolean wait = false;
        Direction direction = Direction.UP;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Slow render? Yes/No");
        wait = scanner.next().equalsIgnoreCase("Yes");

        Board board = new Board(file, direction, width, height);
        Window window = new Window(board, "Ants", pixelHeight, pixelWidth);
        board.setWindow(window);

        long timing;

        while (true) {
            timing = System.nanoTime();
            board.updateAnt();
            window.repaint();
            if (wait)
                while (System.nanoTime() - timing < 1000000) {

                }

            //Windows has a cpu buffer time of 10 millis so I have to keep it active.
            //Making the thread sleep at all would cause an automatic delay of the time specified
            //all the way up to 10 millis
            //Thread.sleep(0, 1);
        }
    }

}
