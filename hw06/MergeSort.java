// Yedoh Kang
// APCS2 pd1
// HW06 -- Step 1: Split, Step 2: ?, Step 3: Sorted!
// 2017-2-13

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm: 
  A new array of the sum of the lengths of the two arrays are made.
  Until the entire new array is filled up, comparisons are made with the next element in each array.
  There are counters, and the smaller value at the current counter of each array is added to the new array.
  After one array is traversed through, the rest of the other array is added to the new array.
  ======================================*/

public class MergeSort {

    /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b ) 
    {
	int[] retArr = new int[a.length + b.length];
	int counterA = 0;
	int counterB = 0;
	for (int i = 0; i < retArr.length; i++) {
	    if (counterA >= a.length) {
		retArr[i] = b[counterB];
		counterB++;
	    }
	    else if (counterB >= b.length) {
		retArr[i] = a[counterA];
		counterA++;
	    }
	    else if (a[counterA] <= b[counterB]) {
		retArr[i] = a[counterA];
		counterA++;
	    }
	    else {
		retArr[i] = b[counterB];
		counterB++;
	    }
	}
	return retArr;
    }//end merge()


    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr ) 
    {
	if (arr.length == 1){
	    return arr;
	}
	else {
	    int[] arr1 = new int[arr.length/2]; // creates new array, which is half
	    int[] arr2 = new int[arr.length - arr.length/2]; // creates another new array, which is the other half
	    for (int i = 0; i < arr1.length; i++) {
		arr1[i] = arr[i];
	    }
	    for (int i = 0; i < arr2.length; i++) {
		arr2[i] = arr[i+(arr.length/2)];
	    }
	    return merge(sort(arr1), sort(arr2)); // sort each, then merge both
	}
    }//end sort()



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) {
	
	int[] arr0 = {0};
	int[] arr1 = {1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,3,4};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {9,42,17,63,0,512,23};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};

	System.out.println("\nTesting mess-with-array method...");
	printArray( arr3 );
	mess(arr3);
	printArray( arr3 );

	System.out.println("\nMerging arr1 and arr0: ");
	printArray( merge(arr1,arr0) );
	System.out.println("\nMerging arr4 and arr6: ");
	printArray( merge(arr4,sort(arr6) ));

	System.out.println("\nSorting arr4-7...");
	printArray( sort( arr4 ) );
	printArray( sort( arr5 ) );
	printArray( sort( arr6 ) );
	printArray( sort( arr7 ) );
	
    }//end main()
}//end class MergeSort
