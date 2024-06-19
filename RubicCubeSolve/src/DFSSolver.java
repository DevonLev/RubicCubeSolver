/*
 * DFSSolver
 * This Class Represnts a DFS solve to the rubics cube
 * The Class Has 2 Function DFS and Better DFS Which Works Like A Limited Search
 * The Class Has a Flag Veribal Represnting if a Solution was found
 * The Class Has a Counter Veriabl Represnting the Ammount of Nodes We Visited
 * The Class A Set Of States Represnting The States We Visited In a Regular DFS
 * The Class A HashMap Of States Reprsenting States We Visited But By The Shortest Path
 * The Class Has A Max Depth Veriabl of 11 as Any 2x2 Cube Can Be solved With The correct 11 Moves
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DFSSolver {
   private  Set<State> visitedStates;
   int flag=0;
   public int count;
   public HashMap<Integer,State> better;
   public static int maxdepth=11;
   
   
    public DFSSolver() {
        this.visitedStates = new HashSet<>();
        this.better = new HashMap<>();
    }

    public void solve(State initialState) {
    	betterDfs(initialState, 0);
    }

    private void dfs(State currentState) {
    	count++;
    	if(flag==1) {
    		return; //solotiun was arleady found
    	}
        visitedStates.add(currentState); // add state to set
        if(currentState.isGoal()) {
        	flag=1; //singal that the solotiun was found
            System.out.println("Goal State Reached");
            System.out.println("This Is How We Got Here " + currentState.movesTohere);
            System.out.println("And This Is How Many States We Visited " +count);
            
            return; 
        }
        List<State> successors = currentState.generateSuccessorStates(currentState); //Make all possiable moves from the state
        for (State successor : successors) { //if we havent seen this state search from it
            if (!visitedStates.contains(successor)) {
                dfs(successor);
            }
           
        }
      
    }
    private void betterDfs(State currentState, int depth) {
    	count++;
    	if(flag==1 || depth>maxdepth) {
    		return; //solotiun was arleady found
    	}
        better.put(currentState.hashCode(), currentState); // add state to set
        if(currentState.isGoal()) {
        	flag=1; //singal that the solotiun was found
            System.out.println("Goal State Reached");
            System.out.println("This Is How We Got Here " + currentState.movesTohere);
            System.out.println("And This Is How Many States We Visited " +count);  
            return; 
        }
        List<State> successors = currentState.generateSuccessorStates(currentState); //Make all possiable moves from the state
        for (State successor : successors) { //if we havent seen this state search from it
            if (!better.containsKey(successor.hashCode())) {
            	betterDfs(successor, depth+1);
            }
            else { //if we have seen state
            	State temp = better.get(successor.hashCode()); 
            	if(temp.movesTohere.size()>successor.movesTohere.size()) { //comapre ammount of moves to reach state
            	better.put(successor.hashCode(), successor); //if state could have been reached with fewer moves replace state in the map and continue recurssion from there
            	betterDfs(successor, depth+1);
            	}
            }
           
        }
      
    }
}


