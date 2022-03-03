
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
        adj = new ArrayList<>(n);
        color = new ArrayList<>(n);
        distance = new ArrayList<>(n);
        parent = new ArrayList<>(n);
        discoverTime = new ArrayList<>(n);
        finishTime = new ArrayList<>(n);
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
     * AND ALSO DON'T FORGET ABOUT THE VERTICES SMH
     * 
     * @return whether the graph is empty
     */
    public boolean isEmpty() {
        return (edges == 0 && vertices == 0);
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
        if (v < 0 && v > vertices) {
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
        if (v < 0 && v > vertices && (u < 0 && u > vertices)) {
            throw new IndexOutOfBoundsException("addDirectedEdge(): Either u or v is out of bounds!"); // yes
        }
        this.adj.get(u).addLast(v); // ???
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
        if (v < 0 && v > vertices && (u < 0 && u > vertices)) {
            throw new IndexOutOfBoundsException("addDirectedEdge(): Either u or v is out of bounds!"); // yes
        }

        this.adj.get(u).addLast(v); // ???
        this.adj.get(v).addLast(u); // ???
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
        for (int i = 1; i < this.vertices; i++) {

        }

        return str + "\n";
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
        if (source < 0 && source > vertices) {
            throw new IndexOutOfBoundsException(
                    "BFS(): Source is either negative or is greater than number of vertices!");
        }

        LinkedList<Integer> queue = new LinkedList<>();

        for (int x = 1; x <= this.vertices; x++) {
            this.color.add(x, 'W');
            this.distance.add(x, -1);
            this.parent.add(x, null);
        }

        this.color.add(source, 'G');
        this.distance.add(source, 0);
        queue.addFirst(source);
        while (!queue.isEmpty()) {
            int x = queue.getFirst();
            queue.removeFirst();
            for (int i = 0; i < this.adj.get(x).getLength(); i++) {
                if (this.color.get(this.adj.get(x).findIndex(i)).equals('W')) {
                    this.color.set(this.adj.get(x).findIndex(i), 'G');
                    this.parent.set(this.adj.get(x).findIndex(i), x);
                    this.distance.set(this.adj.get(x).findIndex(i), this.distance.get(x) + 1);
                    queue.addLast(this.adj.get(x).findIndex(i));
                }
            }
            this.color.set(x, 'B');
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
        /**
         * FS(G)
         * 
         * for all x in V(G)
         * 
         * color[x] = W
         * 
         * parent[x] = NIL
         * 
         * discovery_time[x] = -1
         * 
         * finish_time[x] = -1
         * 
         * time = 0
         * 
         * for all x in V(G)
         * 
         * if color[x] == W
         * 
         * Visit(x)
         * 
         * 
         * 
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

    /**
     * Private recursive helper method for DFS
     * 
     * @param vertex the vertex to visit
     */
    private void visit(int vertex) {

    }

}
