
package sk.stuba.fei.uim.oop.graphics;


import sk.stuba.fei.uim.oop.logic.UniversalLogic;


import javax.swing.*;
import java.awt.*;

public class Game {
    public Game() {
        JFrame frame=new JFrame("Othello");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.setLayout(new BorderLayout());

        UniversalLogic logic=new UniversalLogic();

        JButton restartButton=new JButton("Restart");
        restartButton.addActionListener(logic);
        restartButton.setFocusable(false);

        JSlider slider=new JSlider();
        slider.setMajorTickSpacing(2);
        slider.setMinorTickSpacing(2);
        slider.setValue(6);
        slider.setMaximum(12);
        slider.setMinimum(6);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setValueIsAdjusting(true);
        slider.setSnapToTicks(true);
        slider.addChangeListener(logic);
        slider.setOrientation(SwingConstants.VERTICAL);
        slider.setFocusable(false);



        frame.add(logic.getScoreBoardPanel(),BorderLayout.PAGE_START);
        frame.add(logic.getPanel(),BorderLayout.CENTER);
        frame.add(slider,BorderLayout.EAST);
        frame.add(restartButton,BorderLayout.PAGE_END);

        frame.addKeyListener(logic);
        frame.setFocusable(true);
        frame.setResizable(false);
        frame.setVisible(true);
    }

}
