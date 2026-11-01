import java.util.Scanner;

public class GraphTraversal {
    static int[][] adj;
    static boolean[] visited;
    static int n;

    // Breadth First Search using a queue
    static void BFS(int start) {
        visited = new boolean[n];
        int[] queue = new int[n];
        int front = 0, rear = 0;

        visited[start] = true;
        queue[rear++] = start;

        System.out.print("BFS Traversal: ");

        while (front < rear) {
            int vertex = queue[front++];
            System.out.print(vertex + " ");

            for (int i = 0; i < n; i++) {
                if (adj[vertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue[rear++] = i;
                }
            }
        }
        System.out.println();
    }

    // Depth First Search using recursion
    static void DFS(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int i = 0; i < n; i++) {
            if (adj[vertex][i] == 1 && !visited[i]) {
                DFS(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Number of vertices must be positive.");
            sc.close();
            return;
        }

        adj = new int[n][n];

        System.out.println("Enter adjacency matrix (0 or 1):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adj[i][j] = sc.nextInt();
            }
        }

        int choice, start;

        do {
            System.out.println("\\n--- GRAPH TRAVERSAL MENU ---");
            System.out.println("1. BFS Traversal");
            System.out.println("2. DFS Traversal");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter starting vertex (0 to " + (n - 1) + "): ");
                    start = sc.nextInt();

                    if (start >= 0 && start < n) {
                        BFS(start);
                    } else {
                        System.out.println("Invalid starting vertex!");
                    }
                    break;

                case 2:
                    System.out.print("Enter starting vertex (0 to " + (n - 1) + "): ");
                    start = sc.nextInt();

                    if (start >= 0 && start < n) {
                        visited = new boolean[n];
                        System.out.print("DFS Traversal: ");
                        DFS(start);
                        System.out.println();
                    } else {
                        System.out.println("Invalid starting vertex!");
                    }
                    break;

                case 3:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 3);

        sc.close();
    }
}
