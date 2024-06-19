/* Cube 
 * This Class Represnt a Cube via a 2D Array: Rows(0-5) {top,right,front,bottom,left,back}, Cols(0-3) {0,1 are top row of the cube face  2,3 is second row of cube face}
 * 
 */
import java.util.Arrays;

public class Cube {
	public char[][] arr;
	


	public Cube(String s) { 
		//for input place in to the 2d array
		this.arr = new char[6][4];
		int index = 0;
		for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 4; col++) {	
               arr[row][col] = s.charAt(index);
               index++;       
            }
        }	
	}
	public Cube(char[][] arr1) {
		//to create a new cube from a diffrent cube
		this.arr = new char[6][4];
        for (int i = 0; i < 6; i++) {
           for(int j=0; j<4; j++) {
        	   this.arr[i][j]=arr1[i][j];
           }
        }
	}
	
	public void move(String s) {
		//all possibale moves and how they change indexs
		char temp1,temp2,temp3,temp4;
		if(s.equals("F")) {
		temp1=arr[2][1];
		temp2=arr[2][3];
		arr[2][1]=arr[2][0];
		arr[2][3]=temp1;
		arr[2][0]=arr[2][2];
		arr[2][2]=temp2;
		temp1=arr[0][2];
		temp2=arr[0][3];
		arr[0][2]=arr[4][3];
		arr[0][3]=arr[4][1];
		temp3=arr[1][0];
		temp4=arr[1][2];
		arr[1][0]=temp1;
		arr[1][2]=temp2;
		temp1=arr[3][0];
		temp2=arr[3][1];
		arr[3][0]=temp4;
		arr[3][1]=temp3;
		arr[4][1]=temp1;
		arr[4][3]=temp2;
		}
		
		else if(s.equals("R")){		
		temp1=arr[1][1];
		temp2=arr[1][3];
		arr[1][1]=arr[1][0];
		arr[1][3]=temp1;
		arr[1][0]=arr[1][2];
		arr[1][2]=temp2;
		temp1=arr[0][1];
		temp2=arr[0][3];
		arr[0][1]=arr[2][1];
		arr[0][3]=arr[2][3];
		arr[2][1]=arr[3][1];
		arr[2][3]=arr[3][3];
		arr[3][1]=arr[5][2];
		arr[3][3]=arr[5][0];
		arr[5][2]=temp1;
		arr[5][0]=temp2;
		}
		
		else if(s.equals("U")) {
		temp1=arr[0][1];
		temp2=arr[0][3];
		arr[0][1]=arr[0][0];
		arr[0][3]=temp1;
		arr[0][0]=arr[0][2];
		arr[0][2]=temp2;
		temp1=arr[1][0];
		temp2=arr[1][1];
		arr[1][0]=arr[5][0];
		arr[1][1]=arr[5][1];
		temp3=arr[2][0];
		temp4=arr[2][1];
		arr[2][0]=temp1;
		arr[2][1]=temp2;
		temp1=arr[4][0];
		temp2=arr[4][1];
		arr[4][0]=temp3;
		arr[4][1]=temp4;
		arr[5][0]=temp1;
		arr[5][1]=temp2;
		}
		
		else if(s.equals("B")) {
		temp1=arr[5][1];
		temp2=arr[5][3];
		arr[5][1]=arr[5][0];
		arr[5][3]=temp1;
		arr[5][0]=arr[5][2];
		arr[5][2]=temp2;	
		temp1=arr[0][0];
		temp2=arr[0][1];
		arr[0][0]=arr[1][1];
		arr[0][1]=arr[1][3];
		arr[1][1]=arr[3][3];
		arr[1][3]=arr[3][2];
		arr[3][2]=arr[4][0];
		arr[3][3]=arr[4][2];
		arr[4][2]=temp1;
		arr[4][0]=temp2;
		}
		
		else if(s.equals("L")) {
		temp1=arr[4][1];
		temp2=arr[4][3];
		arr[4][1]=arr[4][0];
		arr[4][3]=temp1;
		arr[4][0]=arr[4][2];
		arr[4][2]=temp2;	
		temp1=arr[0][0];
		temp2=arr[0][2];
		arr[0][2]=arr[5][1];
		arr[0][0]=arr[5][3];
		temp3=arr[2][0];
		temp4=arr[2][2];
		arr[2][0]=temp1;
		arr[2][2]=temp2;
		temp1=arr[3][0];
		temp2=arr[3][2];
		arr[3][0]=temp3;
		arr[3][2]=temp4;
		arr[5][3]=temp1;
		arr[5][1]=temp2;
		}
		
		else if(s.equals("D")) {
		temp1=arr[3][1];
		temp2=arr[3][3];
		arr[3][1]=arr[3][0];
		arr[3][3]=temp1;
		arr[3][0]=arr[3][2];
		arr[3][2]=temp2;	
		temp1=arr[1][2];
		temp2=arr[1][3];
		arr[1][2]=arr[2][2];
		arr[1][3]=arr[2][3];
		arr[2][2]=arr[4][2];
		arr[2][3]=arr[4][3];
		arr[4][2]=arr[5][2];
		arr[4][3]=arr[5][3];
		arr[5][2]=temp1;
		arr[5][3]=temp2;
		}
		
		else if(s.equals("F'")) {
		temp1=arr[2][0];
		temp2=arr[2][2];
		arr[2][0]=arr[2][1];
		arr[2][1]=arr[2][3];
		arr[2][2]=temp1;
		arr[2][3]=temp2;
		temp1=arr[0][2];
		temp2=arr[0][3];
		arr[0][2]=arr[1][0];
		arr[0][3]=arr[1][2];
		arr[1][0]=arr[3][1];
		arr[1][2]=arr[3][0];
		arr[3][0]=arr[4][1];
		arr[3][1]=arr[4][3];
		arr[4][1]=temp2;//17 value of 3
		arr[4][3]=temp1;//19 value of 2
		}
		
		else if(s.equals("R'")) {
		temp1=arr[1][0];
		temp2=arr[1][2];
		arr[1][0]=arr[1][1];
		arr[1][1]=arr[1][3];
		arr[1][2]=temp1;
		arr[1][3]=temp2;
		 temp1=arr[0][1];
		 temp2=arr[0][3];
		 arr[0][3]=arr[5][0];
		 arr[0][1]=arr[5][2];
		 temp3=arr[2][1];
		 temp4=arr[2][3];
		 arr[2][1]=temp1;
		 arr[2][3]=temp2;
		 temp1=arr[3][1];
		 temp2=arr[3][3];
		 arr[3][1]=temp3;
		 arr[3][3]=temp4;
		 arr[5][2]=temp1;
		 arr[5][0]=temp2;
			
	}
		else if(s.equals("U'")) {
			temp1=arr[0][0];
			temp2=arr[0][2];
			arr[0][0]=arr[0][1];
			arr[0][1]=arr[0][3];
			arr[0][2]=temp1;
			arr[0][3]=temp2;
			temp1=arr[1][0];
			temp2=arr[1][1];
			arr[1][0]=arr[2][0];
			arr[1][1]=arr[2][1];
			arr[2][0]=arr[4][0];
			arr[2][1]=arr[4][1];
			arr[4][0]=arr[5][0];
			arr[4][1]=arr[5][1];
			arr[5][0]=temp1;
			arr[5][1]=temp2;
		}
		else if(s.equals("B'")) {
			temp1=arr[5][0];
			temp2=arr[5][2];
			arr[5][0]=arr[5][1];
			arr[5][1]=arr[5][3];
			arr[5][2]=temp1;
			arr[5][3]=temp2;
			temp1=arr[0][0];
			temp2=arr[0][1];
			arr[0][0]=arr[4][2];
			arr[0][1]=arr[4][0];
			temp3=arr[1][1];
			temp4=arr[1][3];
			arr[1][1]=temp1;
			arr[1][3]=temp2;
			temp1=arr[3][2];
			temp2=arr[3][3];
			arr[3][2]=temp4;
			arr[3][3]=temp3;
			arr[4][0]=temp1;
			arr[4][2]=temp2;
		}
		else if(s.equals("L'")) {
			temp1=arr[4][0];
			temp2=arr[4][2];
			arr[4][0]=arr[4][1];
			arr[4][1]=arr[4][3];
			arr[4][2]=temp1;
			arr[4][3]=temp2;
			temp1=arr[0][0];
			temp2=arr[0][2];
			arr[0][0]=arr[2][0];
			arr[0][2]=arr[2][2];
			arr[2][0]=arr[3][0];
			arr[2][2]=arr[3][2];
			arr[3][0]=arr[5][3];
			arr[3][2]=arr[5][1];
			arr[5][3]=temp1;
			arr[5][1]=temp2;
		}
		else if(s.equals("D'")) {
			temp1=arr[3][0];
			temp2=arr[3][2];
			arr[3][0]=arr[3][1];
			arr[3][1]=arr[3][3];
			arr[3][2]=temp1;
			arr[3][3]=temp2;
			temp1=arr[1][2];
			temp2=arr[1][3];
			arr[1][2]=arr[5][2];
			arr[1][3]=arr[5][3];
			temp3=arr[2][2];
			temp4=arr[2][3];
			arr[2][2]=temp1;
			arr[2][3]=temp2;
			temp1=arr[4][2];
			temp2=arr[4][3];
			arr[4][2]=temp3;
			arr[4][3]=temp4;
			arr[5][2]=temp1;
			arr[5][3]=temp2;
		}
		
	}
	@Override
	public int hashCode() {
		//cubes have same hashcode only if all indexs are equal
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < 6; i++) {
		    for (int j = 0; j < 4; j++) {
		        stringBuilder.append(arr[i][j]);
		    }
		}
		String result = stringBuilder.toString();
		return result.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		//cubes are equal only if all the indexs are equal
		Cube other = (Cube) obj;
		for (int i = 0; i < 6; i++) {
		    for (int j = 0; j < 4; j++) {
		      if(!(arr[i][j]==other.arr[i][j])){
		    	  return false;
		      }
		    }
		}
		return true;
		
	}
	
	


	
		
		
		
		
		
}

	
	
	
	



