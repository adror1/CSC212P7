package edu.smith.cs.csc212.p7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestSorting {
	/**
	 * One late day used
	 */
	/**
	 * This is useful for testing whether sort algorithms work!
	 * @param items - the list of integers.
	 * @return true if it is sorted, false if not.
	 */
	private static boolean checkSorted(List<Integer> items) {
		Assert.assertFalse(items.isEmpty());
		for (int i=0; i<items.size()-1; i++) {
			if (items.get(i) >= items.get(i+1)) {
				System.err.println("items out of order: "+items.get(i)+", "+items.get(i+1) + " at index="+i);
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Here's some data!
	 */
	private static int[] data = {9,8,7,6,5,4,3,2,1};
	private static int[] data1 = {1, 3, 5, 7, 9};
	private static int[] data2 = {2, 4, 6, 8};
	
	@Test
	public void testBubbleSort() {
		// See if the data can be reversed:
		ArrayList<Integer> sortMe = new ArrayList<>();
		for (int y : data) {
			sortMe.add(y);
		}
		BubbleSort.bubbleSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		Collections.shuffle(sortMe);
		BubbleSort.bubbleSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
	}
	/**
	 * Selection sort test
	 */
	@Test
	public void testSelectionSort() {
		// See if the data can be reversed:
		ArrayList<Integer> sortMe = new ArrayList<>();
		for (int y : data) {
			sortMe.add(y);
		}
		List<Integer> fixed = SelectionSort.selectionSort(new ArrayList<>(sortMe));
		Assert.assertTrue(checkSorted(fixed));
		
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		Collections.shuffle(sortMe);
		List<Integer> fixed2 = SelectionSort.selectionSort(sortMe);
		Assert.assertTrue(checkSorted(fixed2));
	}
	
	/**
	 * Insertion sort test
	 */
	@Test
	public void testInsertionSort() {
		// See if the data can be reversed:
		ArrayList<Integer> sortMe = new ArrayList<>();
		for (int y : data) {
			sortMe.add(y);
		}
		List<Integer> fixed = InsertionSort.insertionSort(new ArrayList<>(sortMe));
		Assert.assertTrue(checkSorted(fixed));
		
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		Collections.shuffle(sortMe);
		List<Integer> fixed2 = InsertionSort.insertionSort(sortMe);
		Assert.assertTrue(checkSorted(fixed2));
	}
	/**
	 * Merge sort, recursive test
	 */
	@Test
	public void testMergeRSort() {
		// See if the data can be reversed:
		ArrayList<Integer> sortMe = new ArrayList<>();
		for (int y : data) {
			sortMe.add(y);
		}
		List<Integer> fixed = SimpleMergeSort.sortRecursive(new ArrayList<>(sortMe));
		Assert.assertTrue(checkSorted(fixed));
		
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		Collections.shuffle(sortMe);
		List<Integer> fixed2 = SimpleMergeSort.sortRecursive(sortMe);
		Assert.assertTrue(checkSorted(fixed2));
	}

	@Test
	/**
	 * This test checks to see is the actual merging of the two lists works. 
	 *
	 */
	public void testSimpleMergeSort() {
		
		// See if the data can be reversed:
		ArrayList<Integer> sortMe = new ArrayList<>();
		ArrayList<Integer> sortMe2 = new ArrayList<>();
		for (int y : data1) {
			sortMe.add(y);
		}
		
		for(int z: data2) {
			sortMe2.add(z);
		}
		
		
		List<Integer> fixed = SimpleMergeSort.mergeTwo(new ArrayList<>(sortMe), new ArrayList<>(sortMe2));
		Assert.assertTrue(checkSorted(fixed));
		
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		Collections.shuffle(sortMe);
		Collections.shuffle(sortMe2);
		List<Integer> fixed2 = SimpleMergeSort.sortRecursive(sortMe);
		Assert.assertTrue(checkSorted(fixed2));
		List<Integer> fixed3 = SimpleMergeSort.sortRecursive(sortMe2);
		Assert.assertTrue(checkSorted(fixed3));
	}

	/**
	 * Merge sort iterative test
	 */
	@Test
	public void testMergeISort() {
		// See if the data can be reversed:
		ArrayList<Integer> sortMe = new ArrayList<>();
		for (int y : data) {
			sortMe.add(y);
		}
		List<Integer> fixed = SimpleMergeSort.sortIterative(new ArrayList<>(sortMe));
		Assert.assertTrue(checkSorted(fixed));
		
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		Collections.shuffle(sortMe);
		List<Integer> fixed2 = SimpleMergeSort.sortIterative(sortMe);
		Assert.assertTrue(checkSorted(fixed2));
	}
	/**
	 * This was an attempt at doing my tests for Growable List, but I didn't finish
	 */
//	@Test
//	public void testMergeRSortGrowable() {
//		// See if the data can be reversed:
//		GrowableList<Integer> sortMe = new GrowableList<>();
//		for (int y : data) {
//			sortMe.addBack(y);
//		}
//		GrowableList<Integer> fixed = GrowableMergeSort.sortRecursive(new GrowableList<Integer>());
//		Assert.assertTrue(checkSorted(fixed));
//		
//		// For good measure, let's shuffle it and sort it again to see if that works, too.
//		Collections.shuffle(sortMe);
//		List<Integer> fixed2 = SimpleMergeSort.sortRecursive(sortMe);
//		Assert.assertTrue(checkSorted(fixed2));
//	}
//
//	@Test
//	public void testSimpleMergeSortGrowable() {
//
//
//		
//		// See if the data can be reversed:
//		GrowableList<Integer> sortMe = new GrowableList<>();
//		GrowableList<Integer> sortMe2 = new GrowableList<>();
//		for (int y : data1) {
//			sortMe.addBack(y);
//		}
//		
//		for(int z: data2) {
//			sortMe2.addBack(z);
//		}
//		
//		
//		GrowableList<Integer> fixed = GrowableMergeSort.mergeTwo(new GrowableList<>(sortMe), new GrowableList<>(sortMe2));
//		Assert.assertTrue(checkSorted(fixed));
//		
//		// For good measure, let's shuffle it and sort it again to see if that works, too.
//		Collections.shuffle(sortMe);
//		Collections.shuffle(sortMe2);
//		List<Integer> fixed2 = SimpleMergeSort.sortRecursive(sortMe);
//		Assert.assertTrue(checkSorted(fixed2));
//		List<Integer> fixed3 = SimpleMergeSort.sortRecursive(sortMe2);
//		Assert.assertTrue(checkSorted(fixed3));
//	}
//
//	
//	@Test
//	public void testMergeISortGrowable() {
//		// See if the data can be reversed:
//		GrowableList<Integer> sortMe = new GrowableList<>();
//		for (int y : data) {
//			sortMe.addBack(y);
//		}
//		List<Integer> fixed = GrowableMergeSort.sortIterative(new GrowableList<>(sortMe));
//		Assert.assertTrue(checkSorted(fixed));
//		
//		// For good measure, let's shuffle it and sort it again to see if that works, too.
//		Collections.shuffle(sortMe);
//		GrowableList<Integer> fixed2 = GrowableMergeSort.sortIterative(sortMe);
//		Assert.assertTrue(checkSorted(fixed2));
//	}



}
