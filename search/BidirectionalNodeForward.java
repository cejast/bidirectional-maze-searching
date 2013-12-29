package search;

import java.util.*;

public class BidirectionalNodeForward extends Node implements Comparable<BidirectionalNodeForward>{

    public BidirectionalNodeForward(State st, Node previousNode, Action lastAction) {        
        super(st,previousNode,lastAction);
    }
    
    public int compareTo(BidirectionalNodeForward n){
    	//compare existing node to other nodes in queue (start-to-goal)
	int score = st.getEstimatedDistanceToGoal();
        int scoreN = n.st.getEstimatedDistanceToGoal();
        return score - scoreN;
    }
    
}
