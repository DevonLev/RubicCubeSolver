/*
 * AStarSolver
 * This Class Represnt a A* Alogrithem to Solve The Cube
 * This Class Has A PriorityQueue Of States, Priority Given To The State Where Cost(How many moves it takes to get to the state) + Huristic(The Sum Manhatan Distance Of The Cube) is lowest
 * in case of a tie compare alphabeticly
 * The Class Has a Set Of States Represnting The States We Visited
 * The Class Has a Counter Represting The Number Of Visited Nodes
 */
import java.util.*;
public class AStarSolver {
    private PriorityQueue<State> openSet;
    private Set<State> closedSet;
    public int count;
   
 

    public AStarSolver() {
        this.openSet =new PriorityQueue<>((a, b) -> {
            int primaryComparison = Integer.compare(a.calculateManhattanDistance() + a.movesTohere.size(), b.calculateManhattanDistance() + b.movesTohere.size());
            if (primaryComparison != 0) {
                return primaryComparison;
            }
            return a.additionalPriority().compareTo(b.additionalPriority());// in case of a tie 
        });
        this.closedSet = new HashSet<>();
    }

    public void solve(State initialState) {
        openSet.add(initialState);
        while (!openSet.isEmpty()) {
            State currentState = openSet.poll(); //remove and cheak highest priority
            count++;
            if (currentState.isGoal()) {
                System.out.println("Goal State Reached");
                System.out.println("This Is How We Got Here " + currentState.movesTohere);
                System.out.println("And This Is How Many States We Visited " +count);
                return;
            }
            
            closedSet.add(currentState); // add state to visited states
            List<State> successors = currentState.generateSuccessorStates(currentState); //make moves
            for (State successor : successors) {
                if (!closedSet.contains(successor) && !openSet.contains(successor)) { //if not seen beofre 
                    openSet.add(successor);
                }
            }
        }
    }
}
