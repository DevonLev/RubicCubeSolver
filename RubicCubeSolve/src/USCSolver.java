/*
 * USCSOlver
 * Reprsents a USC Solve To The Cube
 * As The Cost Of Any Move is 1 The Alogrithem Would Work Like BFS(First Make all 1 Moves, Then All 2 Moves etc) The Class Has A Regaulr Queue
 * The Class Has A Set Of States Reprsting States We Visited
 * The Class Has Count To Track How Many Nodes We Visited
 */
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class USCSolver {
	 Queue<State> queue;
    private Set<State> visitedStates;
    public int count;

    public USCSolver() {
        this.visitedStates = new HashSet<>();
        this.queue = new LinkedList<>();
    }

    public void solve(State initialState) {
        usc(initialState);
    }

    private void usc(State initialState) {
        queue.add(initialState);

        while (!queue.isEmpty()) {
            State currentState = queue.poll();
            visitedStates.add(currentState);
            count++;
            if (currentState.isGoal()) {
                System.out.println("Goal State reached");
                System.out.println("This Is How We Got Here" + currentState.movesTohere);
                System.out.println("And This Is How Many States We Visited " +count);
                return;
            }

            List<State> successors = currentState.generateSuccessorStates(currentState); //make moves
            for (State successor : successors) {
                if (!visitedStates.contains(successor)) { 
                    queue.add(successor);
                    visitedStates.add(successor); 
                }
            }
        }
    }
}

