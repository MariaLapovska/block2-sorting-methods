package com.epam.sorting.lab;

import java.util.Arrays;

public class View {
	
	public static final String BEFORE_ARR = "Array before sorting:";
	public static final String AFTER_ARR = "Array after sorting:";
	public static final String WRONG_INPUT = "Wrong input format! Try again: ";
	public static final String CHOICE = "Choose the sorting method:";
	public static final String[] MENU = { "1 - Shaker sort",
										  "2 - Selection sort",
										  "3 - Shell sort",
										  "4 - Insertion sort",
										  "5 - Counting sort",
										  "6 - Quicksort",
										  "7 - Merge sort" };
	
	public void printMessage(String message) {
		System.out.println(message);
	}
	
	public void printMessageList(String[] messageList) {
		for (String message : messageList) {
			printMessage(message);
		}
	}
	
	public void printIntArray(int arr[]) {
		System.out.println(Arrays.toString(arr));
	}
}
