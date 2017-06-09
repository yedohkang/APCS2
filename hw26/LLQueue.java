// Yedoh Kang
// APCS2 pd1
// HW26 -- The English Do Not Wait In Line
// 2017-03-28

/*****************************************************
 * class LLQueue
 * uses a linked list to implement a QUEUE
 * (a collection with FIFO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 * go from front to end (left to right)
 ******************************************************/

//import java.util.NoSuchElementException;
//import java.lang.RuntimeException;

public class LLQueue<T> implements Queue<T> {

    private LLNode<T> _front, _end;

    // default constructor creates an empty queue
    public LLQueue()
    { 
	_front = null;
	_end = null;
    }

    // means of adding a thing to the collection
    public void enqueue( T enQVal ) 
    {
	LLNode another = new LLNode(enQVal, null); 
	if (_front == null) { //if container was previously empty,
	    _front = another; //new value is both front and end
	    _end = another;
	} else {
	    //otherwise, make sure last value links to new node
	    _end.setNext(another); 
	    _end = another; //and new node is the new last value
	}
    }//O(1)


    // means of removing a thing from the collection
    // remove and return thing at front of queue
    // assume _queue ! empty
    public T dequeue() 
    {
	T output = _front.getValue(); //first in line's value
	_front = _front.getNext(); //next value is now the new first value
	return output;
    }//O(n)


    // means of peeking at thing next in line for removal
    public T peekFront() 
    {
	return _front.getValue();
    }//O(n)


    public boolean isEmpty() 
    {
	return _front == null;
    }//O(1)


    // print each node, separated by spaces
    public String toString() 
    {
	String retStr = " ";
	LLNode<T> temp = _end;
	while (temp != null) {
	    retStr += temp.getValue() + " ";
	    temp = temp.getNext();
	}
	return retStr;
	
    }//O(n)



    public static void main( String[] args ) {


	Queue<String> LLQueuelJ = new LLQueue<String>();

	System.out.println("\nnow enqueuing thrice..."); 
	LLQueuelJ.enqueue("James");
	LLQueuelJ.enqueue("Todd");
	LLQueuelJ.enqueue("Smith");

	System.out.println("\nnow testing toString()..."); 
	System.out.println( LLQueuelJ ); //for testing toString()...

	System.out.println("\nnow dequeuing thrice..."); 
	System.out.println( LLQueuelJ.dequeue() );
	System.out.println( LLQueuelJ.dequeue() );
	System.out.println( LLQueuelJ.dequeue() );

	System.out.println("\nDequeuing from empty queue should yield error..."); 
	System.out.println( LLQueuelJ.dequeue() );
	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
	  ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

    }//end main

}//end class LLQueue
