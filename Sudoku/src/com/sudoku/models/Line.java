package com.sudoku.models;

public class Line {
	
	/* A Sudoku's main board will contain 18 lines, each line will have 9 elements. 
	 * For example: 
	 * The main board's matrix is:	2 0 1   8 5 1   7 0 0 , and we call this is mainBoardPoint[][]
					0 5 3   7 6 0   0 8 1
					4 0 7   4 0 2   3 0 0
				
					0 2 0   9 6 8   4 0 9
					9 8 0   0 2 4   1 7 3
					1 0 0   5 3 0   0 2 6
				
					0 0 5   9 0 0   1 0 0
					3 1 0   0 4 5   0 6 0
					0 0 2   0 3 1   0 0 8   
	 	
	 	The first row  2 0 1   8 5 1   7 0 0  is a line, all the other rows and column also. */
	
	private Point point[];
	
	public Line() {
		// All 18 lines of Sudoku's main board will have 9 elements.
		point = new Point[9];
	}
	
	public void setRow(Point[][] mainBoardPoint,int index11Row) {
		
		// This method will set the 9 elements of the lines as a row of the main board.
		for(i = 0; i < 9; i++) {
			
			point[i] = mainBoardPoint[index11Row][i];
			/* different from the Subboard class; in this case, 
			 * the variable index11Row will be the fixed row location of the row in the main board,
			 * so we use i for column location only
			 * 
			 * after this we will have:
			 * point[0][0], point[0][1], point[0][2], ........., point[0][8] as row[0] of the main board,
			 * point[1][0], point[1][1], point[1][2], ........., point[1][8] as row[1] of the main board,
			 * ................................*/
		}
	}
	
	public void setColumn(Point[][] mainBoardPoint, int index11Column) {
		
		// similar the the method set row above
		for(i = 0; i < 9; i++) {
			
			point[i] = mainBoardPoint[i][index11Column];
			/* after this we will have:
			 * point[0][0], point[1][0], point[2][0], ........., point[8][0] as column[0] of the main board,
			 * point[0][1], point[1][1], point[2][1], ........., point[8][1] as column[1] of the main board,
			 * ................................*/
		}
	}
	
	public boolean valid() {
		
		/* The line is valid only if all 9 elements of it contains 9 different number 
		 * from 1 to 9 with no repeat and no zero value. */
		int a[] = new int[9];	
		for(i = 0; i < 9; i++) a[i] = point[i].getValue();
		
		for(i = 0; i < 9; i++) {

			if(a[i] == 0) return false;
			
			for(j = 0; j < i; j++) {
				if(a[i] == a[j]) return false;		
			}
		}
		return true;
	}
	
	public String toString() {
		String s = "   ";
		for(i = 0; i < 9; i++) {
			if(i%3 == 0) s += "    ";
			s += point[i] + "  ";
		}
		return s;
	}
	
	private static int i, j;
}

