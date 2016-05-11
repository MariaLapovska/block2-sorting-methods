package com.epam.sorting.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.epam.sorting.lab.Model;

public class ModelTest {
	
	Model model = new Model();
	int unsorted[] = {1, 10, 50, 20, 33, 7, 85, 6, 98, 23};
	int sorted[] = {1, 6, 7, 10, 20, 23, 33, 50, 85, 98};
	
	@Test
	public void testShakerSort() {
		int arr[] = unsorted;
		model.shakerSort(arr);
		
		assertArrayEquals("shaker sort", sorted, arr);
	}

	@Test
	public void testSelectionSort() {
		int arr[] = unsorted;
		model.selectionSort(arr);
		
		assertArrayEquals("selection sort", sorted, arr);
	}

	@Test
	public void testShellSort() {
		int arr[] = unsorted;
		model.shellSort(arr);
		
		assertArrayEquals("shell sort", sorted, arr);
	}

	@Test
	public void testInsertionSort() {
		int arr[] = unsorted;
		model.insertionSort(arr);
		
		assertArrayEquals("insertion sort", sorted, arr);
	}

	@Test
	public void testCountingSort() {
		int arr[] = unsorted;
		model.countingSort(arr);
		
		assertArrayEquals("counting sort", sorted, arr);
	}

	@Test
	public void testQuicksort() {
		int arr[] = unsorted;
		model.quicksort(arr);
		
		assertArrayEquals("quicksort", sorted, arr);
	}

	@Test
	public void testTopDownMerge() {
		int arr[] = unsorted;
		model.topDownMerge(arr);
		
		assertArrayEquals("top down merge sort", sorted, arr);
	}
}
