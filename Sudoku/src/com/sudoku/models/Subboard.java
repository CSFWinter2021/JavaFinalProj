package com.sudoku.models;


public class Subboard extends Board {
	
	/* A sub board is the small board 3x3 contain 9 points of the main board
	 * 1 main board will contain 9 sub boards and arranged as a matrix 3x3
	 * 
	 * in other word we can say:
	 *     a main board is a matrix 9x9 points
	 *     and it will be divided as a matrix 3x3 of sub boards
	 *     with each sub board is a matrix 3x3 of points. */
	
	public Subboard() {
		
		point = new Point[3][3];
	}
	
	public void setSubboard(Point[][] mainBoardPoint,int index11Row, int index11Column) {
		
		/* This method will set 9 elements of the sub boards
		 * and they will point to the elements of the main board's matrix 9x9 
		 * 
		 * with index11Row is the row index of the sub board's element [0][0] which is locate in the main board's matrix
		 * and also similar to index11Column. */
		
		for(i = 0; i < 3; i++) 
		{
			for(j = 0; j < 3; j++) {
				point[i][j] = mainBoardPoint[i + index11Row][j + index11Column];
			}
		}
		
		/* For example: 
		 * The main board's matrix is:	2 0 1   8 5 1   7 0 0 , and we call this is mainBoardPoint[][]
						0 5 3   7 6 0   0 8 1
						4 0 7   4 0 2   3 0 0
				
						0 2 0   9 6 8   4 0 9
						9 8 0   0 2 4   1 7 3
						1 0 0   5 3 0   0 2 6
				
						0 0 5   9 0 0   1 0 0
						3 1 0   0 4 5   0 6 0
						0 0 2   0 3 1   0 0 8   
		 
		 	In this case subboard[0][0] is: 2 0 1  and subboard[0][1] is: 8 5 1  , ......
							0 5 3   		      7 6 0
							4 0 7 			      4 0 2					
		 	
		 	Consider subboard[1][2] is: 4 0 9
		 				    1 7 3
		 				    0 2 6 
		 	we have point[0][0] of this sub board is 4, and its location in the main board is mainBoardPoint[3][6]
		 	
		 	so we use index11Row = 3 and index11Column = 6 to set point[0][0] of this sub board.
		 	similar to the other 8 element,
		 	point[i][j] = mainBoardPoint[i + index11Row][j + index11Column] include the first element,
		 	so all element of the sub board will be set. */
	}
	
	public boolean valid() {
		
		/* The sub board is valid only if all 9 elements of it contains 9 different number 
		 * from 1 to 9 with no repeat and no zero value. */
		
		int a[] = new int[9];
		// Convert the matrix 3x3 of the sub board to an array 9 elements:  
		for(i = 0; i < 9; i++) a[i] = point[i/3][i%3].getValue();
		/* Let set a[0] = point[0][0], a[1] = point[0][1], a[2] = point[0][2],
		 * 			a[3] = point[1][0], a[4] = point[1][1], ............., a[8] = point[2][2].
		 * we can figured out the formula for a[i] is a[i] = point[i/3][i%3]. */
		
		// After we have the array contain all 9 elements of the sub board, do like what Line class do
		for(i = 0; i < 9; i++) {

			if(a[i] == 0) return false;
			
			for(j = 0; j < i; j++) {
				if(a[i] == a[j]) return false;
			}
		}
		return true;
	}
}

