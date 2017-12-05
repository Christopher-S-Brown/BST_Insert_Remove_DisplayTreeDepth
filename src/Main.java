public class Main {
  
  /*
    This is the default output of the BST with no calls to remove():
        Depth 0: 7
        Depth 1: 3 9
        Depth 2: 1 6 8 11
        Depth 3: 4 10 13
        Depth 4: 5 17
        Depth 5: 21
        
        Default Tree View:
                          7
                 ------------------
                 |                |
                 3                9
             ----------       ----------
             |        |       |        |
             1        6       8        11
                   ----             --------
                   |                |      |
                   4                10     13
                   --                      ----
                    |                         |
                    5                         17
                                              ----
                                                 |
                                                 21
                                                   
   */
  
  public static void main(String args[]) {
    BinarySearchTree<Integer> bst = new BinarySearchTree<>();
    bst.insert(new Node<>(7));
    bst.insert(new Node<>(9));
    bst.insert(new Node<>(3));
    bst.insert(new Node<>(1));
    bst.insert(new Node<>(8));
    bst.insert(new Node<>(6));
    bst.insert(new Node<>(11));
    bst.insert(new Node<>(13));
    bst.insert(new Node<>(10));
    bst.insert(new Node<>(4));
    bst.insert(new Node<>(5));
    bst.insert(new Node<>(17));
    bst.insert(new Node<>(21));
    
    /*
     * Test Removing elements
     *  Note: Uncomment each of these test cases one at a time and run the program to verify removal functionality
     */
    
    // Case 1: Remove Leaf Node
    
    // Test #1
    //bst.remove(new Node<>(10));
    
    // Test #2
    //bst.remove(new Node<>(21));
  
  
    // Case 2: Remove Node with 1 Child (left or Right)
  
    // Test #3
    //bst.remove(new Node<>(6));
  
    // Test #4
    //bst.remove(new Node<>(13));
    
    
    // Case 3: Remove Node with 2 Children
  
    // Test #5
    // Promote 4 to replace 3
    //bst.remove(new Node<>(3));
  
    // Test #6
    // Promote 10 to replace 9
    //bst.remove(new Node<>(9));
  
    // Test #7
    // Promote 13 to replace 11
    //bst.remove(new Node<>(11));
  
    // Test #8
    // Promote 8 to the root node
    //bst.remove(new Node<>(7));
    
    // Display all nodes at each depth level
    bst.displayEachTreeDepth();
  }
}
