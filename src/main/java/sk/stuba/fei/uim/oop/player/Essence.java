package sk.stuba.fei.uim.oop.player;

import java.awt.*;

public enum Essence {
    PEOPLE(Color.black,"Player"),
    COMPUTER(Color.white,"Computer");
    private final Color color;
    private final String name;
    Essence(Color color,String name){
        this.color=color;
        this.name=name;
    }

    public Color getColor() {
        return this.color;
    }
    public String getName() {
        return this.name;
    }
}
