// Yedoh Kang
// APCS2 pd1
// HW1016b: Rockin’ Through the Night
// 2017-03-12

/*****************************************************
 * class LList
 * skeleton
 * Implements a linked list of LLNodes.
 *****************************************************/

public class LList implements List 
{ //your homemade List.java must be in same dir

    //instance vars
    private LLNode _head;
    private int _size;

    // constructor -- initializes instance vars
    public LList( ) 
    {
	_size = 0;
	_head = null;
    }


    //--------------v  List interface methods  v--------------

    // adds String x as a node to the end of the linked list
    public boolean add( String x ) {   
	LLNode test = new LLNode (x, null);
	// base case
	if (_head == null) {
	    _head = test;
	}
	else {
	    LLNode temp = _head;
	    // until we find a null place
	    while ( temp.getNext() != null) {
		temp = temp.getNext();
	    }
	    temp.setNext(test);
	}
	_size++;
	return true;
    }

    // returns the cargo at int i
    public String get( int i ){

	LLNode temp = _head;
	for (int k = 0; k < i; k++) {
	    temp = temp.getNext();
	}
	return temp.getCargo();

    }

    // replaces node at position i with a new node with cargo (string) x
    public String set( int i, String x ) {

	String retStr = get(i);
	LLNode temp = _head;
	while (i != 0) {
	    if (temp.equals(null)) {
		return null;
	    }
	    temp = _head.getNext();
	    i--;
	}
	_head.setCargo(x);
	return retStr;
    }

    //return number of nodes in list
    public int size() { return _size; } 

    //--------------^  List interface methods  ^--------------


    // override inherited toString
    public String toString() { 
	String retStr = "HEAD->";
	LLNode tmp = _head; //init tr
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

	System.out.println( "2nd item is: " + james.get(1) );

	james.set( 1, "got" );
	//System.out.println( "...and now 2nd item is: " + james.set(1,"got") );

	System.out.println( james );
				/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class LList



