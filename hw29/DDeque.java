//Chipettes (Yedoh Kang, Vernita Lawren, Kristin Lin)
//APCS2 pd1
//LAB02 -- All Hands on Deque! (Not Schenectady; rather, synecdoche.)
//2017-04-04

import java.util.NoSuchElementException;
public class DDeque<T> implements Deque<T>{

    //instance variables, in which doubly-linked nodes were used
    private int _size;
    private DLLNode<T> _head;
    private DLLNode<T> _tail;

    //constructor; creates an empty deque wil null pointers
    public DDeque () {
        _head = null;
        _tail = null;
        _size = 0;
    }
    
    //adds node to the front
    public void addFirst(T deqVal) {
	//insert node, where prevNode is null and the nextNode is current _head
        DLLNode<T> insert = new DLLNode<T> (deqVal, null, _head);
        _head = insert; //set head as new node
	//if this deque was empty, _tail also points to new node
	if (_size == 0) { 
            _tail = _head;
        }
        //otherwise, link previous _head to new _head
	else {
	    _head.getNext().setPrev(_head); 
	}
        _size++; //increase size
    } // O(1)
    
    //adds node to the end
    public void addLast(T deqVal) {
	//insert node, where prevNode is the current _tail and the nextNode is null
        DLLNode<T> insert = new DLLNode<T> (deqVal, _tail, null);
	//last node becomes the insert node
	_tail = insert;
	 //if this deque is empty, _head points to the _tail
        if (_size == 0) {
	    _head = _tail;
        }
	//otherwise, link previous _tail to new _tail
	else {
	    _tail.getPrev().setNext(_tail);
	}
	_size++; //increase size
    } // O(1)
    
    //removes node from the front
    public T removeFirst() {
	 //retrieve current _head 
        T retVal = getFirst();
	 //if deque has a size of one, set both _head and _tail to null
        if (_size == 1) {
           _head = _tail = null;
        }
        //if size is 0, throw an exception
	else {
           _head = _head.getNext();
           _head.setPrev( null );
        }
        _size--; //decrease _size
        return retVal;
    } // O(1)

    //removes node from the end
    public T removeLast() {
	//retreive current _tail
        T retVal = getLast();	
        //if deque has a size of one, set both _head and _tail to null
	if (_size == 1) {
	    _head = _tail = null;
	}
        //if size is 0, throw an exception
	else {
	    _tail = _tail.getPrev();
	    _tail.setNext(null);
	}
	_size--; //decrease size
	return retVal;
    } //O(1)
    
    //checks if deque contains given element
    public boolean contains (T deqVal) {
	DLLNode<T> temp = _head;
	while (temp != null) {
	    if (temp.getCargo().equals(deqVal)) {
		return true;
	    }
            temp = temp.getNext();
	}
	return false;
    } // O(n)

    //removes first occurance of specified element
    public boolean removeFirstOccurrence (T deqVal) {
	DLLNode<T> temp = _head; //create dummy node that traverses from left to right
	while (temp != null){
	    if (temp.getCargo().equals(deqVal)) { //if value is present
		if (temp == _head) {
		    removeFirst(); //or the front, removeFirst()
		}
		else if (temp == _tail) {
		    removeLast(); //and it’s at the end, removeLast()
		}
		else { 
		    //otherwise, link nodes in front and behind dummy node to remove
		    temp.getPrev().setNext(temp.getNext());
		    temp.getNext().setPrev(temp.getPrev());
		    _size--; //decrease _size
		}
		return true;
	    }
	    temp = temp.getNext(); //if value is not encountered, move to next node
	}
	return false; //after traversal and value is not present, return false
    } // O(n)
    
    //removes last occurance of specified element
    public boolean removeLastOccurrence (T deqVal) {
	DLLNode<T> temp = _tail; //create dummy node that traverses from right to left
	while (temp != null) {
	    if (temp.getCargo().equals(deqVal)) { //if value is present, 
		if (temp == _tail) {
                  removeLast(); //and it’s at the end, removeLast()
		}
		else if (temp == _head) {
		    removeFirst(); //or the front, removeFirst()
		}
		else { 
		    //otherwise, link nodes in front and behind dummy node to remove
		    temp.getPrev().setNext(temp.getNext());
		    temp.getNext().setPrev(temp.getPrev());
	            _size--; //housekeeping
		}
		return true;
	    }
	    temp = temp.getPrev(); //if value is not encountered, move to previous node
	}
	return false; //after traversal and value is not present, return false
    } // O(n)

    //accessor for _size variable
    public int size() {
        return _size;
    } // O(1)
    
    //returns first node
    public T getFirst() {
	//if size is 0, throw an exception
        if (_size == 0) {
	     throw new NoSuchElementException();
        }
        //if size is 0, throw an exception
	else {
	    return _head.getCargo();
        }
    } // O(1)

    //return last node
    public T getLast() {
        //if size is 0, throw an exception
        if (_size == 0) { 
	     throw new NoSuchElementException();
        }
        //if size is 0, throw an exception
	else {
            return _tail.getCargo();
        }
    } // O(1)


    //overwritten toString
    public String toString() {
        String retStr = "HEAD-->";
        DLLNode<T> temp = _head;
        while (temp != null) {
	     retStr += temp.getCargo() + "-->";
            temp = temp.getNext();
        }
        retStr += "NULL";
        return retStr;
    } // O(n)
    
    //main method for testing
    public static void main( String[] args ) 
    {
	DDeque<String> james = new DDeque<String>();

	System.out.println("initially: " );
	System.out.println( james + "\tsize: " + james.size() );

	james.addLast("a");
	System.out.println( james + "\tsize: " + james.size() );

	james.addFirst("need");
	System.out.println( james + "\tsize: " + james.size() );

	james.addLast("beat");
	System.out.println( james + "\tsize: " + james.size() );

	james.addFirst("I");
	System.out.println( james + "\tsize: " + james.size() );

	System.out.println( "First item is: " + james.getFirst() );

	System.out.println("");	

	System.out.println( james + "\tcontains: I? " + james.contains("I"));
	System.out.println( james + "\tcontains: hello? " + james.contains("hello"));
	james.addLast("need");
	james.addLast("a");
	System.out.println( "\nTwo instances of 'need' and 'a': \n" + james );

	System.out.println ( "Remove first occurrence of 'need': " + james.removeFirstOccurrence("need") + "\n" + james );
	System.out.println ( "Remove last occurrence of 'a': " + james.removeLastOccurrence("a") + "\n" + james );

	james.addFirst("wait");
	System.out.println( "\n...and now first item is: " + james.getFirst());
	System.out.println( james + "\tsize: " + james.size() );

	System.out.println( "...after remove last: " + james.removeLast() );
	System.out.println( james + "\tsize: " + james.size() );

	System.out.println( "...after remove first: " + james.removeFirst() );
	System.out.println( james + "\tsize: " + james.size() );

	System.out.println( "...after remove first: " + james.removeFirst() );
	System.out.println( james + "\tsize: " + james.size() );

	System.out.println( "...after removefirst: " + james.removeFirst() );
	System.out.println( james + "\tsize: " + james.size() );

    }


}
