// Yedoh Kang
// APCS2 pd1
// HW13 -- We Be Dem
// 2017-03-07

public class Mysterion {

    private int[] arr = {8, 21, 17, 69, 343};
    private int a;
    private int b;
    private int c;

    public Mysterion (int d, int e, int f) {
	a = d;
	b = e;
	c = f;
    }

    public String toString() {
	String retStr = "";
	for (int i : arr) {
	    retStr += i + ",";
	}
	return retStr;
    }

    /*=========
     * General Description of the function: 
     * I don't know exactly, but it seems like it's trying to order an array 
     *     of integers. It's not completely ordered, but there's something to 
     *     do with the parameters that helps order them. (?)
     * a: ?
     * b: ?
     * c: ?
     =========*/
    
    public int sort (int a, int b, int c) {
	// swap
	int v = arr[c];
	arr[c] = arr[b];
	arr[b] = v;

	int s = a;
	for (int i = 0; i < b - 1; i++){
	    if (arr[i] < v) {
		// swap
		int x = arr[s];
		arr[s] = arr[i];
		arr[i] = x;
		s += 1;
	    }
	}
	// swap
	int y = arr[b];
	arr[b] = arr[s];
	arr[s] = y;
	
	return s;
    }

    public static void main (String[] args) {
	Mysterion test = new Mysterion (0,1,2);
	test.sort(0,1,2);
	System.out.println(test);

	Mysterion test1 = new Mysterion (0,1,3);
	test1.sort(0,1,3);
	System.out.println(test1);

	Mysterion test2 = new Mysterion (0,4,2);
	test2.sort(0,4,2);
	System.out.println(test2);

	Mysterion test3 = new Mysterion (3,4,2);
	test3.sort(3,4,2);
	System.out.println(test3);
    }
}
