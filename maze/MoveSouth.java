package maze;

import search.Action;

public class MoveSouth extends MazeAction{

    public int updateX(int x) {
        return x;
    }

    public int updateY(int y) {
        return y-1;
    }        

    public String toString(){
    	return "11";
    }
}
