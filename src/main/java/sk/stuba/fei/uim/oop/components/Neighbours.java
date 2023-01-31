package sk.stuba.fei.uim.oop.components;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.player.Player;

@Getter
@Setter
public class Neighbours {
    private Square neighboursNorth = null;
    private Square neighboursNorthWest = null;
    private Square neighboursWest = null;
    private Square neighboursSouthWest = null;
    private Square neighboursSouth = null;
    private Square neighboursSouthEast = null;
    private Square neighboursEast = null;
    private Square neighboursNorthEast = null;

    protected boolean isHaveEnemyNeighbours(Player player){
        if(this.neighboursNorth!=null && this.neighboursNorth.getOwnerPlayer()!=null){
            if (this.neighboursNorth.getOwnerPlayer()!=player){
                return true;
            }
        }
        if(this.neighboursNorthWest!=null && this.neighboursNorthWest.getOwnerPlayer()!=null) {
            if (this.neighboursNorthWest.getOwnerPlayer() != player) {
                return true;
            }
        }
        if(this.neighboursWest!=null && this.neighboursWest.getOwnerPlayer()!=null) {
            if (this.neighboursWest.getOwnerPlayer() != player) {
                return true;
            }
        }
        if(this.neighboursSouthWest!=null && this.neighboursSouthWest.getOwnerPlayer()!=null) {
            if (this.neighboursSouthWest.getOwnerPlayer() != player) {
                return true;
            }
        }
        if(this.neighboursSouth!=null && this.neighboursSouth.getOwnerPlayer()!=null) {
            if (this.neighboursSouth.getOwnerPlayer() != player) {
                return true;
            }
        }
        if(this.neighboursSouthEast!=null && this.neighboursSouthEast.getOwnerPlayer()!=null) {
            if (this.neighboursSouthEast.getOwnerPlayer() != player) {
                return true;
            }
        }
        if(this.neighboursEast!=null && this.neighboursEast.getOwnerPlayer()!=null) {
            if (this.neighboursEast.getOwnerPlayer() != player) {
                return true;
            }
        }
        if(this.neighboursNorthEast!=null && this.neighboursNorthEast.getOwnerPlayer()!=null) {
            if (this.neighboursNorthEast.getOwnerPlayer() != player) {
                return true;
            }
        }
        return false;
    }
}
