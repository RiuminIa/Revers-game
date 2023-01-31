package sk.stuba.fei.uim.oop.graphics;

import sk.stuba.fei.uim.oop.player.Player;

import javax.swing.*;
import java.awt.*;
public class ScoreLabel extends JLabel {
    private Player player;
    public ScoreLabel(Player player){
        this.player=player;
        this.setText(this.player.toString());
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setText(this.player.toString());
        this.player.drawLogo(g,this);
    }

}
