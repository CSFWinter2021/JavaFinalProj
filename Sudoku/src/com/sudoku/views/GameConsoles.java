package com.sudoku.views;
import javax.swing.*;

public class GameConsoles {
	
	private static JFrame frame = new JFrame();
	private static String Info, Taskbar;
	private static String[] choices = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
	
	static int StartConsole() {
		String Choice[] = {"START NEW GAME", "QUIT"};
		Taskbar = "Game Start:";
		Info = "Would you like to start a new game?";
		return JOptionPane.showOptionDialog(frame, Info, Taskbar, 0, 3, null, Choice, Choice[0]); 
	}
	
	static int MainConsole(MainBoard board) {
		String[] Choice = {"PUT", "Solve", "Cancel"};
		return JOptionPane.showOptionDialog(frame, board, "Game Play:", JOptionPane.YES_NO_CANCEL_OPTION, -1, null, Choice, Choice[0]); 
	}
	
	static Point choosePoint(MainBoard board) {
		
		Taskbar = "Choose a row location: [?][ ]";
		Info = "Choose a row location to enter new value:";
	    String rowChoice = (String)JOptionPane.showInputDialog(null, Info, Taskbar, 3, null, choices, choices[0]);
	    if(rowChoice == null) return null;
	    int i = Integer.parseInt(rowChoice) - 1;
	    
	    Taskbar = "Choose a column location: [" + (i + 1) + "][?]";
		Info = "Choose a column location to enter new value:";
	    String columnChoice = (String)JOptionPane.showInputDialog(null, Info, Taskbar, 3, null, choices, choices[0]);
	    if(columnChoice == null) return null;
	    int j = Integer.parseInt(columnChoice) - 1;
	    
	    return board.getPointAt(i, j);
	}
	
	static void setValue(Point X) {
		
		Taskbar = "Set value for the choosen location:";
		Info = "Choose a value for location [" + (X.getRowLocation() + 1) + "][" + (X.getColumnLocation() + 1) + "]";
		String Value = (String)JOptionPane.showInputDialog(null, Info, Taskbar, 3, null, choices, choices[0]);
	    int value = Integer.parseInt(Value);
	    X.setValue(value);
	}
	
	static void CompleteMessages() {
		JOptionPane.showMessageDialog(frame, "You have completed the game!", "Congratulations!", 1);
	}
	
	static void ErrorMessages() {
		JOptionPane.showMessageDialog(frame, "This point is fixed!", "Can't fix this point!", 0);
	}
}
