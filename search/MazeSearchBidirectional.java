package search;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import maze.Maze;
import maze.MazeGenerator;
import maze.MazeState;
import maze.StdDraw;

public abstract class MazeSearchBidirectional {

    Collection<Node> frontierForward;
    Collection<Node> frontierBackward;
    Set<State> forwardClosed;
    Set<State> backwardClosed;
    Maze maze;

    public MazeSearchBidirectional(Maze maze) {
        this.maze = maze;
        StdDraw.show(0);
        maze.draw();
    }

    public abstract Node findPathToGoal();

    //modified, check which frontier it's being added to
    protected void addToFrontier(Node n, boolean forward) {
        if(forward){
            frontierForward.add(n);
        }
        else{
            frontierBackward.add(n);
        }
        MazeState st = (MazeState) n.getState();
        maze.drawBlue(st.getX(), st.getY());
    }

    //modified, check which frontier it's being added to
    protected void addToClosed(State st0, boolean forward) {
        if(forward) forwardClosed.add(st0);
        else backwardClosed.add(st0);
        MazeState st = (MazeState) st0;
        maze.drawGray(st.getX(), st.getY());
    }

    protected void highlightPath(Node n) {
        List<State> path = n.getPath();
        for (State st : path) {
            MazeState ms = (MazeState) st;
            maze.highlight(ms.getX(), ms.getY());
        }
    }

    protected void restart() {
        maze.clearDots();
    }
}
