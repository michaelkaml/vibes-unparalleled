// Big Bird :: Raven (Ruiwen) Tang, Jun Hong Wang, Michael Kamela
// APCS pd6
// HW97 -- Prune Your Tree
// 2022-05-11w
// time spent: 0.8 hrs

/**
 * class BST
 * v1:partial
 * SKELETON
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT)
 *
 * A BST maintains the invariant that, for any node N with value V,
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value,
 *  and any value in its right subtree must be greater.)
 *
 * This BST implementation only holds ints (its nodes have int cargo)
 */

public class BST
{

  //instance variables / attributes of a BST:
  TreeNode _root;

  /**
   * default constructor
   */
  BST()
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    _root = null;
  }


  /**
   * void insert( int )
   * Adds a new data element to tree.
   */
  public void insert( int newVal )
  {
    TreeNode newNode = new TreeNode( newVal );
    /*** YOUR IMPLEMENTATION HERE ***/
    if (_root == null) {
      _root = newNode;
    } else {
      insert(_root, newNode);
    }
  }
  //recursive helper for insert(int)
  public void insert( TreeNode stRoot, TreeNode newNode )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    if (stRoot == null) {
      stRoot = newNode;
    } else if (stRoot.getValue() < newNode.getValue()){
      if (stRoot.getRight() != null) {
        insert(stRoot.getRight(), newNode);
      } else {
        stRoot.setRight(newNode);
      }
    } else if (stRoot.getValue() > newNode.getValue()) {
      if (stRoot.getLeft() != null) {
        insert(stRoot.getLeft(), newNode);
      } else {
        stRoot.setLeft(newNode);
      }
    }
  }//end insert()




  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

  // each traversal should simply print to standard out
  // the nodes visited, in order

  //process root, recurse left, recurse right
  public void preOrderTrav()
  {
    preOrderTrav( _root );
  }
  public void preOrderTrav( TreeNode currNode )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    if (currNode == null) {
      return;
    } else {
      System.out.println(currNode.getValue());
      preOrderTrav(currNode.getLeft());
      preOrderTrav(currNode.getRight());
    }
  }

  //recurse left, process root, recurse right
  public void inOrderTrav()
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    inOrderTrav(_root);
  }
  public void inOrderTrav( TreeNode currNode )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    if (currNode == null) {
      return;
    } else {
      inOrderTrav(currNode.getLeft());
      System.out.println(currNode.getValue());
      inOrderTrav(currNode.getRight());
    }
  }

  //recurse left, recurse right, process root
  public void postOrderTrav()
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    postOrderTrav(_root);
  }
  public void postOrderTrav( TreeNode currNode )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    if (currNode == null) {
      return;
    } else {
      postOrderTrav(currNode.getLeft());
      postOrderTrav(currNode.getRight());
      System.out.println(currNode.getValue());
    }
  }

  //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  //search, height, numLeaves

  /*****************************************************
   * TreeNode search(int)
   * returns pointer to node containing target,
   * or null if target not found
   *****************************************************/
  public TreeNode search( int target )
  {
  	/*** YOUR IMPLEMENTATION HERE ***/
    if (_root == null) {
      return null;
    } else if (_root.getValue() == target) {
      return _root;
    } else if (_root.getValue() > target && _root.getLeft() != null) {
      return search(_root.getLeft(), target);
    } else if (_root.getValue() < target && _root.getRight() != null) {
      return search(_root.getRight(), target);
    }
    return null;
  }

  public TreeNode search(TreeNode currNode, int target) {
    if (currNode == null) {
      return null;
    } else if (currNode.getValue() == target) {
      return currNode;
    } else if (currNode.getValue() > target && currNode.getLeft() != null) {
      return search(currNode.getLeft(), target);
    } else if (currNode.getValue() < target && currNode.getRight() != null) {
      return search(currNode.getRight(), target);
    }
    return null;
  }


  /*****************************************************
   * int height()
   * returns height of this tree (length of longest leaf-to-root path)
   * eg: a 1-node tree has height 1
   *****************************************************/
  //ask child for height, add one
  public int height()
  {
  	/*** YOUR IMPLEMENTATION HERE ***/
    int lHeight = 0;
    int rHeight = 0;
    if (_root == null) {
      return 0;
    } else if (_root.getLeft() != null) {
      lHeight = height(_root.getLeft()) + 1;
    } else if (_root.getRight() != null) {
      rHeight = height(_root.getRight()) + 1;
    } else {
      return 1;
    }
    if (lHeight > rHeight) {
      return lHeight;
    }
    return rHeight;
  }
  //helper method for height using a node as param
  public int height(TreeNode currNode) {
    int lHeight = 0;
    int rHeight = 0;
    if (currNode == null) {
      return 0;
    } else if (currNode.getLeft() != null) {
      lHeight = height(currNode.getLeft()) + 1;
    } else if (currNode.getRight() != null) {
      rHeight = height(currNode.getRight()) + 1;
    } else {
      return 1;
    }
    if (lHeight > rHeight) {
      return lHeight;
    }
    return rHeight - 1;
  }


  /*****************************************************
   * int numLeaves()
   * returns number of leaves in tree
   *****************************************************/
  public int numLeaves()
  {
  	/*** YOUR IMPLEMENTATION HERE ***/
    int lLeaves = 0;
    int rLeaves = 0;
    if (_root == null) {
      return 0;
    } else if (_root.getLeft() == null && _root.getRight() == null) {
      return 1;
    }
    if (_root.getLeft() != null) {
      lLeaves = numLeaves(_root.getLeft());
    }
    if (_root.getRight() != null){
      rLeaves = numLeaves(_root.getRight());
    }
    return lLeaves + rLeaves;
  }
  //helper method for numLeaves using node as param
  public int numLeaves(TreeNode currNode) {
    int lLeaves = 0;
    int rLeaves = 0;
    if (currNode == null) {
      return 0;
    } else if (currNode.getLeft() == null && currNode.getRight() == null) {
      return 1;
    }
    if (currNode.getLeft() != null) {
      lLeaves = numLeaves(currNode.getLeft());
    }
    if (currNode.getRight() != null) {
      rLeaves = numLeaves(currNode.getRight());
    }
    return lLeaves + rLeaves;
  }

  //remove method
  /*
  algo:
  2 vars, one for parent, one for child (named differently)
  traverse the child node down to what we want to remove
  check how many children the child has:
    first step in each case is to check if searcher is root by checking follower == null
    if so, we point root to parent's child
    no children:
    point parent's child node to null, which removes the child, freeing it up using the jgc

    1 child:
    check which child it is
    point parent's child node to child's child node

    2 children:
    temp var to traverse left subtree to find greatest node
    copy cargo from greatest node to node we want removed
    point child node above next greatest node to child
  */
  public TreeNode remove(int target) {
    TreeNode retVal;
    TreeNode follower = null;
    TreeNode searcher = _root;
    TreeNode tempF;
    TreeNode tempS;
    while (searcher.getValue() != target) {
      if (searcher.getValue() < target) {
        follower = searcher;
        searcher = searcher.getRight();
      } else {
        follower = searcher;
        searcher = searcher.getLeft();
      }
    }
    retVal = searcher;
    if (searcher.getLeft() == null && searcher.getRight() == null) {
      if (follower == null) {
        _root = null;
      }
      else if (follower.getLeft().equals(searcher)) {
        follower.setLeft(null);
      } else {
        follower.setRight(null);
      }
    } else if (searcher.getLeft() != null && searcher.getRight() != null) {
      tempF = searcher;
      tempS = searcher.getLeft();
      while (tempS.getRight() != null) {
        tempF = tempS;
        tempS = tempS.getRight();
      }
      if (tempS.getLeft() == null) {
        searcher.setValue(tempS.getValue());
        tempF.setRight(null);
      } else {
        searcher.setValue(tempS.getValue());
        tempF.setRight(tempS.getLeft());
      }
    } else if (searcher.getLeft() != null) {
      if (follower == null) {
        _root = _root.getLeft();
      }
      else if (follower.getLeft().equals(searcher)) {
        follower.setLeft(searcher.getLeft());
      } else {
        follower.setRight(searcher.getLeft());
      }
    } else {
      if (follower == null) {
        _root = _root.getRight();
      }
      else if (follower.getLeft().equals(searcher)) {
        follower.setLeft(searcher.getRight());
      } else {
        follower.setRight(searcher.getRight());
      }
    }
    return retVal;
  }

  /*
  public TreeNode removeSearch(TreeNode follower, TreeNode searcher, int target) {

  }
  */

  //toSting method
  /*
  public String toString() {
    String output = "";

  }
  */

  //main method for testing
  public static void main( String[] args ) {

  	BST arbol = new BST();

  	System.out.println( "tree init'd: " + arbol );

  	//inserting in this order will build a perfect tree
  	arbol.insert( 3 );
  	arbol.insert( 1 );
  	arbol.insert( 0 );
  	arbol.insert( 2 );
  	arbol.insert( 5 );
  	arbol.insert( 4 );
  	arbol.insert( 6 );
  	/*
  	*/

  	//insering in this order will build a linked list to left
  	/*
  	arbol.insert( 6 );
  	arbol.insert( 5 );
    arbol.insert( 4 );
  	arbol.insert( 3 );
  	arbol.insert( 2 );
  	arbol.insert( 1 );
  	arbol.insert( 0 );
  	*/

  	System.out.println( "tree after insertions:\n" + arbol );
  	System.out.println();

  	System.out.println();
  	for( int i=-1; i<8; i++ ) {
  	    System.out.println(" searching for "+i+": " + arbol.search(i) );
  	}

  	System.out.println();
  	System.out.println( arbol );
    arbol.inOrderTrav();

  	arbol.remove(6);
  	System.out.println();
    arbol.inOrderTrav();
  	//System.out.println( arbol );

  	arbol.remove(5);
  	System.out.println();
    arbol.inOrderTrav();
  	//System.out.println( arbol );

  	arbol.remove(4);
  	System.out.println();
    arbol.inOrderTrav();
  	//System.out.println( arbo );

  	arbol.remove(3);
  	System.out.println();
    arbol.inOrderTrav();
  	//System.out.println( arbol );

  	arbol.remove(2);
  	System.out.println();
    arbol.inOrderTrav();
  	//System.out.println( arbol );

  	arbol.remove(1);
  	System.out.println();
    arbol.inOrderTrav();
  	//System.out.println( arbol );

  	arbol.remove(0);
  	System.out.println();
    arbol.inOrderTrav();
  	//System.out.println( arbol );
  }

}//end class
