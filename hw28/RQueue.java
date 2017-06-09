// Yedoh Kang
// APCS2 pd1
// HW28 -- Now Let’s Consider You Lot at Fake Terry’s
// 2017-03-31

/*****************************************************
 * class RQueue
 * A linked-list-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite data flow for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 * maintains these invariants: 
 * dequeuing removes/returns a random element
 * _front always points to next item to be removed
 ******************************************************/


public class RQueue<T> implements Queue<T> 
{
    private LLNode<T> _front, _end;
    private int _size;


    // default constructor creates an empty queue
    public RQueue() 
    { 
	_front = null;
	_end = null;
	_size = 0;
    }


    public void enqueue( T enQVal ) 
    {
	LLNode<T> input = new LLNode<T> (enQVal, null);
	if ( isEmpty() ) {
	    _front = input;
	    _end = input;
	}
	else {
	    _end.setNext (input);
	    _end = input;
	}
	_size++;
    }


    // remove and return thing at front of queue, then reorder elements
    // assume _queue ! empty
    public T dequeue() 
    { 
	T retVal = _front.getValue();
	_front = _front.getNext();
	//check for emptiness
	if ( _front == null ) {
	    _end = null;
	}
	_size--;
	if (_size > 1) {
	    sample();
	}
	return retVal;

	
    }


    //return next item to be dequeued
    public T peekFront() 
    {
	return _front.getValue();
    }


    /******************************************
     * void sample() -- a means of "shuffling" the queue
     * algo:
     * *kristin's algo!!!!! --> move the front element to the end a random number of times
     ******************************************/
    public void sample () 
    {
	int randomNum = (int)(Math.random() * _size);
	for (int i = 0; i < randomNum; i++) {
	    T output = _front.getValue();
	    _front = _front.getNext();
	    _size--;
	    enqueue(output);
	}
    }


    public boolean isEmpty() 
    { 
	return _front == null;
    }//O(1)


    // print each node, separated by spaces
    public String toString() 
    { 
	String foo = "";
	LLNode<T> tmp = _front;
	while ( tmp != null ) {
	    foo += tmp.getValue() + " ";
	    tmp = tmp.getNext();
	}
	return foo;
    }//O(n)



    //main method for testing
    public static void main( String[] args ) 
    {
	  Queue<String> PirateQueue = new RQueue<String>();

	  System.out.println("\nnow enqueuing..."); 
	  PirateQueue.enqueue("Dread");
	  PirateQueue.enqueue("Pirate");
	  PirateQueue.enqueue("Robert");
	  PirateQueue.enqueue("Blackbeard");
	  PirateQueue.enqueue("Peter");
	  PirateQueue.enqueue("Stuyvesant");

	  System.out.println("\nnow testing toString()..."); 
	  System.out.println( PirateQueue ); //for testing toString()...

	  System.out.println("\nnow dequeuing..."); 
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );

	  System.out.println("\nnow dequeuing fr empty queue..."); 
	  System.out.println( PirateQueue.dequeue() );
	  	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main

}//end class RQueue
