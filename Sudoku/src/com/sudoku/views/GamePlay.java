package com.sudoku.views;
import com.sudoku.models.*;

public class GamePlay {

	public static void main(String[] args) {
		
		// MainBoard object
		MainBoard board = new MainBoard();
		
		// Solve object
		Solve solver = new Solve();
		
		// Set board to default board
		board.setBoard(DefaultBoard.DefaultBoard01());
		
		// if user hits Cancel : EXIT
		if(GameConsoles.StartConsole() != 0) {
			System.exit(0);
		}
		
		// Set exit value to false
		boolean exit = false;
		
		// Main Puzzle Game Loop
		while(!exit) {
			
			// Get users input choice 
			int n = GameConsoles.MainConsole(board);
			
			// Users hits Cancel
			if (n == 2) {
				System.exit(n);
			}
			
			// Choose case per input
			switch(n) {
				
				// User point set
				case 0:
					
					// User's chosen point
					Point chosenPoint = GameConsoles.choosePoint(board);
					
					// Set point 
					if(chosenPoint != null) {
						
						// if there is already a value : ERROR
						if(chosenPoint.isFixed()) GameConsoles.ErrorMessages();
						
						// Otherwise set the point
						else GameConsoles.setValue(chosenPoint);
						
						// Exit if the board is valid
						if(board.valid())
						{
							GameConsoles.CompleteMessages();;
							exit = true;
						}
					}
					
					break;
				
				// User asks for the solution	
				case 1:
					// Solve
					System.out.println("calling solve");
					solver.solve(board);
					
					// Exit if the board is valid
					if(board.valid())
					{
						GameConsoles.CompleteMessages();;
						exit = true;
					}
					
					break;
				
				// Otherwise exit	
				default:
					exit = true; 
					break;
			}	
		}
	}
}
