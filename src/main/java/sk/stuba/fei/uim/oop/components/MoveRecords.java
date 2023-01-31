package sk.stuba.fei.uim.oop.components;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class MoveRecords {
    private Map<Square,MoveOption> moveMap;
    protected MoveRecords(){
        this.moveMap=new HashMap<>();
    }
    protected void clear(){
        moveMap.clear();
    }
    protected void addSquare(Square square,ArrayList<Square> squares,int count){
        if(this.moveMap.containsKey(square)){
            this.moveMap.get(square).getListSquares().addAll(squares);
            this.moveMap.get(square).addCountPoints(count);
        }
        else{
            this.moveMap.put(square,new MoveOption(square,squares,count));
        }
    }
    protected MoveOption getMaxCount(){
        return this.moveMap.values().stream().max(((o1, o2) -> o1.compare(o1, o2))).get();
    }
}
