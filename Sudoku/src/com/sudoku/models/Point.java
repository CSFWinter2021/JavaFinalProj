package com.sudoku.models;


public class Point {
	
	// A point in a Sudoku's board will contain these kind of information.
	
	private int value; //The value inside it.
	
	private Subboard subboard; //The subboard (3x3) which is containing it.
	
	private Line row, column; // The row and the column of the main board which are containing it.
	
	private int rowLocation, columnLocation; //It's location inside the main board's matrix 9x9.
	
	private boolean fixedPoint; //And if it is the fixed point at the beginning or not.
	
	public Point(int x) {
		value = x;
		rowLocation = columnLocation = 0;
		subboard = null;
		row = column = null;
		fixedPoint = false;
	}
	
	/*Down below are just set and get methods. */
	
	public void setValue(int x) {
		value = x;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setSubboard(Subboard inSubboard) {
		subboard = inSubboard;
	}
	
	public void setRow(Line inRow) {
		row = inRow;
	}
	
	public void setColumn(Line inColumn) {
		column = inColumn;
	}
	
	public Subboard getSubboard() {
		return subboard;
	}
	
	public Line getRow() {
		return row;
	}
	
	public Line getColumn() {
		return column;
	}
	
	public void setRowLocation(int mainBoardRow) {
		rowLocation = mainBoardRow;
	}
	
	public void setColumnLocation(int mainBoardColumn) {
		columnLocation = mainBoardColumn;
	}
	
	public int getRowLocation() {
		return rowLocation;
	}
	
	public int getColumnLocation() {
		return columnLocation;
	}
	
	public void fixedPoint() {
		fixedPoint = true;
	}
	
	public boolean isFixed() {
		return fixedPoint;
	}
	
	public String toString() {
		if(value == 0) return "[  ]";
		else return "[" + value + ']';
	}
}

