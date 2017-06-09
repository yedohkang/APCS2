// Yedoh Kang
// APCS2 pd1
// HW35 -- BSTs is the Perfect Place for Shade
// 2017-05-05

/*****************************************************
 * class BST
 * <<< skeleton >>>
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT) 
 * A BST maintains the invariant that, for any node N with value V, 
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value, 
 *  and any value in its right subtree must be greater.)
 * This BST only holds ints (its nodes have int cargo)
 *****************************************************/

public class BST 
{
    //instance variables / attributes of a BST:

    private TreeNode root;

    /*****************************************************
     * default constructor
     *****************************************************/
    BST( ) 
    {
        root = null;
    }


    /*****************************************************
     * void insert( int ) 
     * Adds a new data element to the tree at appropriate location.
     *****************************************************/
    public void insert( int newVal ) 
    {
	TreeNode newNode = new TreeNode( newVal );

	if ( root == null ) {
	    root = newNode;
	    return;
	}
        insert( root, newNode );
    }
    
    //recursive helper for insert(int)
    public void insert( TreeNode stRoot, TreeNode newNode ) {

	if ( newNode.getValue() < stRoot.getValue() ) {
	    //if no left child, make newNode the left child
	    if ( stRoot.getLeft() == null )
		stRoot.setLeft( newNode );
	    else //recurse down left subtree
		insert( stRoot.getLeft(), newNode );
	    return;
	}
	else { // new val >= curr, so look down right subtree
	    //if no right child, make newNode the right child
	    if ( stRoot.getRight() == null )
		stRoot.setRight( newNode );
	    else //recurse down right subtree
		insert( stRoot.getRight(), newNode );
	    return;
	}
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

    //process root, recurse left, recurse right
    public void preOrderTrav() 
    {
	preOrderTrav( root );
    }
    public void preOrderTrav( TreeNode currNode ) {
	if ( currNode == null )
	    return;
	System.out.print( currNode.getValue() + " " );
	preOrderTrav( currNode.getLeft() );
	preOrderTrav( currNode.getRight() );
    }

    //recurse left, process root, recurse right
    public void inOrderTrav() 
    {
	inOrderTrav( root );
    }
    public void inOrderTrav( TreeNode currNode ) {
	if ( currNode == null )
	    return;
	inOrderTrav( currNode.getLeft() );
	System.out.print( currNode.getValue() + " " );
	inOrderTrav( currNode.getRight() );
    }

    //recurse left, recurse right, process root
    public void postOrderTrav() 
    {
	postOrderTrav( root );
    }
    public void postOrderTrav( TreeNode currNode ) {
	if ( currNode == null )
	    return;
	postOrderTrav( currNode.getLeft() );
	postOrderTrav( currNode.getRight() );
	System.out.print( currNode.getValue() + " "  );
    }
    //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



    /*****************************************************
     * TreeNode search(int)
     * returns pointer to node containing target,
     * or null if target not found
     *****************************************************/
    TreeNode search( int target )
    {
        TreeNode curr = root;
	TreeNode find = new TreeNode (target);

	// while the current node/root still exists exists and isn't the same value
	while (curr != null && find.getValue() != curr.getValue()) {
	    if (find.getValue() < curr.getValue()) {
	        curr = curr.getLeft();
	    }
	    else {
		curr = curr.getRight();
	    }
	}
	return curr;
    }


    /*****************************************************
     * int height()
     * returns height of this tree (length of longest leaf-to-root path)
     * eg: a 1-node tree has height 1
     *****************************************************/

    public int max2 (int a, int b) {
	if (a > b) {
	    return a;
	}
	else {
	    return b;
	}
    }
    public int height()
    {
	return heightHelp(root);
    }
    public int heightHelp (TreeNode t) {
	if (t == null) {
	    return 0;
	}
	else {
	    // return the total height using the max subtrees)
	    return 1 + max2(heightHelp(t.getLeft()), heightHelp(t.getRight()));
	}
    }


    /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
    public int numLeaves()
    {
	return numLeavesHelp(root);
    }

    public int numLeavesHelp(TreeNode t) {
        if (t == null) {
	    return 0;
	}
	// if both right and left children nodes are null
	if (t.getLeft() == null && t.getRight() == null) {
	    return 1;
	}
	else {
	    // sum of the number of leaves for the left and right subtrees, recursively
	    return numLeavesHelp(t.getLeft()) + numLeavesHelp(t.getRight());
	}
    }
 

    //main method for testing
    public static void main( String[] args ) 
    {

	BST arbol = new BST();

	arbol.insert( 4 );
	arbol.insert( 2 );
	arbol.insert( 5 );
	arbol.insert( 6 );
	arbol.insert( 1 );
	arbol.insert( 3 );

	System.out.println( "\npre-order traversal:" );
	arbol.preOrderTrav();

	System.out.println( "\nin-order traversal:" );
	arbol.inOrderTrav();
	
	System.out.println( "\npost-order traversal:" );
	arbol.postOrderTrav();	

	System.out.println( "\nlooking for 1:" );
	System.out.print( arbol.search(1));

	System.out.println( "\nlooking for 1:" );
	System.out.print( arbol.search(1));

	System.out.println( "\nlooking for 2:" );
	System.out.print( arbol.search(2));

	System.out.println( "\nlooking for 3:" );
	System.out.print( arbol.search(3));

	System.out.println( "\nlooking for 4:" );
	System.out.print( arbol.search(4));

	System.out.println( "\nlooking for 5:" );
	System.out.print( arbol.search(5));

	System.out.println( "\nlooking for 6:" );
	System.out.print( arbol.search(6));

	System.out.println( "\nlooking for 7:" );
	System.out.print( arbol.search(7));

        System.out.println( "\nHeight:" );
	System.out.print( arbol.height());

	System.out.println( "\nNumber of Leaves:" );
	System.out.print( arbol.numLeaves());

	/*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class
