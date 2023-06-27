import java.util.Scanner;

public class PrimsAlgorithm {

	private static int findMinVertex(boolean[] visited, int[] weight) {

		int minVertex = -1;

		for (int i = 0; i < weight.length; i++) {
			if (!visited[i] && (minVertex == -1 || weight[i] < weight[minVertex]))
				minVertex = i;
		}
		return minVertex;
	}

	public static void primsAlgorithm(int[][] matrix) {
		 int n = matrix.length;
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        int[] weight = new int[n];

        // source vertex 0
        parent[0] = -1;
        weight[0] = 0;

        for (int i = 1; i < n; i++)
            weight[i] = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int minVertex = findMinVertex(visited, weight);
            visited[minVertex]  =true;
            // Explore neighbors of min vertex
            for (int j = 0; j < n; j++) {
                if (matrix[minVertex][j] != 0 && !visited[j]) {
                    // update values
                    if (weight[j] > matrix[minVertex][j]) {
                        weight[j] = matrix[minVertex][j];
                        parent[j] = minVertex;
                    }
                }
            }
        }

        // Print MST
        System.out.println("MST: ");
        for (int i = 1; i < n ; i++) {
            if (i < parent[i])
                System.out.println(i + " " + parent[i] + " " + weight[i]);
            else
                System.out.println(parent[i] + " " + i + " " + weight[i]);
        }

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices: ");
		int n = sc.nextInt();
        System.out.println("Enter number of edges:");
		int e = sc.nextInt();
		int[][] matrix = new int[n][n];
		for (int i = 0; i < e; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int w = sc.nextInt();
			matrix[v1][v2] = w;
			matrix[v2][v1] = w;
		}
		primsAlgorithm(matrix);
        sc.close();
	}
}