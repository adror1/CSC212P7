package edu.smith.cs.csc212.p7;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort {
	/**
	 * Takes an item from a list, goes through the list until the value is in the correct
	 * place, then places it at its proper place in the list
	 * @param sortedList
	 * @param item
	 */
	public static void insertSorted(List<Integer> sortedList, int item){
		if(sortedList.isEmpty()) {
			sortedList.add(item);
		} 
		for(int i = 0; i < sortedList.size(); i++) {
			if(item < sortedList.get(i)) {
					sortedList.add(i, item);
					break;
			} 
		}
	}
	/**
	 * For each item in an unsorted list put the item in its right place in a sorted list
	 * @param input
	 * @return sorted list
	 */
	public static List<Integer> insertionSort(List<Integer> input) {
		List<Integer> sorted = new ArrayList<Integer>();
		for(int item : input) {
			insertSorted(sorted, item);
		}

		return sorted;
	}

}
