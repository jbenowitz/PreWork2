
public class TestM {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//Make a new maze
		Maze m1 = new Maze ( 9 , 9 );
		Maze m2 = new Maze ( 2 , 3 );
		Maze m3 = new Maze ( 3 , 3 );
		Maze m4 = new Maze ( 4, 2 );
		
		m1.load("111111111100010001111010101100010101101110101100000101111011101100000101111111111");
		
		m1.display();
		
		System.out.println(m1.solve(1, 1, 3 ,1));
		System.out.println(m1.trace(1, 1, 3 ,1));
	}

}
