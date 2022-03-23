package ants;

import java.awt.*;
import java.lang.reflect.Field;

public class Instruction {

    private Color start;
    private Color end;
    private Direction direction;

    public Instruction(Color start, Color end, Direction direction) {
        this.start = start;
        this.end = end;
        this.direction = direction;
    }

    public static Instruction fromString(String data) throws Exception {
        String[] strings = data.toLowerCase().split("\\s+");
        Field field = Class.forName("java.awt.Color").getField(strings[0]);
        Field field1 = Class.forName("java.awt.Color").getField(strings[1]);
        return new Instruction((Color) field.get(null), (Color) field1.get(null), Direction.fromString(strings[2]));
    }

    public Color getStart() {
        return start;
    }

    public Color getEnd() {
        return end;
    }

    public Direction getDirection() {
        return direction;
    }

}
