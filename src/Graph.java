
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

    }

    /*** Accessors ***/

    /**
     * Returns the number of edges in the graph
     * 
     * @return the number of edges
     */
    public int getNumEdges() {

    }

    /**
     * Returns the number of vertices in the graph
     * 
     * @return the number of vertices
     */
    public int getNumVertices() {

    }

    /**
     * returns whether the graph is empty (no edges)
     * 
     * @return whether the graph is empty
     */
    public boolean isEmpty() {

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

    }

    /*** Additional Operations ***/

    /**
     * Creates a String representation of the Graph
     * Prints the adjacency list of each vertex in the graph,
     * vertex: <space separated list of adjacent vertices>
     */
    @Override
    public String toString() {

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

    }

    /**
     * Performs depth first search on this Graph
     * in order of vertex lists
     */
    public void DFS() {

    }

    /**
     * Private recursive helper method for DFS
     * 
     * @param vertex the vertex to visit
     */
    private void visit(int vertex) {

    }

}
