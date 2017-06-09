/*****************************************************
 * class ALStack
 * Implements a stack, generically typed.
 * Uses an ArrayList as underlying container.
 *****************************************************/

import java.util.ArrayList;

public class ALStack<T> implements Stack<T> 
{
    private ArrayList<T> _stack;
 
    //constructor
    public ALStack() 
    { 
	_stack = new ArrayList<T>();
    }

    //overloaded constructor to allow for init capacity
    public ALStack( int size ) 
    { 
	_stack = new ArrayList<T>(size);
    }

    //means of insertion
    public void push( T s ) 
    {
        _stack.add(0,s);
    }

    //means of viewing top element without removing
    public T peek( ) 
    {
	try {
	    return _stack.get(0);
	}
	catch (Exception e) {
	    return null;
	}
    }

    //means of removal
    public T pop( ) 
    {
	try {
	    return _stack.remove(0);
	}
	catch (Exception e) {
	    return null;
	}
    }


    //chk for emptiness
    public boolean isEmpty() 
    {
        if (_stack.size() == 0)
	    return true;
	return false;
    }


    //main method for testing
    public static void main( String[] args ) 
    {

	  Stack<String> tastyStack = new ALStack<String>();

	  tastyStack.push("aoo");
	  tastyStack.push("boo");
	  tastyStack.push("coo");
	  tastyStack.push("doo");
	  tastyStack.push("eoo");
	  tastyStack.push("foo");
	  tastyStack.push("goo");
	  tastyStack.push("hoo");
	  tastyStack.push("ioo");
	  tastyStack.push("joo");
	  tastyStack.push("coocoo");
	  tastyStack.push("cachoo");

	  //cachoo
	  System.out.println( "peek: " + tastyStack.peek() );
	  System.out.println( "pop: " + tastyStack.pop() );
	  //coocoo
	  System.out.println( "peek: " + tastyStack.peek() );
	  System.out.println( "pop: " + tastyStack.pop() );
	  //joo
	  System.out.println( "peek: " + tastyStack.peek() );
	  System.out.println( "pop: " + tastyStack.pop() );
	  //ioo
	  System.out.println( "peek: " + tastyStack.peek() );
	  System.out.println( "pop: " + tastyStack.pop() );
	  //hoo
	  System.out.println( "peek: " + tastyStack.peek() );
	  System.out.println( "pop: " + tastyStack.pop() );
	  //goo
	  System.out.println( "peek: " + tastyStack.peek() );
	  System.out.println( "pop: " + tastyStack.pop() );
	  //foo
	  System.out.println( "peek: " + tastyStack.peek() );
	  System.out.println( "pop: " + tastyStack.pop() );
	  //eoo
	  System.out.println( "peek: " + tastyStack.peek() );
	  System.out.println( "pop: " + tastyStack.pop() );
	  //doo
	  System.out.println( "peek: " + tastyStack.peek() );
	  System.out.println( "pop: " + tastyStack.pop() );
	  //coo
	  System.out.println( "peek: " + tastyStack.peek() );
	  System.out.println( "pop: " + tastyStack.pop() );
	  //boo
	  System.out.println( "peek: " + tastyStack.peek() );
	  System.out.println( "pop: " + tastyStack.pop() );
	  //aoo
	  System.out.println( "peek: " + tastyStack.peek() );
	  System.out.println( "pop: " + tastyStack.pop() );

	  //stack empty by now; SOP(null)
	  System.out.println( "peek: " + tastyStack.peek() );
	  System.out.println( "pop: " + tastyStack.pop() );
	  System.out.println( tastyStack.pop() );
	  	/*~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class ALStack
