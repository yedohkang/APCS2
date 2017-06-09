// Yedoh Kang
// APCS2 -- pd1
// HW08 -- [Freddie Mercury, Brian May, Roger Taylor, John Deacon] x n
// 2017-02-27

/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 ***/

public class QueenBoard 
{
    //2D array to represent n*n chessboard
    private int[][] _board;

    //constructor allows for specifying size
    public QueenBoard( int size ) 
    {
	_board = new int[size][size];
    }


    /***
     * precondition: board is filled with 0's only.
     * postcondition: 
     * If a solution is found, board shows position of N queens, 
     * returns true.
     * If no solution, board is filled with 0's, 
     * returns false.
     * ALGORITHM:
     * Recurse through the columns and loop throw the rows. Start on the top left square and place a queen, then move on to the next row and try to place queens, etc.
     * If at any point a queen can't be put down, backtrack to the last queen placed and place it somewhere else.
     */
    public boolean solve()
    {
	if (_board.length == 1) {
	    addQueen(0,0);
	    printSolution();
	    return true;
	}

	else if (_board.length == 2 || _board.length == 3) {
	    System.out.println("No solution!\n");
	    return false;
	}

	else {
	    solveH(0);
	    printSolution();
	    return true;
	}
    }

    /**
     *Helper method for solve. 
     */
    private boolean solveH( int col ) 
    {
	// if all the queens are already placed
	if (col == _board.length) {
	    return true;
	}

	// for each row
	for (int i = 0; i < _board.length; i++) {
	    // if a Queen can be placed
	    if (addQueen (i, col)) {
		// recursion for the rest of the Queens
		if (solveH(col+1)) {
		    return true;
		}
		// backtracking if it can't be placed
		removeQueen(i,col);
	    }   
	}
	return false;
    }


    //print a valid placement of n queens
    public void printSolution()
    {
	String ans = "";
	for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
		if (_board[r][c] == 1) {
		    ans += "Q" + "\t";
		}
		if (_board[r][c] == 0 || _board[r][c] < 0) {
		    ans += "_" + "\t";
		}
	    }
	    ans += "\n";
	}
	System.out.println(ans);
    }



    //================= YE OLDE SEPARATOR =================

    /***
     * A Queen is added to the row and col arguments by placing a 1, and all places that are not possible for other Queens to be placed are updated by subtracting 1. 
     * precondition: row and col exist
     * postcondition: a 1 is placed for the Queen, and the board is updated
     */
    private boolean addQueen(int row, int col)
    {
	// false if the spot is already taken and Queen isn't added
	if(_board[row][col] != 0){
	    return false;
	}

	// the Queen is placed in that spot
	_board[row][col] = 1;

	// helper/counter (for the next column/row)a helper/counter 
	int offset = 1;

	// while the columns exist
	while(col+offset < _board[row].length) {
	    // subtract 1 from the value of the adjacent spot in the next column
	    _board[row][col+offset]--;

	    // updates the diagonals
	    if( row - offset >= 0 ) {
		_board[row-offset][col+offset]--;
	    }
	    if( row + offset < _board.length ) {
		_board[row+offset][col+offset]--;
	    }
	    // update offset
	    offset++;
	}
	return true;
    }


    /***
     * A Queen is removed to the row and col arguments by placing a 0, and all places that are now possible for other Queens to be placed are updated by adding 1.
     * precondition: row and col exist
     * postcondition: the Queen is removed at the place and the board is updated
     */
    private boolean removeQueen(int row, int col)
    {
	// if there is no Queen in that position, return false
	if ( _board[row][col] != 1 ) {
	    return false;
	}
	_board[row][col] = 0;	// remove Queen by replacing it with a 0 (empty spot)
	int offset = 1;	        // helper/counter (for the next column/row)

	// update the rest of the board (update places in the board that were affected by the Queen being removed)
	while( col+offset < _board[row].length ) {
	    _board[row][col+offset]++;
	    if( row - offset >= 0 ) {
		_board[row-offset][col+offset]++;
	    }
	    if( row + offset < _board.length ) {
		_board[row+offset][col+offset]++;
	    }
	    offset++;
	}
	return true;
    }


    /***
     * Prints out the board
     * precondition: the board exists
     * postcondition: prints out a board with 0s, 1s, -1s, -2s, etc.
     */
    public String toString() 
    {
	String ans = "";
	for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
		ans += _board[r][c]+"\t";
	    }
	    ans += "\n";
	}
	return ans;
    }


    //main method for testing...
    public static void main( String[] args )
    {
	QueenBoard a = new QueenBoard(1);
	a.solve();
	QueenBoard b = new QueenBoard(2);
	b.solve();
	QueenBoard c = new QueenBoard(3);
	c.solve();
	QueenBoard d = new QueenBoard(4);
	d.solve();
	QueenBoard e = new QueenBoard(5);
	e.solve();
	QueenBoard f = new QueenBoard(6);
	f.solve();
	QueenBoard g = new QueenBoard(7);
	g.solve();
	QueenBoard h = new QueenBoard(8);
	h.solve();
    }//end main()
  
}//end class
