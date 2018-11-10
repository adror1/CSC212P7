package edu.smith.cs.csc212.p7;

import java.util.ArrayList;
import java.util.List;

public class SimpleMergeSort {
	/**
	 *  goes through list and compares the values at the front of the list, adds the lowest one 
	 *  to the back of the list until both lists are combined. If there are remaining values, 
	 *  append them to the end. 
	 * @param left (one sorted list)
	 * @param right (one sorted list)
	 * @return a sorted list with all values
	 */
	public static List<Integer> mergeTwo(List<Integer> left, List<Integer> right) {
		List<Integer> sorted = new ArrayList<Integer>();
		int i = 0;
		int j = 0;
		while (i < left.size() && j < right.size()) {
			if (left.get(i) < right.get(j)) {
				sorted.add(left.get(i));
				i++;
			} else {
				sorted.add(right.get(j));
				j++;
			}
		}
		if (!left.isEmpty()) {
			for (; i<left.size(); i++) {
				sorted.add(left.get(i));
			}
		}
		if (!right.isEmpty()) {
			for(; j < right.size(); j++){
				sorted.add(right.get(j));
			}
		}
		return sorted;
	}

	/**
	 * Recursive solution...base case(s) are an empty list or list of size one. 
	 * Then, a list is divided based on whether or not the index is divided by 2
	 * Takes full list and then divides them into small pieces and compares those
	 * @param unsorted
	 * @return 
	 */
	public static List<Integer> sortRecursive(List <Integer> unsorted){
		if(unsorted.isEmpty()) {
			return unsorted;
		} if(unsorted.size() == 1) {
			return unsorted;
		}
		List <Integer> left = new ArrayList<Integer>();
		List <Integer> right = new ArrayList<Integer>();
		for(int i = 0; i < unsorted.size(); i++) {
			if(i % 2 == 0) {
				left.add(unsorted.get(i));
			} else {
				right.add(unsorted.get(i));
			}
		}

		
		return mergeTwo(sortRecursive(left), sortRecursive(right));

	}
	
/**
 * Source for help: https://stackoverflow.com/questions/2895342/java-how-can-i-split-an-arraylist-in-multiple-small-arraylists
 * Takes a full list and breaks it into smaller pieces and then slowly pieces it back together
 * @param unsorted
 * @return 
 */
	public static List<Integer> sortIterative(List <Integer> unsorted){
		List<List<Integer>> listOfList = new ArrayList <List<Integer>>();
		
		//breaks the list into small lists of one number
		for(int i = 0; i < unsorted.size(); i++) {
			listOfList.add(unsorted.subList(i, i+1));
		}
		
		/* while the listoflists is greater than 1, add the first two elements and put them
		 * in order, and then adds that to the back listoflists. then remove those elements from the list
		 * do this until the list is one sublist with all the sorted numbers
		 */

		while(listOfList.size() > 1) {
			List<Integer> subList = new ArrayList<Integer>();
			subList = mergeTwo(listOfList.get(0), listOfList.get(1));
			listOfList.add(subList);
			listOfList.remove(0);
			listOfList.remove(0);
		}
		
		System.out.println(listOfList);
		return listOfList.get(0);	
	}
}

