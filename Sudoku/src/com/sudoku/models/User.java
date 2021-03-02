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
    	//todo: analyze the arrays for the missing values.
    }
    
}
