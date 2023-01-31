package sk.stuba.fei.uim.oop.components;

import sk.stuba.fei.uim.oop.player.Player;

public class Move {

    public Move(){
    }
    public boolean moveOn(MoveRecords records, Square temp, Player player){
        if(temp.isPossibleMove()){
            records.getMoveMap().get(temp).getListSquares().forEach(e->e.setOwnerPlayer(player));
            return true;
        }
        return false;
    }
    public void moveOnComputer(MoveRecords records,Player player){
        if(!(records.getMoveMap().isEmpty())) {
            moveOn(records,records.getMaxCount().getListSquares().get(0),player);
        }
    }
}
