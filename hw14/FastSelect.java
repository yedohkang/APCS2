// Yedoh Kang
// APCS2 pd1
// HW14 -- So So Fast
// 2017-03-08


/***
 * class FastSelect
 * includes method to obtain yth smallest integer in an array
 * ALGORITHM
 * 1. Starting with the last index as the pvtPos, call partition method on input array.
 * 2. If index returned is equal to k-1, return value at the index.
 * 3. If index is larger than k-1, return fastSelect but now with bounds [oldLeft,pivot).
 * 4. If index is smaller, return fastSelect but now with bounds [pivot+1,oldRight].
 */

public class FastSelect {
   
    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int x, int y, int[] o ) {
        int tmp = o[x];
        o[x] = o[y];
        o[y] = tmp;
    }

    //--------------^  HELPER METHODS  ^--------------
    
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

    public static int fastSelect (int[] arr, int left, int right, int y) {
	int pivot = partition(arr,left,right,left+((right-left)/2));
	//pivot = final resting place of yth lowest num. Return value at index pivot
	if (pivot == y - 1){
	    return arr[pivot];
	}
	//pivot > final resting place. Restrict next call from left to pivot-1
	else if (pivot > y - 1) {
	    return fastSelect(arr,left,pivot-1,y);
	}
	//pivot < final resting place. Restrict next call from pivot+1 to right 
	else {
	    return fastSelect(arr,pivot+1,right,y);
	}
    }//end fastSelect() (helper)

    //main method for testing    
    public static void main(String args[]) {

	//init test arrays
	int[] p1 = {8,21,17,69,343};

	System.out.println("p1:");

        System.out.println(fastSelect(p1, 0, p1.length-1, 1));
	System.out.println(fastSelect(p1, 0, p1.length-1, 2));
	System.out.println(fastSelect(p1, 0, p1.length-1, 3));
	System.out.println(fastSelect(p1, 0, p1.length-1, 4));
	System.out.println(fastSelect(p1, 0, p1.length-1, 5));
	
    }//end main()
    
}//end class FastSelect

