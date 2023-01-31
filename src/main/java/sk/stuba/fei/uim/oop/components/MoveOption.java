package sk.stuba.fei.uim.oop.components;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Comparator;

public class MoveOption implements Comparator {
    @Getter
    private int countPoints;
    @Getter
    @Setter
    private ArrayList<Square> listSquares;
    protected MoveOption(Square top,ArrayList<Square> list,int count){
        this.listSquares=new ArrayList<>();
        this.listSquares.add(top);
        this.listSquares.addAll(list);
        this.countPoints=count;
    }
    protected void addCountPoints(int temp){
        countPoints+=temp;
    }
    @Override
    public int compare(Object o1, Object o2) {
        if (((MoveOption)o1).countPoints >((MoveOption)o2).countPoints){
            return 1;
        }
        else if (((MoveOption)o1).countPoints <((MoveOption)o2).countPoints){
            return -1;
        }
        return 0;

    }
}
