package com.epam.sorting.lab;

import java.util.Random;

/**
 * Class with different sorting methods.
 * 
 * @author Asus
 *
 */
public class Model {
	
	/**
	 * Sorts an array using shaker sort.
	 * 
	 * @param arr Array to sort.
	 */
	public void shakerSort(int[] arr) {
        for (int k = arr.length - 1; k > 0; k--) {
            boolean swapped = false;
            
            for (int i = k; i > 0; i--) {
                if (arr[i] < arr[i - 1]) {
                    swap(arr, i, i - 1);
                    swapped = true;
                }
            }
            
            for (int i = 0; i < k; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    swapped = true;
                }
            }
            
            if (!swapped) {
            	break;
            }
        }
    }
 
	/**
	 * Sorts an array using selection sort.
	 * 
	 * @param arr Array to sort.
	 */
    public void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                	min = j;
                }
            }
            
            swap(arr, min, i);
        }
    }
    
    /**
     * Sorts an array using Shell sort.
     * 
     * @param arr Array to sort.
     */
    public void shellSort(int[] arr) {
        int h;
        
        for (h = 1; h <= arr.length / 3; h = 3 * h + 1);
 
        while (h > 0) {
            for (int i = 0; i < arr.length; i++) {
                int key = arr[i];
                int j = i;
                
                while ((j > h - 1) && (arr[j - h] >= key)) {
                	arr[j] = arr[j - h];
                    j -= h;
                }
                
                arr[j] = key;
            }
            
            h /= 3;
        }
    }
    
    /**
     * Sorts an array using insertion sort.
     * 
     * @param arr Array to sort.
     */
    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            
            while ((j >= 0) && (key < arr[j])) {
            	arr[j + 1] = arr[j];
                j--;
            }
            
            arr[j + 1] = key;
        }
    }
    
    /**
     * Sorts an array using counting sort.
     * 
     * @param arr Array to sort.
     */
    public void countingSort(int[] arr) {
        int max = max(arr);
        int[] occurrences = new int[max];
        
        for (int i : arr) {
            occurrences[i - 1]++;
        }
        
        for (int i = 1; i < max; i++) {
            occurrences[i] += occurrences[i - 1];
        }
        
        int[] result = arr.clone();
        
        for (int i = arr.length - 1; i >= 0; i--) {
        	arr[--occurrences[result[i] - 1]] = result[i];
        }
    }
    
    /**
     * Sorts an array using quick sort.
     * 
     * @param arr Array to sort.
     */
    public void quicksort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }
    
    /**
     * Sorts an array from lower to higher index using quick sort.
     * 
     * @param arr Array to sort.
     * @param low Lower index.
     * @param hi Higher index.
     */
    private void quicksort(int[] arr, int low, int hi) {
        int index = partition(arr, low, hi);
        
        if (low < index - 1) {
            quicksort(arr, low, index - 1);
        }
        if (index < hi) {
            quicksort(arr, index, hi);
        }
    }
 
    /**
     * Divides the array into two parts - from lower index to pivot
     * element and from pivot element to higher index. Puts all elements less
     * than pivot to the left part of array and ones that are bigger - 
     * to the right part. 
     * 
     * @param arr Array to divide and sort.
     * @param low Lower index.
     * @param hi Higher index.
     * @return Index of pivot element.
     */
    private int partition(int[] arr, int low, int hi) {
        int pivot = arr[(low + hi) / 2];
        int i = low;
        int j = hi;
        
        while (i <= j) {
            while (arr[i] < pivot) {
            	i++;
            }
            
            while (arr[j] > pivot) {
            	j--;
            }
            
            if (i <= j) {
                swap(arr, i, j);
                i++; 
                j--;
            }
        }
        
        return i;
    }
 
    /**
     * Sorts an array using top down merge sort.
     * 
     * @param arr Array to sort.
     */
    public void topDownMerge(int[] arr) {
        topDownMerge(arr, 0, arr.length-1);
    }
 
    /**
     * Sorts an array from lower to higher index using top down merge sort.
     * 
     * @param arr Array to sort.
     * @param low Lower index.
     * @param hi Higher index.
     */
    private void topDownMerge(int[] arr, int low, int hi) {
        if (low >= hi) {
        	return;
        }
        
        int mid = low + (hi - low) / 2;
        
        topDownMerge(arr, low, mid);
        topDownMerge(arr, mid + 1, hi);
        merge(arr, low, mid, hi);
    }
 
    /**
     * Merges array[low .. mid] with array[mid + 1 .. hi] using auxiliary array.
     * 
     * @param arr Array that contains parts to merge.
     * @param low Lower index.
     * @param mid Middle index.
     * @param hi Higher index.
     */
    private void merge(int[] arr, int low, int mid, int hi) {
        int i = low;
        int j = mid + 1;
        int[] temp = arr.clone();
        
        for (int k = low; k <= hi; k++) {
        	if (i > mid) {
        		arr[k] = temp[j++];
        	} else if (j > hi) {
        		arr[k] = temp[i++];
        	} else if (temp[j] < temp[i]) {
        		arr[k] = temp[j++];
        	} else { // temp[j] >= temp[i]
        		arr[k] = temp[i++];
        	}
        }
    }
 
    // Helper methods
 
    /**
     * Swaps two elements in array.
     * 
     * @param arr Array, where elements are stored.
     * @param i Index of the first element to swap.
     * @param j Index of the second element to swap.
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
 
    /**
     * Finds max element in array.
     * 
     * @param arr Array for search.
     * @return Max element in array.
     */
    private int max(int[] arr) {
        int max = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
            	max = arr[i];
            }
        }
        
        return max;
    }
    
    /**
	 * Generates an array of random integers with length n. 
	 * 
	 * @param n The length of the array to generate.
	 * @return Array of random integers with length n. 
	 */
	public int[] generateRandomNumbers(int n) {
	    int[] result = new int[n];
	    Random random = new Random();
		
	    for (int i = 0; i < result.length; i++) {
		    result[i] = random.nextInt(n * 10);
	    }
	
	    return result;
	}
}