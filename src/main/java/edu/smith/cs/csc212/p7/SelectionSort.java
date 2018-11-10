package edu.smith.cs.csc212.p7;

import java.util.List;
import java.util.ArrayList;

public class SelectionSort {
	
	/**
	 * Goes through unsorted list, finds the minimum value, adds it to a new list
	 * until the new list is low -> high 
	 * @param input
	 * @return a sorted list
	 */
	public static List<Integer> selectionSort(List<Integer> input) {
		List<Integer> sorted = new ArrayList<Integer>();

	
		while (!input.isEmpty()) {
			int minimum = 0;
			for (int j = 0; j < input.size(); j++) {
					if (input.get(j) < input.get(minimum)) {
						minimum = j;
					}	
			}
			sorted.add(input.get(minimum));
			input.remove(minimum);
		}
		return sorted;
	}
}
