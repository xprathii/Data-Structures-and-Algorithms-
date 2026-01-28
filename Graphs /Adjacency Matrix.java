import java.util.Scanner;

public class Graph {

    private int[][] adjMatrix;
    private int numVertices;

    // Constructor
    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }

    // Add edge (undirected)
    public void addEdge(int i, int j) {
        if (i >= 0 && j >= 0 && i < numVertices && j < numVertices) {
            adjMatrix[i][j] = 1;
            adjMatrix[j][i] = 1;
        } else {
            System.out.println("Invalid vertex index!");
        }
    }

    // Remove edge
    public void removeEdge(int i, int j) {
        if (i >= 0 && j >= 0 && i < numVertices && j < numVertices) {
            adjMatrix[i][j] = 0;
            adjMatrix[j][i] = 0;
        } else {
            System.out.println("Invalid vertex index!");
        }
    }

    // Add a vertex
    public void addVertex() {
        int[][] newAdjMatrix = new int[numVertices + 1][numVertices + 1];

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                newAdjMatrix[i][j] = adjMatrix[i][j];
            }
        }

        adjMatrix = newAdjMatrix;
        numVertices++;
        System.out.println("Vertex added. Total vertices: " + numVertices);
    }

    // Remove a vertex
    public void removeVertex(int v) {
        if (v < 0 || v >= numVertices) {
            System.out.println("Invalid vertex!");
            return;
        }

        int[][] newAdjMatrix = new int[numVertices - 1][numVertices - 1];

        int newI = 0;
        for (int i = 0; i < numVertices; i++) {
            if (i == v) continue;

            int newJ = 0;
            for (int j = 0; j < numVertices; j++) {
                if (j == v) continue;

                newAdjMatrix[newI][newJ] = adjMatrix[i][j];
                newJ++;
            }
            newI++;
        }

        adjMatrix = newAdjMatrix;
        numVertices--;
        System.out.println("Vertex removed. Total vertices: " + numVertices);
    }

    // Print graph
    public void printGraph() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // MAIN with User Input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial number of vertices: ");
        int v = sc.nextInt();

        Graph graph = new Graph(v);

        while (true) {
            System.out.println("\n------ GRAPH MENU ------");
            System.out.println("1. Add Edge");
            System.out.println("2. Remove Edge");
            System.out.println("3. Add Vertex");
            System.out.println("4. Remove Vertex");
            System.out.println("5. Print Graph");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter source vertex: ");
                    int a = sc.nextInt();
                    System.out.print("Enter destination vertex: ");
                    int b = sc.nextInt();
                    graph.addEdge(a, b);
                    break;

                case 2:
                    System.out.print("Enter source vertex: ");
                    int x = sc.nextInt();
                    System.out.print("Enter destination vertex: ");
                    int y = sc.nextInt();
                    graph.removeEdge(x, y);
                    break;

                case 3:
                    graph.addVertex();
                    break;

                case 4:
                    System.out.print("Enter vertex to remove: ");
                    int r = sc.nextInt();
                    graph.removeVertex(r);
                    break;

                case 5:
                    graph.printGraph();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}


