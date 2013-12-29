package search;

import java.util.*;
        
public interface State {
    
    public List<Action> getLegalActions();
    public boolean isGoal();
    public void printState();
    public boolean isLegal(Action action);
    public State doAction(Action action);
    public int getEstimatedDistanceToGoal();
    public int getEstimatedDistanceToStart();
    public boolean equals(Object obj);
}
