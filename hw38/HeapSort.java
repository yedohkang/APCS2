// Yedoh Kang
// APCS2 pd1
// HW38 -- Sort of Like Magic
// 2017-05-11

/*======
 * Class HeapSort
 * algo: add the values into a ALHeap ArrayList, where added values will be added
 * in a "heapish" manner
 * create a temp AL array, and append the minimum value of the ALHeap AL, using 
 * removeMin()

=======*/

import java.util.ArrayList;
import java.io.*;

public class HeapSort {

    private ALHeap _original; // original, ALHeap AL
    private ArrayList<Integer> _temp; // temp array

    public HeapSort () {
	_original = new ALHeap();
	_temp = new ArrayList<Integer>();
    }

    public void insert (Integer addVal) {
	_original.add(addVal); // add in a heapish manner
    }

    public ArrayList<Integer> sort () {
	while (_original.size() > 0) {
	    _temp.add(_original.removeMin()); // add the min value to the temp array
	}
	return _temp;
    }

    public static void main (String[] args) {
	HeapSort test = new HeapSort();
	test.insert(0);
	test.insert(6);
	test.insert(5);
	test.insert(2);
	test.insert(1);
	test.insert(4);
	test.insert(3);

	System.out.println(test.sort());
    }

} // end class
