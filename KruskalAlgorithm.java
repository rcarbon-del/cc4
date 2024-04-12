import java.util.*;

class Edge implements Comparable<Edge> {
    String srcStr, destStr;
    int srcInt, destInt, weight;
    
    public Edge(String src, String dest, int weight, boolean isString) {
        if (isString) {
            this.srcStr = src;
            this.destStr = dest;
        } else {
            this.srcInt = Integer.parseInt(src);
            this.destInt = Integer.parseInt(dest);
        }
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

class Graph {
    private int V, E;
    private List<Edge> edges;
    private String[] verticesStr;
    private Map<String, Integer> vertexIndices;
    
    public Graph(int V, int E) {
        this.V = V;
        this.E = E;
        edges = new ArrayList<>();
        verticesStr = new String[V];
        vertexIndices = new HashMap<>();
    }
    
    public void addEdge(String src, String dest, int weight, boolean isString) {
        edges.add(new Edge(src, dest, weight, isString));
    }
    
    public void displayAdjMatrix() {
        // Create a 2D array to represent the adjacency matrix
        int[][] adjMatrix = new int[V][V];

        // Populate the adjacency matrix
        for (Edge edge : edges) {
            int srcIndex, destIndex;
            if (edge.srcStr != null) {
                srcIndex = vertexIndices.get(edge.srcStr);
                destIndex = vertexIndices.get(edge.destStr);
            } else {
                srcIndex = edge.srcInt;
                destIndex = edge.destInt;
            }
            adjMatrix[srcIndex][destIndex] = 1;
            adjMatrix[destIndex][srcIndex] = 1;
        }

        // Print the vertices labels horizontally in ascending order
        System.out.print("  ");
        for (int i = 0; i < V; i++) {
            System.out.print(verticesStr[i] + " ");
        }
        System.out.println();

        // Print the adjacency matrix
        for (int i = 0; i < V; i++) {
            System.out.print(verticesStr[i] + " ");
            for (int j = 0; j < V; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    private int find(int[] parent, int i) {
        if (parent[i] == i) return i;
        return find(parent, parent[i]);
    }
    
    private void union(int[] parent, int[] rank, int x, int y) {
        int xRoot = find(parent, x);
        int yRoot = find(parent, y);
        
        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else if (rank[yRoot] < rank[xRoot]) {
            parent[yRoot] = xRoot;
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot]++;
        }
    }
    
    public int kruskalMST() {
        Collections.sort(edges);
        int[] parent = new int[V];
        int[] rank = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        
        int minCost = 0;
        List<Edge> mst = new ArrayList<>();
        
        for (Edge edge : edges) {
            int srcIndex, destIndex;
            if (edge.srcStr != null) {
                srcIndex = vertexIndices.get(edge.srcStr);
                destIndex = vertexIndices.get(edge.destStr);
            } else {
                srcIndex = edge.srcInt;
                destIndex = edge.destInt;
            }
            
            int x = find(parent, srcIndex);
            int y = find(parent, destIndex);
            
            if (x != y) {
                mst.add(edge);
                minCost += edge.weight;
                union(parent, rank, x, y);
            }
        }
        
        System.out.println("\nMinimum Cost Spanning Tree:");
        for (Edge edge : mst) {
            if (edge.srcStr != null) {
                System.out.println(edge.srcStr + " - " + edge.destStr + " : " + edge.weight);
            } else {
                                System.out.println(edge.srcInt + " - " + edge.destInt + " : " + edge.weight);
            }
        }
        
        return minCost;
    }
    
    public void setVertices(String[] vertices) {
        this.verticesStr = vertices;
        for (int i = 0; i < vertices.length; i++) {
            vertexIndices.put(vertices[i], i);
        }
    }
}

public class KruskalAlgorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char choice;
        
        do {
            System.out.println("Choose input type for vertices:");
            System.out.println("1. Integer");
            System.out.println("2. String");
            System.out.print("Enter your choice: ");
            int vertexInputType = scanner.nextInt();

            
            System.out.print("Enter the number of vertices: ");
            int V = scanner.nextInt();
            System.out.print("Enter the number of edges: ");
            int E = scanner.nextInt();
            
            Graph graph = new Graph(V, E);
            
            if (vertexInputType == 2) {
                System.out.print("Enter vertex labels: ");
                String[] vertices = new String[V];
                for (int i = 0; i < V; i++) {
                    vertices[i] = scanner.next();
                }
                graph.setVertices(vertices);
            }
            
            System.out.println();
            for (int i = 0; i < E; i++) {
                if (vertexInputType == 2) {
                    System.out.print("Enter Edge " + (i+1) + " source: ");
                    String src = scanner.next();
                    System.out.print("Enter Edge " + (i+1) + " destination: ");
                    String dest = scanner.next();
                    System.out.print("Enter Edge " + (i+1) + " weight: ");
                    int weight = scanner.nextInt();
                    graph.addEdge(src, dest, weight, true);
                } else {
                    System.out.print("Enter Edge " + (i+1) + " source: ");
                    int src = scanner.nextInt();
                    System.out.print("Enter Edge " + (i+1) + " destination: ");
                    int dest = scanner.nextInt();
                    System.out.print("Enter Edge " + (i+1) + " weight: ");
                    int weight = scanner.nextInt();
                    graph.addEdge(String.valueOf(src), String.valueOf(dest), weight, false);
                }
            }
            System.out.println("\nAdjacency Matrix:");
            graph.displayAdjMatrix();
            
            int minCost = graph.kruskalMST();
            System.out.println("\nMinimum Cost: " + minCost);
            
            System.out.print("Do you want to try again? (y/n): ");
            choice = scanner.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');
        
        scanner.close();
    }
}
