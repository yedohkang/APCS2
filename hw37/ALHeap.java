// Yedoh Kang
// APCS2 pd
// HW37 -- Heap o'Trouble
// 2017-05-10

/*****************************************************
 * class ALHeap
 * Implements a min heap using an ArrayList as underlying container
 *****************************************************/

import java.util.ArrayList;

public class ALHeap 
{
    //instance vars
    private ArrayList<Integer> _heap; //underlying container is array of Integers

    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public ALHeap() 
    { 
	_heap = new ArrayList<Integer>();
    }



    /*****************************************************
     * toString()  ---  overrides inherited method
     * Returns either 
     * a) a level-order traversal of the tree (simple version)
     * b) ASCII representation of the tree (bit more complicated, much more fun)
     *****************************************************/
    public String toString() 
    {
	String retStr = "";
	int n = 1;
        for (int i = 0; i < _heap.size(); i++) {
	    if (i == Math.pow(2,n) - 1) {
	        retStr += "\n";
		n++;
	    }
	    retStr += _heap.get(i) + " ";
	}
	return retStr + "\n";
		 
    }//O(n)



    /*****************************************************
     * boolean isEmpty()
     * Returns true if no meaningful elements in heap, false otherwise
     *****************************************************/
    public boolean isEmpty() 
    { 
	return _heap.isEmpty(); 
    } //O(1)



    /*****************************************************
     * Integer peekMin()
     * Returns min value in heap
     * Postcondition: Heap remains unchanged.
     *****************************************************/
    public Integer peekMin() 
    {
	return _heap.get(0);
    } //O(1)



    /*****************************************************
     * add(Integer) 
     * Inserts an element in the heap
     * Postcondition: Tree maintains heap property.
     * Algo: 
     * insert at the next open spot in the array
     * keep on swapping with its parent node if it's less
     * stop swapping when it's bigger than its parent
     *****************************************************/
    public void add( Integer addVal ) 
    {
	// if the AL is empty
	if (_heap.size() == 0) {
	    _heap.add(addVal);
	}
       
        else {
	    int currPos = _heap.size();
	    // add the value to the end
	    _heap.add(addVal);

	    // while the value added is less than its parent node
	    while (addVal < _heap.get((currPos-1)/2)) {
		// swap!
		swap (currPos, (currPos-1)/2);
		// update the current position of the value added
	        currPos = (currPos - 1) / 2;
	    }
	}    
    } //O(logn)



    /*****************************************************
     * removeMin()  ---  means of removing an element from heap
     * Removes and returns least element in heap.
     * Postcondition: Tree maintains heap property.
     * Algo: 
     * swap the last value in the AL with the least element (first value)
     * remove the last value (b/c now the least element that you wanted to remove)
     * keep on comparing & swapping with its children nodes (if it is bigger)
     *****************************************************/
    public Integer removeMin() 
    {
	if (_heap.size() == 0) {
	    return null;
	}
	Integer retVal = peekMin();
	_heap.remove(retVal); // remove value from AL
	int pos = 0;
	int newPos = minChildPos(pos);

	// while the newPos exists and the value at the current position is greater than the least of the value of its children
	while (newPos != -1 && _heap.get(pos) > _heap.get(newPos)) {
	    swap (pos, newPos); // swap
	    pos = newPos; // swap positions
	    newPos = minChildPos(pos); // assign new pos
	}
	return retVal;
    }//O(logn)



    /*****************************************************
     * minChildPos(int)  ---  helper fxn for removeMin()
     * Returns index of least child, or 
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     *****************************************************/
    private int minChildPos( int pos ) 
    {
	// if pos is not in the AL
	if (!(pos > _heap.size() - 1)) {
	    int leftChildPos = (pos * 2) + 1;
	    int rightChildPos = (pos + 1) * 2;

	    // if both children exist
	    if ((leftChildPos < _heap.size()) && (rightChildPos < _heap.size())) {
		if (_heap.get(leftChildPos) < _heap.get(rightChildPos)) {
		    return leftChildPos;
		}
		else if (_heap.get(leftChildPos) >= _heap.get(rightChildPos)) {
		    return rightChildPos;
		}
	    }
	    // if only right child exists
	    else if (!(leftChildPos < _heap.size()) && (rightChildPos < _heap.size())) {
		return rightChildPos;
	    }
	    // if only left child exists
	    else if ((leftChildPos < _heap.size()) && !(rightChildPos < _heap.size())) {
		return leftChildPos;
	    }
	    // if none exist
	    else {
		return -1;
	    }
	}
	return -1;
    }//O(1)



    //************ aux helper fxns ***************
    private Integer minOf( Integer a, Integer b ) 
    {
	if ( a.compareTo(b) < 0 )
	    return a;
	else
	    return b;
    }

    //swap for an ArrayList
    private void swap( int pos1, int pos2 ) 
    {
	_heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );	
    }
    //********************************************



    //main method for testing
    public static void main( String[] args ) 
    {


	ALHeap pile = new ALHeap();

	pile.add(2);
	System.out.println(pile);
	pile.add(4);
	System.out.println(pile);
	pile.add(6);
	System.out.println(pile);
	pile.add(8);
	System.out.println(pile);
	pile.add(10);
	System.out.println(pile);
	pile.add(1);
	System.out.println(pile);
	pile.add(3);
	System.out.println(pile);
	pile.add(5);
	System.out.println(pile);
	pile.add(7);
	System.out.println(pile);
	pile.add(9);
	System.out.println(pile);

	

	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
/*--V--------------MOVE ME DOWN------------------V---
	  ==|============================================|===*/

    }//end main()

}//end class ALHeap
