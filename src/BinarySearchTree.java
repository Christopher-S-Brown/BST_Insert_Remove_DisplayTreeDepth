/*
 * A B-Tree is a more generalized form of BST in which a node may have more than two children
 *
 * A BST is a tree where each node has only 0 - 2 children and each node to the left is <= to
 *    the parent node, while each node to the right is > the parent node
 *
 * Note: I haven't implemented a method to rebalance the Binary Search Tree (BST) just yet
 */
public class BinarySearchTree<K extends Comparable<K>> {
  private Node<K> root = null;
  
  public void insert(Node<K> node) {
    if(root == null) {
      // First Addition
      root = node;
    }
    else {
      recursivelyInsertNode(node, root);
    }
  }
  
  private void recursivelyInsertNode(Node<K> insertNode,
                                     Node<K> currentNode) {
    // Left Side
    if(insertNode.value.compareTo(currentNode.value) <= 0) {
      if(currentNode.left == null) {
        currentNode.left = insertNode;
        insertNode.left = null;
        insertNode.left = null;
      }
      else {
        recursivelyInsertNode(insertNode, currentNode.left);
      }
    }
    // Right Side
    else {
      if(currentNode.right == null) {
        currentNode.right = insertNode;
        insertNode.right = null;
        insertNode.right = null;
      }
      else {
        recursivelyInsertNode(insertNode, currentNode.right);
      }
    }
  }
  
  /*
   * For removal there are three cases we need to cover:
   *    1) Remove a leaf node with no children
   *      - Simply point the parent (left/right) pointer to null
   *    2) Remove a node with only 1 child
   *      - Simply point the parent (left/right) pointer to the child node
   *    3) Remove a node with 2 children
   *      - Find the smallest value in the right sub-tree (Or conversely the largest value in the left sub-tree) and
   *        replace the nodeToRemove with that node
   */
  public void remove(Node<K> node) {
    removeNode(null, root, node);
  }
  
  private void removeNode(Node<K> parent,
                          Node<K> node,
                          Node<K> nodeToRemove) {
    if(nodeToRemove.value.compareTo(node.value) == 0) {
      // Found the node, now determine how to remove it
      if(node.left == null && node.right == null) {
        // Case 1
        if(node.value.compareTo(parent.value) <= 0) {
          parent.left = null;
        }
        else {
          parent.right = null;
        }
      }
      else if(node.left == null) {
        // Case 2 right != null
        if(node.value.compareTo(parent.value) <= 0) {
          parent.left = node.right;
        }
        else {
          parent.right = node.right;
        }
      }
      else if(node.right == null) {
        // Case 2 left != null
        if(node.value.compareTo(parent.value) <= 0) {
          parent.left = node.left;
        }
        else {
          parent.right = node.left;
        }
      }
      else {
        // Case 3
        // Find the smallest value in the right sub-tree
        // Loop through the left portion of the right sub-tree until we find the smallest value
        Node<K> parentNode = null;
        Node<K> currentNode = node.right;
        while(currentNode.left != null) {
          parentNode = currentNode;
          currentNode = currentNode.left;
        }
        // We found the smallest item in the right sub-tree
        if(parent == null) {
          // We removed the root tree element
          root = currentNode;
        }
        else {
          // If the parent is not null then we're not removing the root element
          if (node.value.compareTo(parent.value) <= 0) {
            parent.left = currentNode;
          } else {
            parent.right = currentNode;
          }
        }
        currentNode.left = node.left;
        // Need to set currentNode.right.  By definition it won't have a left node since this is the smallest node in the sub-tree
        if(parentNode != null) {
          parentNode.left = currentNode.right;
          currentNode.right = node.right;
        }
      }
    }
    else if(nodeToRemove.value.compareTo(node.value) < 0) {
      // Traverse left
      if(node.left == null) {
        // Error, we couldn't find the node to remove
        throw new RuntimeException("Non-existent Node value: " + nodeToRemove.value);
      }
      removeNode(node, node.left, nodeToRemove);
    }
    else {
      // Traverse right
      if(node.right == null) {
        // Error, we couldn't find the node to remove
        throw new RuntimeException("Non-existent Node value: " + nodeToRemove.value);
      }
      removeNode(node, node.right, nodeToRemove);
    }
  }
  
  /*
   * Begins the process of recursively calling each depth of the tree until it reaches a depth with no nodes
   */
  public void displayEachTreeDepth() {
    // Recursively loop through each depth until we find a depth with no nodes
    if(root == null) {
      System.out.println("Depth 0: N/A");
      return;
    }
    
    String finalOutput = new String();
    StringBuilder output;
    int x = 0;
    do {
      output = new StringBuilder();
      displayTreeDepth(x, root, output);
      
      if(output.length() > 0) {
        finalOutput = finalOutput.concat("Depth " + x + ": " + output + "\n");
      }
      
      x++;
    } while(output.length() > 0);
    
    System.out.println(finalOutput);
  }
  
  /*
   * Recursively called to find the desired depth of the tree, displaying the nodes from left to right for the given
   *  depth.
   */
  private void displayTreeDepth(final int depth,
                                final Node<K> node,
                                StringBuilder output) {
    if (depth == 0) {
      output.append(node.value + " ");
    } else {
      int newDepth = depth - 1;
      if(node.left != null)
        displayTreeDepth(newDepth, node.left, output);
      if(node.right != null)
        displayTreeDepth(newDepth, node.right, output);
    }
  }
}
