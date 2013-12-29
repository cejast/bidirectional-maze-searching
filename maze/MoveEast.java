package maze;

import search.Action;

public class MoveEast extends MazeAction{

    public int updateX(int x) {
        return x+1;
    }

    public int updateY(int y) {
        return y;
    }        

    public String toString(){
    	return "01";
    }
}
