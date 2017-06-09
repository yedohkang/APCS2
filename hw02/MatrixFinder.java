// Team BYE (Brian Kwong, Yedoh Kang)
// APCS2 pd1
// HW02 -- I Am Still Searching
// 2017-02-03

/*===============
Summary:
The search starts from the bottom left corner, and sets that number to the variable val.
If val is greater than the number, then it is compared with the number to the right.
If val is less than the number, then it is compared with the number above it. 
This is repeated until the number equal to val is found, or if val searches and ends up
at any of the corners or the last column. 
=============== */

public class MatrixFinder {
    
    public static String search( int[][] data, int val ) {
	int row = 0;
	int col = data.length-1;
	while (row != data.length && col != -1) {
	    //System.out.println( data[col][row] );
	    if (data[col][row] == val) {
		return "(" + col + ", " + row + ")";
	    }
	    else if (data[col][row] > val) {
		col--;
	    }
	    else {
		row++;
	    }
	}
	return "(-1, -1)";
    }
    
    public static void main( String[] args ) {
	int[][] test = { {1, 3, 5} ,
			 {3, 7, 8} ,
			 {5, 12, 15} 
	};
	System.out.println( search( test, 0 ) );
       	System.out.println( search( test, 1 ) );
	System.out.println( search( test, 2 ) );
	System.out.println( search( test, 3 ) );
	System.out.println( search( test, 5 ) );
	System.out.println( search( test, 6 ) );
	System.out.println( search( test, 8 ) );
	System.out.println( search( test, 9 ) );
	System.out.println( search( test, 16 ) );
    }
}
