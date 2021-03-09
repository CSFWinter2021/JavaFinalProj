package com.sudoku.models;
import java.util.Scanner;

public class User {
    
    String userName;
    int userScore;
    int movesLeft;	

    private void setName() {
        
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter User Name: ");
        userName = keyboard.next();
        keyboard.close();
        
    }
    
    public String getName() {
        
        return userName;
        
    }
    
    private void setScore() {
        
        userScore++;
        
    }
    
    public int getScore() {
    
        return userScore;
    
    }

    
    public static void movesRemaining(int[] arr, int[] arr2, int[] arr3, int[] arr4, int[] arr5) {
    	
        int[] temp = new int[(arr.length + arr2.length + arr3.length + arr4.length + arr5.length)];
        int i;
        int j;
        boolean[] exists = {false, false, false, false, false, false, false, false, false};
    
        //copy the subboard values to a temp array.
        //copy the first subboard values to a temp array.
        for (i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        
        //add the second subboard values to the temp array.
        for (i = 0; i < arr2.length; i++) {
            temp[i + arr.length] = arr2[i];
        }
        
        //add the final subboard values to the temp array.
        for (i = 0; i < arr3.length; i++) {
            temp[(i + arr.length + arr2.length)] = arr3[i];
        }
        
        //add the column values to the temp array.
        for (i = 0; i < arr4.length; i++) {
            temp[(i + arr.length + arr2.length + arr3.length)] = arr4[i];
        }
	
        //add the row values to the temp array.
        for (i = 0; i < arr5.length; i++) {
            temp[(i + arr.length + arr2.length + arr3.length + arr4.length)] = arr5[i];
        }
        
        //iterate through the temp array to find 1-9.
        for (i = 0; i < exists.length; i++) {
            for (j = 0; j < temp.length; j++) {
                if (temp[j] == i + 1) {
                    exists[i] = true;
                }
            }
        }
        
        //print the missing values
        for (i = 0; i < exists.length; i++) {
            if (exists[i] == false) {
                System.out.print((i + 1) + " ");
            }
        }
    }
}
