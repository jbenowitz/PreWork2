
/*
 * Note, maze is represented as 1's and 0's. 
 *  1's represents blocks and 0's throughways. 
 *  
 */

public class Maze {
	/*
	 * Class Variables
	 * Size of maze
	 */
	int n, m;
	
	//Maze string
	String sMaze;
	
	//Maze Array
	String[][] aMaze;
	
	//Constructor
	public Maze (int n, int m){
		this.m = m;
		this.n = n;
		this.aMaze = new String[n][m];
	}
	
	//Loads maze into correct string
	public void load (String s){
		sMaze = s;
		
		//Make a 3d array of the maze
		for(int i = 0 ; i<m ; i++){
			for(int j = 0 ; j<n ; j++){
				aMaze[j][i] = sMaze.substring(j+n*i, j+n*i+1);
			}
		}
		
		
	}
	
	//Display message shows the maze
	public void display(){
		for(int i = 0 ; i<m ; i++){
			for(int j = 0 ; j<n ; j++){
				System.out.print(aMaze[j][i]);
			}
			System.out.print("\n");
		}
	}
	
	
	
	/*
	 * Basic algorithm: Mark the starting position, see if any surrounding
	 * 	coordinates contain a 0, if so, mark those positions.  Repeat until
	 * 	nothing is marked.  If ending coordinates is marked, then return true.
	 * 
	 * Not an optimal solution, slow.  
	 * 
	 * @param : beginning and ending x,y coordinates
	 * @returns: true if there is a path, false otherwise.
	 * 
	 */
	public boolean solve ( int begX, int begY, int endX, int endY ){
		//Create a new working array
		String[][] workM = aMaze;
		
		workM[begX][begY]="#";
		
		return solveR(begX, begY, endX, endY, workM);
	}
	
	/*
	 * solveR solves recursive steps
	 */
	public boolean solveR (int begX, int begY, int endX, int endY, String[][] workM){
		
		//for x+1,y
		if(begX == n);
		else if((begX + 1 == endX) && (begY == endY)){
			return true;
		}
		
		else if(workM[begX + 1][begY]=="0"){
			workM[begX + 1][begY]="#";
			if (solveR(begX + 1, begY, endX, endY, workM) == true){
				return true;
			}
		}
		
		//for x-1, y
		if(begX == 0);
		else if((begX - 1 == endX) && (begY == endY)){
			return true;
		}
		else if(workM[begX - 1][begY]=="0"){
			workM[begX - 1][begY]="#";
			if (solveR(begX - 1, begY, endX, endY, workM) == true){
				return true;
			}
		}
		
		//for x, y+1
		if(begY == m);
		else if((begX == endX) && (begY + 1 == endY)){
			return true;
		}
		
		else if(workM[begX][begY + 1]=="0"){
			workM[begX][begY + 1]="#";
			if (solveR(begX, begY + 1, endX, endY, workM) == true){
				return true;
			}
		}
		
		//for x, y-1
		if(begY==0);
		else if((begX == endX) && (begY - 1 == endY)){
			return true;
		}
		
		else if(workM[begX][begY - 1]=="0"){
			workM[begX][begY - 1]="#";
			if (solveR(begX, begY - 1, endX, endY, workM) == true){
				return true;
			}
		}
		
		return false;
			
	}

	
	
	
	
	
	
	
	
	
	
	
	public String trace ( int begX, int begY, int endX, int endY ){
		//Create a new working array
		String[][] workM = aMaze;
		String path = "(" + begX + "," + begY + ")";
		
		workM[endX][endY]="#";
		
		if(solve(begX, begY, endX, endY) == true){
			return  traceR(endX, endY, begX, begY, workM, path);
		}
		else{
			return null;
		}
		
	}
	
	
	
	/*
	 * solveR solves recursive steps
	 */
	public String traceR (int begX, int begY, int endX, int endY, String[][] workM, String path){
		
		
		
		
		if(workM[begX+1][begY]=="0"){
			workM[begX+1][begY]="#";
			if (solveR(begX+1, begY, endX, endY, workM) == true){
				path = path + "(" + (begX+1) + "," + begY + ")";
			}
		}
		
		
		if(workM[begX-1][begY]=="0"){
			workM[begX-1][begY]="#";
			if (solveR(begX-1, begY, endX, endY, workM) == true){
				path = path + "(" + (begX-1) + "," + begY + ")";
			}
		}
		
		//for x, y+1
		
		if(workM[begX][begY+1]=="0"){
			workM[begX][begY+1]="#";
			if (solveR(begX, begY+1, endX, endY, workM) == true){
				path = path + "(" + begX + "," + (begY+1) + ")";
			}
		}
		
		//for x, y-1
		
		if(workM[begX][begY-1]=="0"){
			workM[begX][begY-1]="#";
			if (solveR(begX, begY-1, endX, endY, workM) == true){
				path = path + "(" + begX + "," + (begY-1) + ")";
			}
		}
		
		return path;
			
	}
}
