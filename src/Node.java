public class Node<K extends Comparable<K>> {
  public K value;
  public Node left;
  public Node right;
  
  public Node(final K v) {
    value = v;
    left = null;
    right = null;
  }
}
