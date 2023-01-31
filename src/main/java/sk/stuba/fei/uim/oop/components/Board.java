package sk.stuba.fei.uim.oop.components;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.player.Player;

import java.awt.*;

public class Board {
@Getter
@Setter
    private Square [][] squares;
    public void setBoard(int size,Player[] players){
        this.squares=new Square[size][size];
            for (int i=0;i<size;i++){
                for (int x=0;x<size;x++){
                    if ((i==((size/2)-1) &&x==((size/2)-1)) || (i==(size/2) &&x==(size/2)))
                    {
                        this.squares[i][x]=(new Square(players[1]));
                    }
                    else if ((i==((size/2)-1) &&x==((size/2))) || (i==(size/2) &&x==(size/2-1))){
                        this.squares[i][x]=(new Square(players[0]));
                    }
                    else {
                        this.squares[i][x]=(new Square(null));
                    }
                    if(i%2==0){
                        if(x%2==0){
                            this.squares[i][x].setColorBackground(new Color(0x1F6A75));
                        }
                        else {
                            this.squares[i][x].setColorBackground(Color.cyan);
                        }
                    }
                    else{
                        if(x%2!=0){
                            this.squares[i][x].setColorBackground(new Color(0x1F6A75));
                        }
                        else {
                            this.squares[i][x].setColorBackground(Color.cyan);
                        }
                    }
                }
            }
        }
    public void setNeigbours(){
            for(int i=0;i<this.squares.length;i++){
                for (int z=0;z<this.squares.length;z++){
                    if(i!=0){
                        this.squares[i][z].getNeighbours().setNeighboursNorth(this.squares[i-1][z]);
                    }
                    if(i!=0 && z!=0){
                        this.squares[i][z].getNeighbours().setNeighboursNorthWest(this.squares[i-1][z-1]);
                    }
                    if(z!=0){
                        this.squares[i][z].getNeighbours().setNeighboursWest(this.squares[i][z-1]);
                    }
                    if(z!=0 && i!=(this.squares.length-1)){
                        this.squares[i][z].getNeighbours().setNeighboursSouthWest(this.squares[i+1][z-1]);
                    }
                    if(i!=(this.squares.length-1)){
                        this.squares[i][z].getNeighbours().setNeighboursSouth(this.squares[i+1][z]);
                    }
                    if(z!=this.squares.length-1&&i!=(this.squares.length-1)){
                        this.squares[i][z].getNeighbours().setNeighboursSouthEast(this.squares[i+1][z+1]);
                    }
                    if(z!=this.squares.length-1){
                        this.squares[i][z].getNeighbours().setNeighboursEast(this.squares[i][z+1]);
                    }
                    if(i!=0&&z!=this.squares.length-1){
                        this.squares[i][z].getNeighbours().setNeighboursNorthEast(this.squares[i-1][z+1]);
                    }


                }
            }

    }
}
