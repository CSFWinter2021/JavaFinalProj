package com.sudoku.models;



public class MainBoard extends Board {
	
	// reference point[][] is already inherited form super class.
	private Subboard subboard[][];
	private Line[] row, column;
	
	/* The main Sudoku board will contain:
	 *     A matrix 9x9 of point.
	 *     A matrix 3x3 of sub board, each sub board is a matrix 3x3 of point. 
	 *     also 9 rows and 9 columns,
	 *     each row and each column are arrays of points. */
	
	public MainBoard() {
		point = new Point[9][9];
		for(i = 0; i < 9; i++) {
			
			for(j = 0; j < 9; j++) {
				
				point[i][j] = new Point(0);
			}
		}
		
		subboard = new Subboard[3][3];
		for(i = 0; i < 3; i++) {
			
			for(j = 0; j < 3; j++) {
				
				subboard[i][j] = new Subboard();
			}
		}
		
		row = new Line[9];
		column = new Line[9];
		for(i = 0; i < 9; i++) {
			
			row[i] = new Line();
			column[i] = new Line();
		}
		connectAllThing();
	}
	
	private void connectAllThing() {
		
		// To connect all of the above references, we start with set up 9 sub boards.
		for(i = 0; i < 3; i++) {
			
			for(j = 0; j < 3; j++) {
				
				subboard[i][j].setSubboard(point, 3*i, 3*j);
				/* As the explanation in the Subboard class, we can calculate:
				 *
				 * point[0][0] of subboard[0][0] is point[0][0] of the main board,
				 * point[0][0] of subboard[1][1] is point[3][3] of the main board,
				 * point[0][0] of subboard[2][0] is point[6][0] of the main board,
				 * ..................
				 * so we can figured out that:
				 * point[0][0] of subboard[i][j] is point[3i][3j] of the main board */
			}
		}
		
		// Next is set the 9 rows and 9 columns:
		for(i = 0; i < 9; i++) {
			
			row[i].setRow(point, i);
			column[i].setColumn(point, i);
		}
		
		/* And finally is set all the points' location
		 * each point must have 1 sub board, 1 row, and 1 column contain it. */
		for(i = 0; i < 9; i++) {
			
			for(j = 0; j < 9; j++) {
				
				/* For example:
				 * point[4][3] must be locate in row[4] and column[3]. */
				point[i][j].setRow(row[i]);
				point[i][j].setColumn(column[j]);
				
				point[i][j].setRowLocation(i);
				point[i][j].setColumnLocation(j);
				
				point[i][j].setSubboard(subboard[i/3][j/3]);
				
				/* To find out which sub board is point[i][j] in,
				 * 
				 * we have: Subboard[0][0] contain: point[0][0], point[0][1], ...., point[2][2],
				 * 	    Subboard[1][1] contain: point[3][3], point[3][4], ...., point[5][5],
				 *          ..................
				 * after some expand of those we can figured out the formular to find
				 * the index of the sub board where a point[i][j] is locate in is i/3, j/3. */
			}
		}
	}
	
	public void setBoard(int board[][]) {
		
		for(i = 0; i < 9; i++) {
			
			for(j = 0; j < 9; j++) {
				
				if(board[i][j] != 0) {
					
					point[i][j].setValue(board[i][j]);
					point[i][j].fixedPoint();
				}
			}
		}
	}
	
	public boolean valid() {
		
		/* The whole main Sudoku board is valid only valid if:
		 *     All 9 sub boards are valid;
		 *     All 9 row is valid;
		 *     And all 9 column is valid.    */
		for(i = 0; i < 3; i++) {
			
			for(j = 0; j < 3; j++) {
				
				if(!subboard[i][j].valid()) return false;
			}
		}
		
		for(i = 0; i < 9; i++) {
			
			if(!row[i].valid() || !column[i].valid()) return false;
		}
		return true;
	}
	
	public String toString() {
		String s = "";
		for(i = 0; i < 9; i++) {
			
			if(i%3 == 0) s += "\n";
			s += row[i] + "\n";
		}
		return s;
	}
}

