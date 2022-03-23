package ants;

public enum Direction {

    UP,
    DOWN,
    LEFT,
    RIGHT;

    private Direction() {

    }

    public static Direction fromString(String s) {
        switch (s.toLowerCase()) {
            case "up":
                return Direction.UP;
            case "down":
                return Direction.DOWN;
            case "left":
                return Direction.LEFT;
            case "right":
                return Direction.RIGHT;

            default:
                return null;
        }
    }

    public static Direction calculateDirection(Direction x, Direction y) {
        if (x == Direction.UP) {
            switch (y) {
                case UP:
                    return Direction.UP;
                case DOWN:
                    return Direction.DOWN;
                case LEFT:
                    return Direction.LEFT;
                case RIGHT:
                    return Direction.RIGHT;
            }
        } else if (x == Direction.DOWN) {
            switch (y) {
                case UP:
                    return Direction.DOWN;
                case DOWN:
                    return Direction.UP;
                case LEFT:
                    return Direction.RIGHT;
                case RIGHT:
                    return Direction.LEFT;
            }
        } else if (x == Direction.LEFT) {
            switch (y) {
                case UP:
                    return Direction.LEFT;
                case DOWN:
                    return Direction.RIGHT;
                case LEFT:
                    return Direction.DOWN;
                case RIGHT:
                    return Direction.UP;
            }
        } else if (x == Direction.RIGHT) {
            switch (y) {
                case UP:
                    return Direction.RIGHT;
                case DOWN:
                    return Direction.LEFT;
                case LEFT:
                    return Direction.UP;
                case RIGHT:
                    return Direction.DOWN;
            }
        }
        return null;
    }

}
