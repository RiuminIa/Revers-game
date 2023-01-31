package sk.stuba.fei.uim.oop.player;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.graphics.ScoreLabel;

import java.awt.*;

public class Player {
    @Getter
    @Setter
    private int countRock;
    @Getter
    private Essence essence;
    public Player(Essence essence){
        this.countRock=2;
        this.essence=essence;
    }
    public void drawRock (Graphics g,int sizeWihth,int sizeHeight){
        g.setColor(this.essence.getColor());
        g.fillOval(2, 1, sizeWihth, sizeHeight);
    }
    public void incCountRock(){
        this.countRock++;
    }

    @Override
    public String toString() {
        return ""+this.essence.getName()+": "+countRock;
    }
    public void drawLogo(Graphics g, ScoreLabel scoreboard){
        g.setColor(Color.CYAN);
        g.fillRect(this.toString().length()*8,scoreboard.getVerticalTextPosition(),scoreboard.getHeight(),scoreboard.getHeight());
        g.setColor(this.essence.getColor());
        g.fillOval(this.toString().length()*8,scoreboard.getVerticalTextPosition(),scoreboard.getHeight()-2,scoreboard.getHeight()-2);
    }

    public void decCountRock(){
        this.countRock--;
    }
}
