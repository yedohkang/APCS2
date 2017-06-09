// Yedoh Kang
// APCS2 pd1
// HW22 -- Stacks on Stacks on Stacks on Stacks...
// 2017-03-23

/***
 * class Latkes
 * a class to implement a stack of Strings)
 * uses an array as underlying data structure
 ***/

public class Latkes 
{

    private String [] _stack;
    private int _stackSize;

    //constructor
    public Latkes(int size) 
    { 
        _stack = new String[size];
	_stackSize = 0;
    }

    //means of insertion, first one in is element 0
    public void push( String s ) 
    {
	int counter = 0;
	while (_stack[counter] != null)
	    counter++;
	// push
	_stack[counter] = s;
        _stackSize++;
    }

    //means of removal, first one out is the last element
    public String pop( ) 
    {
	String retStr = "";
        if (_stackSize == 0)
	    return null;
	else {
	    int counter = 0;
	    if (isFull()) {
		// save String at element
		retStr = _stack[_stackSize-1];
		// replace
		_stack[_stackSize-1] = null;
	    }
	    else {
		while (_stack[counter] != null)
		    counter++;
		// save String at element
		retStr = _stack[counter-1];
		// replace
		_stack[counter-1] = null;
	    }
	}
	_stackSize--;
	return retStr;
    }

    //chk for emptiness
    public boolean isEmpty() 
    { 
        if (_stackSize == 0)
	    return true;
	return false;
    }

    //chk for fullness
    public boolean isFull() 
    {
	if (_stack.length == _stackSize)
	    return true;
	return false;
    }

    /* testing

    public String toString() {
	String retStr = "";
	for (String n : _stack) {
	    retStr += n + ", ";
	}
	return retStr;
    }

    public static void main (String[] args) {
	Latkes test = new Latkes (5);
	//System.out.println(test.isEmpty());
	test.push("hello");
	test.push("nice to meet you");
	test.push("whateves");
	test.push("Test");
	test.push("test2");
	//System.out.println(test.isEmpty());
	//System.out.println(test.isFull());
	System.out.println(test);
	test.pop();
	test.pop();
	test.pop();
	test.pop();
	test.pop();
	System.out.println(test);
	System.out.println(test.isEmpty());
    }
    */

}//end class Latkes

