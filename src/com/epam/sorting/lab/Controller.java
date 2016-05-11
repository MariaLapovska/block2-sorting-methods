package com.epam.sorting.lab;

import java.util.Scanner;

public class Controller {

	private static final int SIZE = 10;
	
	Model model;
	View view;
	
	/*Constructor with parameters*/
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	public void processUser() {
		Scanner sc = new Scanner(System.in);
		int choice;
		int arr[] = model.generateRandomNumbers(SIZE);
		
		view.printMessage(View.CHOICE);
		view.printMessageList(View.MENU);
		
		choice = inputIntValueWithScanner(sc);
		
		view.printMessage(View.BEFORE_ARR);
		view.printIntArray(arr);
		
		sort(choice, arr);
		
		view.printMessage(View.AFTER_ARR);
		view.printIntArray(arr);
	}
	
	// The Utility methods
	
	/**
	 * Reads integer value from 1 to 7 from input.
	 * 
	 * @param scanner Input scanner to read from.
	 * @return Integer value from 1 to 7 from input.
	 */
	public int inputIntValueWithScanner(Scanner scanner) {
    	String str;
    	
        while (true) {
        	str = scanner.next();
        	
        	if (!checkNumber(str)) {
        		view.printMessage(View.WRONG_INPUT);
        	} else { //string has correct format
        		break;
        	}
        }

        return Integer.valueOf(str);
    }
	
	/**
     * Checks if the given string contains integer value from 1 to 7.
     * 
     * @param string String to check.
     * @return boolean.
     */
    public boolean checkNumber(String string) {
    	if (string.matches("[1-7]")) { // "5"
    		return true;
    	} else {
    		return false;
    	}
    }
    
    /**
     * Sorts array depending on user's choice.
     * 
     * @param choice Number of sorting method.
     * @param arr Array to sort.
     */
    public void sort(int choice, int arr[]) {
    	switch (choice) {
		case 1:
			model.shakerSort(arr);
			break;
			
		case 2:
			model.selectionSort(arr);
			break;
			
		case 3:
			model.shellSort(arr);
			break;
			
		case 4:
			model.insertionSort(arr);
			break;
			
		case 5:
			model.countingSort(arr);
			break;
			
		case 6:
			model.quicksort(arr);
			break;
			
		case 7:
			model.topDownMerge(arr);
			break;
			
		default:
			break;
    	}
    }
}
