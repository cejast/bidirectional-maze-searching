package search;

import java.util.*;

public class BidirectionalNodeBackward extends Node implements Comparable<BidirectionalNodeBackward>{

    public BidirectionalNodeBackward(State st, Node previousNode, Action lastAction) {        
        super(st,previousNode,lastAction);
    }
    
    public int compareTo(BidirectionalNodeBackward n){
    	//compare existing node to other nodes in queue (goal-to-start)
	int score = st.getEstimatedDistanceToStart();
        int scoreN = n.st.getEstimatedDistanceToStart();
        return score - scoreN;
    }
    
}
