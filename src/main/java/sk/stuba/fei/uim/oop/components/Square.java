package sk.stuba.fei.uim.oop.components;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.graphics.Cage;
import sk.stuba.fei.uim.oop.player.Player;

import java.awt.*;
@Getter
@Setter
public class Square {
    private Player ownerPlayer;
    private Neighbours neighbours;
    private boolean possibleMove;
    private boolean mouseAktive;
    @Setter
    private Color colorBackground;

    public Square (Player player){
        this.neighbours=new Neighbours();
        this.ownerPlayer=player;
        this.possibleMove=false;
        this.mouseAktive=false;
    }

    public void draw(Graphics g, Cage cage){
        g.setColor(Color.GRAY);
        g.drawRect(0,0,cage.getWidth(),cage.getHeight());
        cage.setBackground(this.colorBackground);
        if (this.ownerPlayer != null) {
              this.ownerPlayer.drawRock(g,cage.getWidth(),cage.getHeight());
        }
        else if(possibleMove){
            cage.setBackground(Color.GREEN);
            if (this.mouseAktive){
                ((Graphics2D) g).setStroke(new BasicStroke(3));
                g.setColor(Color.white);
                g.drawOval(2, 1, cage.getWidth()-5, cage.getHeight()-5);
            }
        }
        else{
            if (this.mouseAktive){
                g.setColor(Color.red);
                g.fillOval(2, 1, cage.getWidth()-5, cage.getHeight()-5);
            }
        }
    }
    protected void setOwnerPlayer(Player player){
        if (this.ownerPlayer!=null && this.ownerPlayer!=player)
        {
            this.ownerPlayer.decCountRock();
        }
        player.incCountRock();
        this.ownerPlayer=player;
    }
}
