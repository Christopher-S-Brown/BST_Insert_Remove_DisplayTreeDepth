The idea behind this project was to show that recursive calls can be used to display each depth of a BST.

After all of the inserts this is the tree view:
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


The depth output for the above tree looks like this:
Depth 0: 7
Depth 1: 3 9
Depth 2: 1 6 8 11
Depth 3: 4 10 13
Depth 4: 5 17
Depth 5: 21

Please note the method calls displayEachTreeDepth() and displayTreeDepth() in BinarySearchTree.java.  The method displayTreeDepth() is called recursively to reach the desired depth of each branch, if such a depth exists.


