#Bidirectional Maze Search
##About
A bidirectional maze searching algorithm implemented in Java for a university assignment. The original maze problem has been adapted from [Algorithms 4th Edition (Robert Sedgewick and Kevin Wayne)](http://algs4.cs.princeton.edu/41undirected/Maze.java.html) along with the [maze visualization](http://algs4.cs.princeton.edu/41undirected/StdDraw.java).

Nodes are expanded from both the start and end points based on the lowest number of nodes within a frontier. The aim is to reduce the number of total expansions made. A front-to-back heuristic is used to speed up the search process.

##Usage
``` shell
javac */*.java
java search.BidirectionalSearch 50 10
```

Where 50 is the maze dimension and 10 is the number of walls deleted (max maze dimension is around 120).
