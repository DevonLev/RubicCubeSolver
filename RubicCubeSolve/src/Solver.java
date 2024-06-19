import java.util.Scanner;

public class Solver {

    public static void main(String[] args) {
       System.out.println("Welcome To The Rubic Cube Solver");
       System.out.print("Please Enter The Cubes Current State ");
       Scanner scanner = new Scanner(System.in);
       String input = scanner.nextLine();
       String inputString = new String();
       inputString = removeSpaces(input);
       Cube c = new Cube(inputString);
       State s = new State(c);
       System.out.print("For DFS Solver Enter DFS, For AStar Solver Enter ASTAR, For UCS Solver Enter UCS ");
       Scanner scanner1 = new Scanner(System.in);
       String userInput =scanner1.nextLine();
       
       switch (userInput) {
       case "DFS":
    	   System.out.println("I Hope You Have Alot Of Memory We Are Going To Cheak Alot Of States");
           DFSSolver dfs = new DFSSolver();
           dfs.solve(s);
           break;
       case "ASTAR":
    	   System.out.println("This Might Take Some Time We Have Alot Of Calcultions To Do");
           AStarSolver as = new AStarSolver();
           as.solve(s);
           break;
       case "UCS":
    	   System.out.println("I Hope You Have Alot Of Memory We Are Going To Cheak Alot Of States");
    	   USCSolver usc = new USCSolver();
    	   usc.solve(s);    
       }
       scanner.close();
       scanner1.close();
    
}
    
    public static String removeSpaces(String input) {

     	        return input.replaceAll("\\s", ""); //
     	    }


}



































































































