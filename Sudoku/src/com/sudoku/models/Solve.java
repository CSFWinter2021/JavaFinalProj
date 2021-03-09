package com.sudoku.models;

public class Solve {
	/*
	 * Solves any valid Sudoku puzzle, 
	 * start with DFS
	 * then implement more intelligent search*/
	
	// find empty board method : return 2 element array with positions
	public int[] empty(MainBoard board) {
		int[] position = null;
		
		for (int i = 0; i < board.point.length; i++) {
			for (int j = 0; j < board.point[0].length; j++) {
				
				// check if empty space found
				if (board.point[i][j].getValue() == 0) {
					position = new int[2];
					position[0] = i;
					position[1] = j;
					
					// return empty position
					return position;
				}
			}
		}
		
		// no empty space found
		return null;
	}
	
	// solve method
	public boolean solve(MainBoard board) {
		// use find empty method 
		int[] found = empty(board);
		int row;
		int col;
		int[] position = new int[2];
		
		// If an empty space is found
		if (found != null) {
			row = found[0];
			col = found[1];
			
			position[0] = row;
			position[1] = col;
		}
		
		// If solved already 
		else {
			return true;
		}
		
		
		// traverse board for a valid point
		for (int i = 1; i < 10; i++) {
			
			// check if there is a valid solution
			if (valid(board, i, position)) {
				// set point here.
				board.point[row][col].setValue(i);
			}
			
			System.out.println(board.point[row][col].getValue());
			
			// RECURSIVE CALL
			if (solve(board)) {
				return true;
			}
			
			// set point to 0
			board.point[row][col].setValue(0);
		}
		System.out.println("In the solve classes solve method");
		return false;
	}
	
	// valid method for constraint satisfaction
	public boolean valid(MainBoard board, int number, int[] position) {
		
		// Check rows
		for (int i = 0; i < board.point.length; i++) {
			if (board.point[position[0]][i].getValue() == number && position[1] != i) {
				return false;
			}
		}
		
		// Check columns
		for (int i = 0; i < board.point.length; i++) {
			if (board.point[i][position[1]].getValue() == number && position[1] != i) {
				return false;
			}
		}
		
		// use sub-board bounds
		int subBoardX = position[1]/3;
		int subBoardY = position[0]/3;
		
		// traverse sub-board
		for (int i = subBoardY*3; i < subBoardY+3; i++) {
			for (int j = subBoardX*3; j < subBoardX+3; j++) {
				if (board.point[i][j].getValue() == number && i != position[0] && j != position[1]) {
					return false;
				}
			}
		}
		
		return true;
	}
}
