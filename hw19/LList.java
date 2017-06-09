// Yedoh Kang
// APCS2 pd1
// HW18b -- On the DLL
// 2017-03-16

/*****************************************************
 * class LList
 * skeleton
 * Implements a linked list of LLNodes.
 *****************************************************/

public class LList<T> implements List<T>
{ //your homemade List.java must be in same dir

    //instance vars
    private DLLNode<T> _head;
    private DLLNode<T> _tail;
    private int _size;

    // constructor -- initializes instance vars
    public LList( ) 
    {
	_size = 0;
	_head = null;
	_tail = null;
    }


    //--------------v  List interface methods  v--------------

    // adds String x as a node to the end of the linked list
    public boolean add( T x ) {
	DLLNode<T> input = new DLLNode<T> (x, null, _tail);
	if (_tail != null) {
	    _tail.setNext(input);
	}
	_tail = input;
	if (_head == null) {
	    _head = input;
	}
	_size++;
	return true;
    }

    // returns the cargo at index i
    public T get( int i ){
	DLLNode<T> current = _head;
	for (int k = 0; k < i; k++) {
	    // move pointer to the next node, until it reaches the index
	    current = current.getNext();
	}
	// return the cargo at that index
	return current.getCargo();
    }

    // replaces node at position i with a new node with cargo (string) x
    public T set( int i, T x ) {
	T retStr = get(i);
	DLLNode<T> current = _head;
	// while index is not reached
	while (i != 0) {
	    if (current.equals(null)) {
		return null;
	    }
	    // move the pointer to the right
	    current = _head.getNext();
	    i--;
	}
	// set the cargo at that node to String x
	_head.setCargo(x);
	return retStr;
    }


    //insert a node containing newVal at position index
    public void add( int index, T newVal )
    {
	// add at the beginning of the Linked List
	if (index == 0) {
	    add(newVal);
	}
	// add at the end of the Linked List
	else if (index == size()) {
	    add(newVal);
	}
	else {
	    DLLNode<T> input = new DLLNode<T> (newVal, null, null);
	    DLLNode<T> current = _head;
	    index -= 1;
	    // traverse through the Linked List till the end
	    for (int i = 1; i < size(); i++) {
		// if the counter reaches the index
		if (i == index) {
		    // save the next node
		    DLLNode<T> temp = current.getNext();
		    // replace the next node as the input
		    current.setNext(input);
		    // set next node as the next node that was saved
		    input.setNext(temp);
		    break;
		}
		// move pointer to the right
		current = current.getNext();
	    }
	}
	_size++;
    }

    //remove node at pos index, return its cargo
    public T remove( int index )
    {
	T retStr = get(index);
	// base case
	if (_head == null) {
	    retStr += "cannot remove b/c null";
	}
	else {
	    DLLNode<T> current = _head;
	    index -= 1;
	    for (int i = 1; i < size(); i++) {
		// if the counter reaches the index
		if (i == index) {
		    // set temp as the next node
		    DLLNode<T> temp = current.getNext();
		    // set next as the next node after temp
		    DLLNode<T> next = temp.getNext();
		    // remove temp
		    current.setNext(next);
		    break;
		}
		// move pointer to the right
		current = current.getNext();
	    }
	    _size--;
	}
	return retStr;
    }
    
    //return number of nodes in list
    public int size()
    {
	return _size;
    } 

    //--------------^  List interface methods  ^--------------


    // override inherited toString
    public String toString() { 
	String retStr = "HEAD->";
	DLLNode<T> tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "NULL";
	return retStr;
    }


    //main method for testing
    public static void main( String[] args ) 
    {
      
	LList james = new LList();

	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("beat");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("a");
	System.out.println( james );
	System.out.println( "size: " + james.size() );		

	james.add("need");
	System.out.println( james );
	System.out.println( "size: " + james.size() );
 
	james.add("I");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add(3, "hello");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.remove(3);
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	//	System.out.println( "2nd item is: " + james.get(1) );

	//	james.set( 1, "got" );
	//System.out.println( "...and now 2nd item is: " + james.set(1,"got") );

	//	System.out.println( james );
	/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class LList

