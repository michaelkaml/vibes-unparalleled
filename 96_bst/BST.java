// Big Bird :: Raven (Ruiwen) Tang, Jun Hong Wang, Michael Kamela
// APCS pd6
// HW96 -- BSTs is the Perfect Place for Shade
// 2022-05-10t
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
    return rHeight;
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


  //main method for testing
  public static void main( String[] args )
  {

    BST arbol = new BST();

    //PROTIP: sketch state of tree after each insertion
    //        ...BEFORE executing these.
    arbol.insert( 4 );
    arbol.insert( 2 );
    arbol.insert( 5 );
    arbol.insert( 6 );
    arbol.insert( 1 );
    arbol.insert( 3 );

    System.out.println( "\n-----------------------------");
    System.out.println( "pre-order traversal:" );
    arbol.preOrderTrav();

    System.out.println( "\n-----------------------------");
    System.out.println( "in-order traversal:" );
    arbol.inOrderTrav();

    System.out.println( "\n-----------------------------");
    System.out.println( "post-order traversal:" );
    arbol.postOrderTrav();

    System.out.println( "\n-----------------------------");
    /*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    //extra test cases:
    System.out.println("before 0 inserted:" + arbol.height());
    arbol.insert( 0 );
    System.out.println("after 0 inserted:" + arbol.height() + "\n");

    //how many leaves? (3 expected)
    System.out.println("there are " + arbol.numLeaves() + " leaves in arbol");
    arbol.insert( 8 );
    arbol.insert( 7 );
    System.out.println("there are " + arbol.numLeaves() + " leaves in arbol"); //3 expected

    //testing search method by finding out if the left and right children are right
    TreeNode two = arbol.search(2);
    System.out.println(two.getLeft().getValue()); //should print 1
    System.out.println(two.getRight().getValue() + "\n"); //should print 3

    TreeNode three = arbol.search(3);
    //System.out.println(three.getLeft().getValue()); //should print null (or give nullpointerexception)
    //System.out.println(three.getRight().getValue() + "\n"); //should print null (or give nullpointerexception)

    TreeNode four = arbol.search(4);
    System.out.println(four.getLeft().getValue()); //should print 2
    System.out.println(four.getRight().getValue()); //should print 5
  }

}//end class
