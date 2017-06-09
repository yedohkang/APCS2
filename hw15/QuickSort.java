// Yedoh Kang
// APCS2 pd1
// HW15 -- So So Quick
// 2017-03-08

/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 * use partitioning to recursively sort an array.
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): uses partitioning to recursively sort an array. Move the pivotPos one position to the right
 *             after every recursive call. Recurse through qsort for both arrays on both sides of the pivotPos,
 *             exclusive of pivotPos.
 *
 * 2a. Worst pivot choice / array state and associated runtime: 
 * Worst pivot choice: Random index of the given array
 *	// not ordered, random partition --> didn't work
 *	int [] arr1 = {7,1,5,12,3};
 *	// small->big, random partition --> didn't work
 *	int [] arr2 = {1,3,5,7,12};
 *	// big->small, random partition --> 0.168 s
 *	int [] arr3 = {12,7,5,3,1}; 
 * Associated runtime: O(n^2)
 *
 * 2b. Best pivot choice / array state and associated runtime:
 * Best pivot choice: going from the farthest right to the left.
 *	// not ordered, right partition --> 0.164 s
 *	int [] arr1 = {7,1,5,12,3};
 *	// small->big, right partition --> 0.154 s
 *	int [] arr2 = {1,3,5,7,12};
 *	// big->small, right partition --> 0.149
 *	int [] arr3 = {12,7,5,3,1}; 
 * Associated runtime: O(nlogn)
 *
 * 3. Approach to handling duplicate values in array: 
 * Approach: There's no separate case that I made in the qsort method, but Adeebur put a *<=* 
 *           when comparing arr[i] and pvtVal in the for loop. So instead of comparing things strictly less
 *           than the pvtVal, it can also compare things that are equivalent to the pvtVal.
 *
 * 4a. another test:
 *	// not ordered, left partition --> 0.161 s
 *	int [] arr1 = {7,1,5,12,3};
 *	// small->big, left partition --> 0.158 s
 *	int [] arr2 = {1,3,5,7,12};
 *	// big->small, left partition --> 0.169 s
 *	int [] arr3 = {12,7,5,3,1}; 
 *****************************************************/

public class QuickSort 
{
    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int x, int y, int[] o ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }

    //print input array 
    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }

    //shuffle elements of input array
    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
	}
    }

    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal ) {
	int[] retArr = new int[s];
	for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
	return retArr;
    }
    
    //--------------^  HELPER METHODS  ^--------------

    /*****************************************************
     * void qsort(int[], int, int)
     * @param d -- array of ints to be sorted in place
     * @param left -- leftmost index of d that you want to compare
     * @param right -- rightmost index of d that you want to compare
     *****************************************************/
    public static void qsort( int[] d , int left, int right) 
    {
	if (left < right)
	    {
		//int pvtPos = partition (d, left, right, left+1);
		int pvtPos = partition (d, left, right, right-1);
		//int pvtPos = partition (d, left, right, (int)(Math.random()*d.length-1));
		// qsort of all elements from the lower bound to the element right before pvtPos
		qsort (d, left, pvtPos-1);
		// qsort of all elements from one right to the pvtPos to the upper bound
		qsort (d, pvtPos+1, right);
	    }
    }

    /* --- method below taken from Adeebur's code from hw14 --- */
    public static int partition (int[] arr, int left, int right, int pvtPos) {
	int pvtVal = arr[pvtPos];
	swap(pvtPos, right, arr);
	int storVal = left;	
	for (int i = left; i < right; i++) {
	    if (arr[i] <= pvtVal) {
		swap(i, storVal, arr);
		storVal++;
	    }
	}
	swap(storVal, right, arr);	
	return storVal;
    }//end partition()

    //main method for testing
    public static void main( String[] args ) 
    {
	//get-it-up-and-running, static test case:
	int [] arr1 = {7,1,5,12,3};
	System.out.println("\narr1 init'd to: " );
	printArr(arr1);

	qsort( arr1, 0, arr1.length-1 );	
       	System.out.println("arr1 after qsort: " );
	printArr(arr1);

	// randomly-generated arrays of n distinct vals
	int[] arrN = new int[10];
	for( int i = 0; i < arrN.length; i++ )
	arrN[i] = i;
       
	System.out.println("\narrN init'd to: " );
	printArr(arrN);

       	shuffle(arrN);
       	System.out.println("arrN post-shuffle: " );
	printArr(arrN);

	qsort( arrN, 0, arrN.length-1 );
	System.out.println("arrN after sort: " );
	printArr(arrN);

	//get-it-up-and-running, static test case w/ dupes:
	int [] arr2 = {7,1,5,12,3,7};
	System.out.println("\narr2 init'd to: " );
	printArr(arr2);

	qsort( arr2, 0, arr2.length-1 );	
       	System.out.println("arr2 after qsort: " );
	printArr(arr2);


	// arrays of randomly generated ints
	int[] arrMatey = new int[20];
	for( int i = 0; i < arrMatey.length; i++ )
	arrMatey[i] = (int)( 48 * Math.random() );
       
	System.out.println("\narrMatey init'd to: " );
	printArr(arrMatey);

       	shuffle(arrMatey);
       	System.out.println("arrMatey post-shuffle: " );
	printArr(arrMatey);

	qsort( arrMatey, 0, arrMatey.length-1 );
	System.out.println("arrMatey after sort: " );
	printArr(arrMatey);
    }//end main
}//end class QuickSort
