// Yedoh Kang
// APCS2 pd1
// HW34 -- Algorithm as Data Structure
// 2017-05-04

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
    BST () 
    {
        root = null;
    }


    /*****************************************************
     * void insert( int ) 
     * Adds a new data element to the tree at appropriate location.
     *****************************************************/
    public void insert( int newVal ) 
    {
	if (root == null) {
	    root = new TreeNode(newVal);
	}
	else {
	    TreeNode p = null;
	    TreeNode q = root;
	    while (q != null) {
		p = q;
		// if the input value is less than the current root
		if (newVal < p.getValue()) {
		    // set new root to its left node
		    q = p.getLeft();
		}
		// if the input value is greater than the current root
		else {
		    // set new root to its right node
		    q = p.getRight();
		}
	    }
	    // if the input value is less than the current root
	    if (newVal < p.getValue()) {
		// insert newVal to its left
		p.setLeft(new TreeNode(newVal));
	    }
	    // if the input value is greater than the current root
	    else {
		// insert newVal to its right
		p.setRight(new TreeNode(newVal));
	    }
	}
    }


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

    // each traversal should simply print to standard out 
    // the nodes visited, in order

    public void preOrderTrav() 
    {
	preOrder(root);
    }

    public void preOrder (TreeNode t)
    {
	if (t != null) {
	    System.out.print(t.getValue());
	    preOrder(t.getLeft());
	    preOrder(t.getRight());
	}
    }

    public void inOrderTrav() 
    {
	inOrder(root);
    }

    public void inOrder (TreeNode t)
    {
	if (t != null) {
	    inOrder(t.getLeft());
	    System.out.print(t.getValue());
	    inOrder(t.getRight());
	}
    }

    public void postOrderTrav() 
    {
	postOrder(root);
    }

    public void postOrder (TreeNode t)
    {
	if (t != null) {
	    postOrder(t.getLeft());
	    postOrder(t.getRight());
	    System.out.print(t.getValue());
	}
    }
    //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


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
	System.out.println();

	System.out.println( "\nin-order traversal:" );
	arbol.inOrderTrav();
	System.out.println();

	
	System.out.println( "\npost-order traversal:" );
	arbol.postOrderTrav();
	System.out.println();
	 
    }

}//end class
