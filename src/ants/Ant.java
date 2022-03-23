package ants;

import java.util.List;

public class Ant {

    private Direction direction;
    private Board board;
    private int x;
    private int y;

    public Ant(Board board, Direction direction, int x, int y) {
        this.board = board;
        this.direction = direction;
        this.x = x;
        this.y = y;
    }

    public void init() {
        y += 1;
    }

    public void calculateDirection(List<Instruction> instructions) {
        if (x >= board.getCells().length || x < 0 || y >= board.getCells()[0].length || y < 0)
            throw new RuntimeException("Ant has left the arena");

        Direction moveDirection = null;
        Cell cell = null;
        boolean bool = false;
        for (Instruction instruction : instructions) {
            cell = this.board.getCells()[x][y];
            if (instruction.getStart().equals(cell.getColor())) {
                cell.setColor(instruction.getEnd());
                moveDirection = instruction.getDirection();
                bool = instruction.getDirection() == Direction.RIGHT;
                break;
            }
        }

        this.direction = Direction.calculateDirection(this.direction, moveDirection);

        switch (this.direction) {
            case UP:
                y -= 1;
                break;
            case DOWN:
                y += 1;
                break;
            case LEFT:
                x -= 1;
                break;
            case RIGHT:
                x += 1;
                break;
        }
    }
}
