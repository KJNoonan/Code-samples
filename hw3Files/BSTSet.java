
/* ***********************************************************************
 * A simple BST with int keys and no values
 * 
 * Complete each function below.
 * Write each function as a separate recursive definition (do not use more than one helper per function).
 * Depth of root==0.
 * Height of leaf==0.
 * Size of empty tree==0.
 * Height of empty tree=-1.
 *************************************************************************/
public class BSTSet {
  private Node root;

  public BSTSet()
  {
    root = null;
  }

  /**
   * Methods for you to write. Each of these public methods should call
   * a recursive private method which you must also write.
   * 
   *
   *
   * 1. size - (This one is provided for you.) 
   * 2. height - height of the tree
   * 3. sizeOdd - number of Nodes with an odd key
   * 4. isPerfectlyBalancedS - at each Node, do left and right subtrees have same size?
   * 5. isPerfectlyBalancedH - at each Node, do left and right subtrees have same height?
   * 6. isOddBalanced - at each Node, do left and right subtrees contain the same number of odd keys?
   * 7. isSemiBalancedI - is each Node semibalanced? leaf or else size(larger child) / size (smaller child) <= 2
   * 8. sizeAtDepth - number of nodes at a given depth
   * 9. sizeLessThanDepth - number of nodes whose depth is < a given depth
   * 10. sizeGreaterThanDepth - number of nodes whose dept is > a given depth
   *
   * 11. removeOddSubtrees - remove subtrees whose root has an odd key
   * 12. removeLeaves - remove the leaves from the original tree
   * 13. removeSingles - remove nodes with exactly 1 child by replacing with its child
   * 14. removeDepthGreater - remove all subtrees whose dept is > given depth
   * 15. addZeroToSingles - For each node with just one child add key 0 as the other child
   * 16. sizeAtHeight - number of nodes which have a given height
   * 17. sizeLessThanHeight - number of nodes with height < a given height
   * 18. sizeGreaterThanHeight - number of nodes with height > a given height
   * 19. removeHeight - remove all subtrees with the given height in the original tree 
   */

  /**
   * 1. size
   * Returns the number of keys in this BSTset
   * @return number of keys
   */
  public int size()
  {
    return size(root);
  }
  /**
   * Returns the number of keys in the subtree at Node t
   * @param t node in the tree
   * @return the size of the subtree at t
   */
  private int size(Node t)
  {
    if (t == null) {
      return 0;
    }
    return size(t.right) + size(t.left) + 1;
  }


  /** 
   * 2. height - height of the tree
   */
  public int height()
  {
    // NOT YET IMPLEMENTED
    return 0;
  }
  /** 
   * 3. sizeOdd - number of Nodes with an odd key
   */
  public int sizeOdd()
  {
    // NOT YET IMPLEMENTED
    return 0;
  }
  /** 
   * 4. isPerfectlyBalancedS - at each Node, do left and right subtrees have same size?
   */
  public boolean isPerfectlyBalancedS()
  {
    // NOT YET IMPLEMENTED
    return false;
  }
  /**
   * 5. isPerfectlyBalancedH - at each Node, do left and right subtrees have same height?
   */
  public boolean isPerfectlyBalancedH()
  {
    // NOT YET IMPLEMENTED
    return false;
  }
  /**
   * 6. isOddBalanced - at each Node, do left and right subtrees contain the same number of odd keys?
   */
  public boolean isOddBalanced()
  {
    // NOT YET IMPLEMENTED
    return false;
  }
  /**
   * 7. isSemiBalancedI - is each Node semibalanced? leaf or else size(larger child) / size (smaller child) <= 2
   * Note: The condition is NOT equivalent to size(larger child) <= 2 * size(smaller child)
   */
  public boolean isSemiBalancedI()
  {
    // NOT YET IMPLEMENTED
    return false;
  }
  /**
   * 8. sizeAtDepth - number of nodes whose depth is k
   * @param k a given depth 
   */
  public int sizeAtDepth(int k)
  {
    // NOT YET IMPLEMENTED
    return 0;
  }
  /**
   * 9. sizeLessThanDepth - number of nodes whose depth is < k
   * @param k a given depth
   */
  public int sizeLessThanDepth(int k)
  {
    // NOT YET IMPLEMENTED
    return 0;
  }
  /**
   * 10. sizeGreaterThanDepth - number of nodes whose depth is > k
   * @param k a given depth
   */
  public int sizeGreaterThanDepth(int k)
  {
    // NOT YET IMPLEMENTED
    return 0;
  }
  /**
   * 11. removeOddSubtrees - remove subtrees whose root has an odd key
   */
  public void removeOddSubtrees()
  {
    // NOT YET IMPLEMENTED
  }
  /**
   * 12. removeLeaves - remove the leaves from the original tree
   */
  public void removeLeaves()
  {
    // NOT YET IMPLEMENTED
  }
  /**
   * 13. removeSingles - remove nodes with exactly 1 child by replacing with its child
   */
  public void removeSingles()
  {
    // NOT YET IMPLEMENTED
  }
  /**
   * 14. removeDepthGreater - remove all subtrees whose dept is > k
   * @param a given depth
   */
  public void removeDepthGreaterThan(int k)
  {
    // NOT YET IMPLEMENTED
  }
  /**
   * 15. addZeroToSingles - For each node with just one child add key 0 as the other child
   */
  public void addZeroToSingles()
  {
    // NOT YET IMPLEMENTED
    
  }
    /**
   * 16. sizeAtHeight - number of nodes which have height equal to h
   * @param a given height
   */
  public int sizeAtHeight(int h)
  {
    // NOT YET IMPLEMENTED
    return 0;
  }
  /**
   * 17. sizeLessThanHeight - number of nodes with height < h
   * @param h a given height
   */
  public int sizeLessThanHeight(int h)
  {
    // NOT YET IMPLEMENTED
    return 0;
  }
  /**
   * 18. sizeGreaterThanHeight - number of nodes with height > h
   * @param h a given height
   */
  public int sizeGreaterThanHeight(int h)
  {
    // NOT YET IMPLEMENTED
    return 0;
  }
  /**
   * 19. removeHeight - remove all subtrees with height h in the original tree
   * @param h a given height
   */
  public void removeHeight(int h)
  {
    // NOT YET IMPLEMENTED
  }
  /*
   */


  //*************************************************************  
  //    The following methods are implemented. You need not
  //    change these methods.
  //*************************************************************


  /**
   * Adds the key x to this BSTset
   * @param x
   */
  public void put(int x)
  {
    root = put(root, x);
  }
  /**
   * Adds the key x to the subtree at t
   * @param t
   * @param x
   * @return the possibly new root after inserting x in the
   * subtree at t
   */
  private Node put(Node t, int x)
  {
    if (t == null) {
      t = new Node(x);
      return t;
    }
    if (x < t.key) {
      t.left = put(t.left, x);
    } else if (x > t.key) {
      t.right = put(t.right, x);
    } else {
      // nothing; no duplicate keys allowed
    }
    return t;
  }
  /**
   * Returns a new BSTSet with keys from the string s
   * @param s
   * @return
   */
  public static BSTSet fromString(String s)
  {
    String[] keys = s.split("\\s+");
    BSTSet set = new BSTSet();
    for(int i = 0; i < keys.length; i++) {
      try {
        int x = Integer.parseInt(keys[i]);
        set.put(x);
      } catch(NumberFormatException e) {
        // skip this key
      }
    }
    return set;
  }

  public void drawTree() {
    if (root != null) {
      StdDraw.setPenColor (StdDraw.BLACK);
      //      StdDraw.setCanvasSize(1200,700);
      drawTree(root, .5, 1, .30, 0);
    }
  }
  private void drawTree (Node n, double x, double y, double range, int depth) {
    final int CUTOFF = 6;
    StdDraw.text (x, y, Integer.toString (n.key));
    StdDraw.setPenRadius (.007);
    if (n.left != null && depth != CUTOFF) {
      StdDraw.line (x-range, y-.13, x-.01, y-.01);
      drawTree (n.left, x-range, y-.15, range*.5, depth+1);
    }
    if (n.right != null && depth != CUTOFF) {
      StdDraw.line (x+range, y-.13, x+.01, y-.01);
      drawTree (n.right, x+range, y-.15, range*.5, depth+1);
    }
  }

  private class Node
  {
    private int key;
    private Node left, right;
    private Node(int k)
    {
      key = k;
      left = right = null;
    }
  }
  
  // Do not modify levelOrder()
  public Iterable<Integer> levelOrder()
  {
    Queue<Integer> q = new Queue<Integer>();
    Queue<Node> qnodes = new Queue<Node>();
    if (root != null) {
      qnodes.enqueue(root);
    }
    while(!qnodes.isEmpty()) {
      Node p = qnodes.dequeue();
      q.enqueue(p.key);
      if (p.left != null) {
        qnodes.enqueue(p.left);
      }
      if (p.right != null) {
        qnodes.enqueue(p.right);
      }
    }
    return q;
  }

  // Do not modify "toString"
  public String toString() {
      StringBuilder sb = new StringBuilder();
      for (int key: levelOrder())
          sb.append (key + " ");
      return sb.toString ();
  }
  public static void main(String[] args)
  {
    StdDraw.setCanvasSize(1200,700);
    BSTSet set = BSTSet.fromString("40 60 70 50 20 10 30 35");
    set.drawTree();
    StdDraw.show();


  }
}
