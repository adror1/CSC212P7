package edu.smith.cs.csc212.p7;

public class GrowableMergeSort {
	/**
	 * Same as MergeSort methods but w/ GrowableList
	 * @param left
	 * @param right
	 * @return sorted list
	 */
	public static GrowableList<Integer> mergeTwo(GrowableList<Integer> left, GrowableList<Integer> right) {
		GrowableList<Integer> sorted = new GrowableList<Integer>();
		int i = 0;
		int j = 0;
		while (i < left.size() && j < right.size()) {
			if (left.getIndex(i) < right.getIndex(i)) {
				sorted.addBack(left.getIndex(i));
				i++;
			} else {
				sorted.addBack(right.getIndex(j));
				j++;
			}
		}
		if (!left.isEmpty()) {
			for (; i<left.size(); i++) {
				sorted.addBack(left.getIndex(i));
			}
		}
		if (!right.isEmpty()) {
			for(; j < right.size(); j++){
				sorted.addBack(right.getIndex(j));
			}
		}
		System.out.println(sorted);
		return sorted;
	}


	public static GrowableList<Integer> sortRecursive(GrowableList <Integer> unsorted){
		if(unsorted.isEmpty()) {
			return unsorted;
		} if(unsorted.size() == 1) {
			return unsorted;
		}
		GrowableList <Integer> left = new GrowableList<Integer>();
		GrowableList <Integer> right = new GrowableList<Integer>();
		for(int i = 0; i < unsorted.size(); i++) {
			if(i % 2 == 0) {
				left.addBack(unsorted.getIndex(i));
			} else {
				right.addBack(unsorted.getIndex(i));
			}
		}

		return mergeTwo(sortRecursive(left), sortRecursive(right));

	}
	
//https://stackoverflow.com/questions/2895342/java-how-can-i-split-an-arraylist-in-multiple-small-arraylists
	public static GrowableList<Integer> sortIterative(GrowableList <Integer> unsorted){
		GrowableList<GrowableList<Integer>> listOfList = new GrowableList <GrowableList<Integer>>();
		
		/** the only thing that is different from all the other merge sort methods is right here.
		 * Since there is no sublist, for each element in unsorted:
		 * add that element to a temp list, add the temp list to the list of lists, and then
		 * remove that element from temp so that it is empty again
		 */
		
		for(int i = 0; i < unsorted.size(); i++) {
			GrowableList<Integer> temp = new GrowableList<Integer>();
			temp.addBack(unsorted.getIndex(i));
			listOfList.addBack(temp);
			temp.removeBack();
		}
		
		while(listOfList.size() > 1) {
			GrowableList<Integer> subList = new GrowableList<Integer>();
			subList = mergeTwo(listOfList.getIndex(0), listOfList.getIndex(1));
			listOfList.addBack(subList);
			listOfList.removeFront();
			listOfList.removeFront();
		}
		
		System.out.println(listOfList);
		return listOfList.getFront();	
	}

}
