
/**
 * Graph.java
 * @author Sam Yadav
 * @author Sol Valdimarsdottir
 * CIS 22C, Lab 6
 */

import java.util.ArrayList;

public class Graph {
    private int vertices;
    private int edges;
    private ArrayList<LinkedList<Integer>> adj;
    private ArrayList<Character> color;
    private ArrayList<Integer> distance;
    private ArrayList<Integer> parent;
    private ArrayList<Integer> discoverTime;
    private ArrayList<Integer> finishTime;
    private static int time = 0;

    /** Constructors and Destructors */

    /**
     * initializes an empty graph, with n vertices
     * and 0 edges
     * 
     * @param n the number of vertices in the graph
     */
    public Graph(int n) {
        this.vertices = n;
        this.edges = 0;
        this.adj = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            this.adj.add(new LinkedList<>());
        }
        this.color = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            this.color.add('W');
        }
        this.distance = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            this.distance.add(-1);
        }
        this.parent = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            this.parent.add(0); // should be null I(sam) think
        }
        this.discoverTime = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            this.discoverTime.add(-1);
        }
        this.finishTime = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            this.finishTime.add(-1);
        }
    }

    /*** Accessors ***/

    /**
     * Returns the number of edges in the graph
     * 
     * @return the number of edges
     */
    public int getNumEdges() {
        return this.edges;
    }

    /**
     * Returns the number of vertices in the graph
     * 
     * @return the number of vertices
     */
    public int getNumVertices() {
        return this.vertices;
    }

    /**
     * returns whether the graph is empty (no edges)
     * 
     * @return whether the graph is empty
     */
    public boolean isEmpty() {
        return this.edges == 0;
    }

    /**
     * Returns the value of the distance[v]
     * 
     * @param v a vertex in the graph
     * @precondition 0 < v <= vertices
     * @return the distance of vertex v
     * @throws IndexOutOfBoundsException when
     *                                   v is out of bounds
     */
    public Integer getDistance(Integer v) throws IndexOutOfBoundsException {
        if (v < 0 && v > this.vertices) {
            throw new IndexOutOfBoundsException(
                    "getDistance(): Vertex is either negative or is greater than number of vertices!");
        }
        return this.distance.get(v);
    }

    /**
     * Returns the value of the parent[v]
     * 
     * @param v a vertex in the graph
     * @precondition 0 < v <= vertices
     * @return the parent of vertex v
     * @throws IndexOutOfBoundsException when
     *                                   v is out of bounds
     */
    public Integer getParent(Integer v) throws IndexOutOfBoundsException {
        if (v > this.vertices || v < 0) {
            throw new IndexOutOfBoundsException(
                    "getParent(): Vertex is either negative or is greater than number of vertices!");
        }

        return this.parent.get(v) == null ? -1 : this.parent.get(v);
    }

    /**
     * Returns the value of the color[v]
     * 
     * @param v a vertex in the graph
     * @precondition 0 < v <= vertices
     * @return the color of vertex v
     * @throws IndexOutOfBoundsException when
     *                                   v is out of bounds
     */
    public Character getColor(Integer v) throws IndexOutOfBoundsException {
        if (v < 0 && v > vertices) {
            throw new IndexOutOfBoundsException(
                    "getColor(): Vertex is either negative or is greater than number of vertices!");
        }
        return this.color.get(v);
    }

    /**
     * Returns the value of the discoverTime[v]
     * 
     * @param v a vertex in the graph
     * @precondition 0 < v <= vertices
     * @return the discover time of vertex v
     * @throws IndexOutOfBoundsException when
     *                                   v is out of bounds
     */
    public Integer getDiscoverTime(Integer v) throws IndexOutOfBoundsException {
        if (v < 0 && v > vertices) {
            throw new IndexOutOfBoundsException(
                    "getDiscoverTime(): Vertex is either negative or is greater than number of vertices!");
        }
        return this.discoverTime.get(v);
    }

    /**
     * Returns the value of the finishTime[v]
     * 
     * @param v a vertex in the graph
     * @precondition 0 < v <= vertices
     * @return the finish time of vertex v
     * @throws IndexOutOfBoundsException when
     *                                   v is out of bounds
     */
    public Integer getFinishTime(Integer v) throws IndexOutOfBoundsException {
        if (v < 0 && v > this.vertices) {
            throw new IndexOutOfBoundsException(
                    "getFinishTime(): Vertex is either negative or is greater than number of vertices!");
        }
        return this.finishTime.get(v);
    }

    /**
     * Returns the LinkedList stored at index v
     * 
     * @param v a vertex in the graph
     * @return the adjacency LinkedList a v
     * @precondition 0 < v <= vertices
     * @throws IndexOutOfBoundsException when
     *                                   v is out of bounds
     */
    public LinkedList<Integer> getAdjacencyList(Integer v) throws IndexOutOfBoundsException {
        if (v <= 0 || v > vertices) {
            throw new IndexOutOfBoundsException(
                    "getAdjacencyList(): Vertex is either negative or is greater than number of vertices!");
        }
        return this.adj.get(v);

    }

    /*** Manipulation Procedures ***/

    /**
     * Inserts vertex v into the adjacency list of vertex u
     * (i.e. inserts v into the list at index u)
     * @precondition, 0 < u, v <= vertices
     * 
     * @throws IndexOutOfBounds exception when
     *                          u or v is out of bounds
     */
    public void addDirectedEdge(Integer u, Integer v) throws IndexOutOfBoundsException {
        if (v > vertices || u <= 0 || u > vertices || v <= 0) {
            throw new IndexOutOfBoundsException("addDirectedEdge(): Either u or v is out of bounds!"); // yes
        }

        this.adj.get(u).addLast(v); // ???
        this.edges++;
    }

    /**
     * Inserts vertex v into the adjacency list of vertex u
     * (i.e. inserts v into the list at index u)
     * and inserts u into the adjacent vertex list of v
     * @precondition, 0 < u, v <= vertices
     * 
     * @throws IndexOutOfBoundsException when
     *                                   u or v is out of bounds
     */
    public void addUndirectedEdge(Integer u, Integer v) throws IndexOutOfBoundsException {
        if (v > vertices || u <= 0 || u > vertices || v <= 0) {
            throw new IndexOutOfBoundsException("addUndirectedEdge(): Either u or v is out of bounds!"); // yes
        }

        this.adj.get(u).addLast(v); // ???
        this.adj.get(v).addLast(u); // ???
        this.edges++;
    }

    /*** Additional Operations ***/

    /**
     * Creates a String representation of the Graph
     * Prints the adjacency list of each vertex in the graph,
     * vertex: <space separated list of adjacent vertices>
     */
    @Override
    public String toString() {
        String str = "";
        for (int i = 1; i <= this.vertices; i++) {
            str += i + ": " + this.adj.get(i).toString();
        }

        return str;
    }

    /**
     * Performs breath first search on this Graph give a source vertex
     * 
     * @param source the starting vertex
     * @precondition source is a vertex in the graph
     * @throws IndexOutOfBoundsException when the source vertex
     *                                   is out of bounds of the graph
     */

    public void BFS(Integer source) throws IndexOutOfBoundsException {
        if (source <= 0 || source > vertices) {
            throw new IndexOutOfBoundsException(
                    "BFS(): Source is either negative or is greater than number of vertices!");
        }

        LinkedList<Integer> queue = new LinkedList<>();

        this.color.set(source, 'G');
        this.distance.set(source, 0); // default values for source value
        queue.addFirst(source); // add source onto Queue
        while (!queue.isEmpty()) {
            int x = queue.getFirst();

            queue.removeFirst(); // removing what's in front to left the next value after
            LinkedList<Integer> currAdjList = this.adj.get(x); // getting adj list of x
            for (int i = 0; i < currAdjList.getLength(); i++) {

                currAdjList.positionIterator();
                currAdjList.advanceIteratorToIndex(i); // advances to the current iteration, continuing the for loop
                int adjNode = currAdjList.getIterator(); // find the adjacent node, by getting the iterator at the index
                                                         // currently on

                if (this.color.get(adjNode).equals('W')) { // if adj is white
                    this.color.set(adjNode, 'G');
                    this.parent.set(adjNode, x);
                    this.distance.set(adjNode, this.distance.get(x) + 1);
                    queue.addLast(adjNode);
                }
            }
            this.color.set(x, 'B'); // once adj list is looped through, and none of the values are W, we mark x as B
        }
    }
    // for all x in V(G)

    // color[x] = white

    // distance[x] = -1

    // parent[x] = Nil

    // color[s] = grey

    // distance[s] = 0

    // Enqueue(Q,s)

    // while(Q is not empty)

    // x = front of Q

    // Dequeue(Q,x)

    // for all y in adj[x]

    // if color[y] == white

    // color[y] = grey

    // distance[y] = distance[x] + 1

    // parent[y] = x

    // Enqueue(Q, y)

    // color[x] = black
    // }

    /**
     * Performs depth first search on this Graph
     * in order of vertex lists
     */
    public void DFS() {
        for (int i = 0; i <= this.vertices; i++) {
            if (this.color.get(i).equals('W')) {
                this.visit(i);
            }
        }
    }

    /**
     * Private recursive helper method for DFS
     * 
     * @param vertex the vertex to visit
     */
    private void visit(int vertex) {
        this.color.set(vertex, 'G');
        this.discoverTime.set(vertex, ++time);

        LinkedList<Integer> currAdjList = this.adj.get(vertex); // getting adj list of x
        for (int i = 0; i < currAdjList.getLength(); i++) {

            currAdjList.positionIterator();
            currAdjList.advanceIteratorToIndex(i); // advances to the current iteration, continuing the for loop
            int adjNode = currAdjList.getIterator(); // find the adjacent node, by getting the iterator at the index
                                                     // currently on

            if (this.color.get(adjNode).equals('W')) { // if adj is white
                this.parent.set(adjNode, vertex);
                this.visit(adjNode);
            }
        }

        this.color.set(vertex, 'B');
        this.finishTime.set(vertex, ++time);

        /*
         * Visit(x)
         * 
         * color[x] = G
         * 
         * discover[x] = ++time
         * 
         * for all y in adj[x]
         * 
         * if color[y] == W
         * 
         * parent[y] = x
         * 
         * Visit(y)
         * 
         * color[x] = B
         * 
         * finish[x] = ++time
         * 
         * 
         * 
         */

    }

    public static void main(String[] args) {
        Graph g1 = new Graph(8);
        g1.addUndirectedEdge(1, 2);
        g1.addUndirectedEdge(1, 3);
        g1.addUndirectedEdge(2, 4);
        g1.addUndirectedEdge(3, 4);
        g1.addUndirectedEdge(5, 6);
        g1.addUndirectedEdge(6, 7);
        g1.addUndirectedEdge(6, 8);
        g1.DFS();
        // for (int index = 1; index < g.getNumVertices(); index++) {
        // System.out.printf("%d: %d\n", index, g.getDistance(index));
        // }
        System.out.println("Discover:");
        for (int index = 1; index < g1.getNumVertices(); index++) {
            System.out.printf("%d: %d\n", index, g1.getDiscoverTime(index));
        }
        System.out.println("Finnish:");
        for (int index = 1; index < g1.getNumVertices(); index++) {
            System.out.printf("%d: %d\n", index, g1.getFinishTime(index));
        }
    }

}
