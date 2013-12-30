package search;

import java.util.*;
import maze.Maze;
import maze.MazeGenerator;
import maze.MazeState;

public class BidirectionalSearch extends MazeSearchBidirectional {

    public BidirectionalSearch(Maze maze) {
        super(maze);
        frontierForward = new PriorityQueue();
        frontierBackward = new PriorityQueue();
        forwardClosed = new HashSet();
        backwardClosed = new HashSet();
        BidirectionalNodeForward initialNodeForward = new BidirectionalNodeForward(new MazeState(maze, maze.getStartX(), maze.getStartY()), null, null);
        BidirectionalNodeBackward initialNodeBackward = new BidirectionalNodeBackward(new MazeState(maze, maze.getGoalX(), maze.getGoalY()), null, null);
        frontierForward.add(initialNodeForward);
        frontierBackward.add(initialNodeBackward);
    }

    public Node findPathToGoal() {
        //count node expansions
	    int count = 0;

        while (!frontierForward.isEmpty() || !frontierBackward.isEmpty()) {
	    count++;

            //expand smallest frontier
            if (frontierForward.size() < frontierBackward.size()){
                //expand forward frontier
                Node n = ((PriorityQueue<Node>) frontierForward).poll();
                Node found = expandFrontier(n, true, forwardClosed);
                if(found != null){
                    System.out.println("Nodes expanded: " + count);
                    return found;
                }
            }
            else{
                //expand backward frontier
                Node n = ((PriorityQueue<Node>) frontierBackward).poll();
                Node found = expandFrontier(n, false, backwardClosed);
                if(found != null){
                    System.out.println("Nodes expanded: " + count);
                    return found;
                }
            }
        }

        //no solution found
        System.out.println(frontierForward.isEmpty());
        System.out.println(frontierBackward.isEmpty());
        System.out.println("No solution found.");
        return null;
    }

    //expandFrontier(Node expanded, forward or back frontier, frontiers closed set)
    public Node expandFrontier(Node n, boolean f, Set<State> frontier){
        Object[] array;

        if(f){
            array = ((PriorityQueue<Node>) frontierBackward).toArray();
        }
        else{
            array = ((PriorityQueue<Node>) frontierForward).toArray();
        }

        for(int i = 0; i < array.length; i++) {
            Node object = (Node)array[i];
            if(object.getState().hashCode() == n.getState().hashCode()){
                highlightPath(n);
                highlightPath(object);
                return n;
            }
        }

        if (!frontier.contains(n.getState())) {
            addToClosed(n.getState(), f);
            List<Action> actions = n.getState().getLegalActions();
            for (Action action : actions) {
                State child = n.getState().doAction(action);

                if (!frontier.contains(child)){
                    addToFrontier(new BidirectionalNodeBackward(child, n, action), f);
                }
            }
        }

        return null;

    }
    
     public static void main(String[] args) {
        BidirectionalSearch as = new BidirectionalSearch(MazeGenerator.getMaze(Integer.parseInt(args[0]),Integer.parseInt(args[1])));
        as.findPathToGoal();
	    System.out.println("Seach Complete");
    }
}
