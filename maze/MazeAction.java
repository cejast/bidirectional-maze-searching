package maze;

import search.Action;

public abstract class MazeAction implements Action{
    
    public int getCost() {
        return 1;
    }
    
    public abstract int updateX(int x);
    public abstract int updateY(int y);
    public abstract String toString();
    
}
