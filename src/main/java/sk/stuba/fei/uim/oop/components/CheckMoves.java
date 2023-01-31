package sk.stuba.fei.uim.oop.components;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.player.Player;

import java.util.ArrayList;
@Getter
@Setter
public class CheckMoves {
    private Board board;
    private MoveRecords moveRecords;

    public CheckMoves(Board board) {
        this.moveRecords=new MoveRecords();
        this.board=board;
    }
    public void clear(){
        moveRecords.clear();
    }
    public void checkBoard(Player player) {
        Square[][] squares=this.board.getSquares();
        resetPossibleMoves(squares);
        for (Square[] square :this.board.getSquares() ) {
            for (int z = 0; z < this.board.getSquares().length; z++) {
                if (square[z].getOwnerPlayer() != null) {
                    if ((square[z].getOwnerPlayer()==player) && (square[z].getNeighbours().isHaveEnemyNeighbours(player))) {
                        check(square[z], player);
                    }
                }
            }
        }
    }
    private void resetPossibleMoves(Square[][] squares){
        for (Square[] square : this.board.getSquares()) {
            for (int z = 0; z < squares.length; z++) {
                square[z].setPossibleMove(false);
                square[z].setMouseAktive(false);
            }
        }
    }

    private void check(Square b, Player player) {
        Square temp;
        ArrayList<Square> squares=new ArrayList<>();
        int countPoints;
        for (int i = 0; i < 8; i++) {
            boolean flag = false;
            squares.clear();
            temp = b;
            countPoints=0;
            while (temp != null) {
                switch (i) {
                    case 0:
                        temp = temp.getNeighbours().getNeighboursNorth();
                        break;
                    case 1:
                        temp = temp.getNeighbours().getNeighboursNorthWest();
                        break;
                    case 2:
                        temp = temp.getNeighbours().getNeighboursWest();
                        break;
                    case 3:
                        temp = temp.getNeighbours().getNeighboursSouthWest();
                        break;
                    case 4:
                        temp = temp.getNeighbours().getNeighboursSouth();
                        break;
                    case 5:
                        temp = temp.getNeighbours().getNeighboursSouthEast();
                        break;
                    case 6:
                        temp = temp.getNeighbours().getNeighboursEast();
                        break;
                    case 7:
                        temp = temp.getNeighbours().getNeighboursNorthEast();
                        break;
                }
                if( temp==null){
                    break;
                }
                 if (temp.getOwnerPlayer()== null) {
                    if (flag){
                        temp.setPossibleMove(flag);
                       moveRecords.addSquare(temp,squares,countPoints);
                    }
                    break;
                }
                 else if(temp.getOwnerPlayer() == player){
                     break;
                 }
                else{
                    squares.add(temp);
                    flag = true;
                    countPoints++;
                }
            }
        }
    }
}
