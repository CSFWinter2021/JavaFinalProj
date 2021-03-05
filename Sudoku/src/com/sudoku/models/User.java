package com.sudoku.models;
import java.util.Scanner;

public class User {
    
    String userName;
    int userScore;
    int movesLeft;	

    private setName() {
        
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter User Name: ");
        userName = keyboard.next();
        keyboard.close();
        
    }
    
    public String getName() {
        
        return userName;
        
    }
    
    private setScore() {
        
        userScore++;
        
    }
    
    public int getScore() {
    
        return userScore;
    
    }
    //to find moves remaining, take the row, column, and subboard values as arrays; combine them into one; and find which of 1-9 are missing.
    public movesRemaining(subboard[] arr, line[] arr2, row[] arr3) {
    	
	int[] temp = new int[(arr.length + arr2.length + arr3.length)];
	int i = 0;

	for (i = 0; i < arr.length; i++) {
		temp[i] = arr[i];
	}
	for (i = 0; i < arr2.length; i++) {
		temp[(i + arr.length)] = arr2[i];
	}
	for (i = 0; i < arr3.length; i++) {
		temp[(i + arr.length + arr2.length)] = arr3[i];
	}	
    	for (i = 0; i < temp.length; i++) {
		if (temp[i] == 1) {
			one = true;
		}
		else if (temp[i] == 2) {
			two = true;
		}
		else if (temp[i] == 3) {
			three = true;
		}
		else if (temp[i] == 4) {
			four = true;
		}
		else if (temp[i] == 5) {
			five = true;
		}
		else if (temp[i] == 6) {
			six = true;
		}
		else if (temp[i] == 7) {
			seven = true;
		}
		else if (temp[i] == 8) {
			eight = true;
		}
		else {
			nine = true;
		}
	}
    }
    //create an array of values for 1-9 and store whether they are found in the row/column/subboard
    public static void knownValues(int[] temp) {
    
        int i;
	int j;
	boolean[] exists = {false, false, false, false, false, false, false, false, false};

	for (i = 0; i < exists.length; i++) {
		for (j = 0; j < temp.length; j++) {
			if (temp[j] == i + 1) {
				exists[i] = true;
			}
		}
	}
    
    }
}
