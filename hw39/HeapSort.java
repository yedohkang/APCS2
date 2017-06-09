// Yedoh Kang
// APCS2 pd1
// HW39 -- Heaping Piles of Sordidness
// 2017-05-11

public class HeapSort {

    private static int size;

    // heapify a subtree, where is the index of the root of the array
    public static void heapify (int[] arr, int i) {

	int largest = i;
	int l = 2*i + 1;
	int r = 2*i + 2;

	if ((r < size) && (arr[r] > arr[largest])) {
	    largest = r;
	}
	if ((l < size) && (arr[l] > arr[largest])) {
	    largest = l;
	}
	if (largest != i) {
	    // swap positions if the largest value is not i anymore
	    swap (arr, i, largest); // recursively heaptify the sub-tree
	    heapify(arr,largest); 
	}
	
    } // end heapify

    public static void sort (int[] arr) {

	size = arr.length - 1;
	
	// for the beginning of the half of the array, descending, heapify
	for (int i = size / 2; i >= 0; i--) {
	    heapify (arr, i);
	}

	// remove one element at a time from the heap
	for (int i = size; i >= 0; i--) {

	    // swap to move the current root to the end of the array
	    swap (arr, 0, i);

	    size = size - 1;
	    
	    // heapify on the rest
	    heapify (arr, 0);
	}
	
    } // end sort O(nlogn)

    public static void swap (int[] arr, int i, int j) {

	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
    } // end swap

    public static void main (String[] args) {

	int[] arr = new int[7];
	size = arr.length;
	arr[0] = 6;
	arr[1] = 2;
	arr[2] = 4;
	arr[3] = 0;
	arr[4] = 3;
	arr[5] = 1;
	arr[6] = 5;
	
	sort(arr);

	for (int i = 0; i < arr.length; i++) {
	    System.out.print(arr[i] + " ");
	}
	System.out.println();
    }

} // end of class
