// Yedoh Kang
// APCS2 pd1
// HW29 -- Stress is the Best
// 2017-04-05

public class DequeTester {

    public static void main (String[] args) {

	DDeque<String> foo = new DDeque<String>();

	
	// testing addFirst

	// adds love to the front of the deque
	foo.addFirst("love");
	System.out.println(foo + "\tsize: " + foo.size());

	// adds I to the front of the deque
	foo.addFirst("I");
	System.out.println(foo + "\tsize: " + foo.size());

	// adds hello to the front of the deque
	foo.addFirst("hello");
	System.out.println(foo + "\tsize: " + foo.size());

	
	// testing addLast

	// adds green tea to the end of the deque
	foo.addLast("green tea");
	System.out.println(foo + "\tsize: " + foo.size());

	// adds ice cream to the end of the deque
	foo.addLast("ice cream");
	System.out.println(foo + "\tsize: " + foo.size());

	
	// testing removeFirst

	// removes the first element of the deque, hello
	foo.removeFirst();
	System.out.println(foo + "\tsize: " + foo.size());

	// removes the first element of the deque, I
	foo.removeFirst();
	System.out.println(foo + "\tsize: " + foo.size());

	// removes the first element of the deque, love
	foo.removeFirst();
	System.out.println(foo + "\tsize: " + foo.size());

	
	// testing removeLast

	// removes the last element of the deque, ice cream
	foo.removeLast();
	System.out.println(foo + "\tsize: " + foo.size());

	// removes the last element of the deque, green tea
	foo.removeLast();
	System.out.println(foo + "\tsize: " + foo.size());

	// removes the last element of the deque, null, so throws a NullPointerException
	//foo.removeLast();
	//System.out.println(foo + "\tsize: " + foo.size());

	
	// testing contains

	// adds corresponding String to the end of the deque, for testing purposes
	foo.addLast("hello");
	System.out.println(foo + "\tsize: " + foo.size());
	foo.addLast("hello");
	System.out.println(foo + "\tsize: " + foo.size());
	foo.addLast("how are you doing");
	System.out.println(foo + "\tsize: " + foo.size());
	foo.addLast("how are you doing");
	System.out.println(foo + "\tsize: " + foo.size());
	foo.addLast("hello");
	System.out.println(foo + "\tsize: " + foo.size());
	foo.addLast("green tea");
	System.out.println(foo + "\tsize: " + foo.size());

	// checks if the String green tea is contained in the deque, returns true
	System.out.println("contains: green tea?");
	System.out.println(foo.contains("green tea"));

	// checks if the String bye is contained in the deque, returns false
	System.out.println("contains: bye?");
	System.out.println(foo.contains("bye"));

	
	// testing removeFirstOccurrence

	// removes the first occurrence of how are you doing of the deque, returns true
	System.out.println("remove first occurrence of 'how are you doing'");
	System.out.println(foo.removeFirstOccurrence("how are you doing"));
	System.out.println(foo + "\tsize: " + foo.size());

	// removes the first occurrence of hello of the deque, returns true
	System.out.println("remove first occurrence of 'hello'");
	System.out.println(foo.removeFirstOccurrence("hello"));
	System.out.println(foo + "\tsize: " + foo.size());

	// removes the first occurrence of love of the deque, returns false
	System.out.println("remove first occurrence of 'love'");
	System.out.println(foo.removeFirstOccurrence("love"));
	System.out.println(foo + "\tsize: " + foo.size());

	
	// testing removeLastOccurrence

	// removes the last occurrence of how are you doing of the deque, returns true
	System.out.println("remove last occurrence of 'how are you doing'");
	System.out.println(foo.removeFirstOccurrence("how are you doing"));
	System.out.println(foo + "\tsize: " + foo.size());

	// removes the last occurrence of hello of the deque, returns true
	System.out.println("remove last occurrence of 'hello'");
	System.out.println(foo.removeFirstOccurrence("hello"));
	System.out.println(foo + "\tsize: " + foo.size());	

	// removes the last occurrence of green tea of the deque, returns true
	System.out.println("remove last occurrence of 'green tea'");
	System.out.println(foo.removeFirstOccurrence("green tea"));
	System.out.println(foo + "\tsize: " + foo.size());
	

    }

}
