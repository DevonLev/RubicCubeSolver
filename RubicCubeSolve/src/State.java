/*State
 * This Class Represnts a State Of The Cube
 * Each State Has A Cube Object Represnting The Current Cube Situation
 * Each State Has An ArrayList Of Strings, Represnting The Moves From The Original State To The Current State
 * Each State Has An Array Of Strings, Represnting Possiable Moves
 * Each State Has An Array Of chars, Represnting The Possiable Colors On The Cube
 * 
 */
import java.util.*;
public class State {
	public Cube cube;
	public ArrayList<String> movesTohere;
	public static String[] moves = {"F", "R", "U", "B", "L", "D", "F'", "R'", "U'", "B'", "L'", "D'"};
	public static char[] colors = {'W','B','G', 'R','Y','B'};
	
	
	public State(Cube cube) {
	this.cube=cube;
	this.movesTohere = new ArrayList<String>(); 
	}
	
	public Boolean isGoal() {
		//Goal state is reached if all sides(rows of matrix) of the cube are made up the same letter
		char[][] toCheak = this.cube.arr;
		 for (int i = 0; i < 6; i++) {
	            char firstChar = toCheak[i][0];
	            for (int j = 0; j < 4; j++) {
	                if (toCheak[i][j] != firstChar) {
	                    return false; 
	                }
	            }
	        }
	        return true; 
	    }
	
	public int calculateManhattanDistance() {
		//Manhtan distance is the sum of each colour distance from all 4 apperances of that color, then sum all the colors
		//A goal State would have manhtan distance of 18, so divide by 20 so goal states would be 0, most other states would return 1 or 2 so huristic is addmisable
		int distance =0;
		int z=0,t=0;
		for(int x=0; x<6; x++) {
		int flag=0;
		char color=colors[x];
		for(int i=0; i<6; i++) {
			for(int j=0; j<4; j++) {
				 if (cube.arr[i][j] == color) {
					 if(flag==0) {
						 flag=1;
						 z=i;
						 t=j;
					 }
					 else {
						 distance += Math.abs(i-z)+Math.abs(j-t);
						 z=i;
						 t=j;
					 }
		               
		            }
				
			}
		}
	}
		return ((distance/20));
}
	public String additionalPriority() {
		//Additonal Priority for cases of ties, compare alphabeticly
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < 6; i++) {
		    for (int j = 0; j < 4; j++) {
		        stringBuilder.append(cube.arr[i][j]);
		    }
		}
		String result = stringBuilder.toString();
		return result;
	}
	
	public List<State> generateSuccessorStates(State s) {
		//Sucsseor function, for the given state create a list of the 12 possiable states to advance to from the current by makeing each possiable move once
	        List<State> successors = new ArrayList<>();
	        // Generate successor states based on possible moves
	        for (String move : moves) {
	            Cube newCube = new Cube(s.cube.arr);
	            newCube.move(move);
	            State newState = new State(newCube);
	            newState.movesTohere.addAll(s.movesTohere);
	            newState.movesTohere.add(move);
	            successors.add(newState);
	        }
	        return successors;
	    }

	@Override
	public int hashCode() {
		return this.cube.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		State other = (State) obj;
		return Objects.equals(cube, other.cube);
	}
	
	  
	  


	
		
	
	}



