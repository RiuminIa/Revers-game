package sk.stuba.fei.uim.oop.graphics;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.components.Square;

import sk.stuba.fei.uim.oop.logic.UniversalLogic;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class Cage extends JPanel {
    private UniversalLogic logic;
    private Square square;
    public Cage(UniversalLogic logic,Square square) {
        this.logic=logic;
        this.addMouseListener(logic);
        this.addMouseMotionListener(logic);
        this.setBackground(Color.CYAN);
        this.square=square;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.square.draw(g,this);
    }
}

