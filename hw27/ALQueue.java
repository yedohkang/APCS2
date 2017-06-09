// Team KangLin (Kristin Lin, Yedoh Kang)
// APCS2 pd1
// HW27 -- ...Nor do Aussies
// 03-30-17

/*****************************************************
 * class ALQueue
 * Implements a queue, generically typed.
 * Uses an ArrayList as underlying container.

 * front is the beginning of the AL and end is the back of the AL
 *
 * Kristin and I found out that it didn't matter which end was the front and which end was the back.
 * If the front is the front, and the back is the end, for enqueue, it would be constant runtime and for dequeue, it would be
 * a linear runtime because every element would have to move up one spot.
 * If the front is the end, and the back is the front, for enqueue, it would be a linear runtime because inserting an element
 * would require all the elements to move over one spot, and for dequeue, it would be a constant runtime because you would
 * not have to traverse through the AL.
 *
 * And then, after a discussion, we found out that we could have constant runtime for EACH method.
 * Like LLQueue, we had a start and end pointer (points to the index).
 * For enqueue, we would use the AL add method which would be constant runtime, then update the end index.
 * For the dequeue, we would NOT use the AL remove method -- instead, we would move the start pointer one index to the right.
 * We also discussed whether if using more storage was more efficient than having a linear runtime for the remove method,
 * and decided that using more storage was greater.
 *****************************************************/

import java.util.ArrayList;

public class ALQueue<T> implements Queue<T> 
{
    private ArrayList<T> _queue;
    private int start;
    private int end;
 
    //constructor
    public ALQueue() 
    { 
        _queue = new ArrayList<T>();
	start = 0;
	end = 0;
    }

    //means of insertion
    public void enqueue( T s ) 
    {
        _queue.add(s);
	end++;
    } //O(1)

    //means of viewing top element without removing
    public T peekFront( ) 
    { 
        return _queue.get(start);
    } //O(1)

    //means of removal
    public T dequeue( ) 
    {
	start += 1;
	return _queue.get(start - 1);
    } //O(1)


    //chk for emptiness
    public boolean isEmpty() 
    {
	return start == end;
    } //O(1)

    public String toString() {
	String retStr = "";
	for (T val : _queue) {
	    retStr += val + ", ";
	}
	return retStr;
    } //O(n)

    //main method for testing
    public static void main( String[] args ) 
    {
	Queue<String> ALQueuelJ = new ALQueue<String>();

	System.out.println("\nnow enqueuing thrice..."); 
	ALQueuelJ.enqueue("James");
	ALQueuelJ.enqueue("Todd");
	ALQueuelJ.enqueue("Smith");

	System.out.println("\nnow testing toString()..."); 
	System.out.println( ALQueuelJ ); //for testing toString()...

	System.out.println("\nnow dequeuing thrice..."); 
	System.out.println( ALQueuelJ.dequeue() );
	System.out.println( ALQueuelJ.dequeue() );
	System.out.println( ALQueuelJ.dequeue() );

	System.out.println("\nDequeuing from empty queue should yield error..."); 
	System.out.println( ALQueuelJ.dequeue() );
    }//end main()

}//end class ALStack
