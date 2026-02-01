adj list 
class Solution {

    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> result = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        int V = adj.size(); // number of vertices

        for (int node = 0; node < V; node++) {

            if (!visited.contains(node)) {

                queue.add(node);
                visited.add(node);

                while (!queue.isEmpty()) {

                    int currNode = queue.poll();
                    result.add(currNode);

                    for (int neighbor : adj.get(currNode)) {

                        if (!visited.contains(neighbor)) {
                            queue.add(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
            }
        }

        return result;
    }
}

---------------------------------------------------------------------------------------------------------------------------------------------------------------------
adj matrix 
class Solution {

    public ArrayList<Integer> bfs(int[][] adjMatrix) {

        int V = adjMatrix.length;
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        // for disconnected graph
        for (int start = 0; start < V; start++) {

            if (!visited[start]) {

                queue.add(start);
                visited[start] = true;

                while (!queue.isEmpty()) {

                    int curr = queue.poll();
                    result.add(curr);

                    // scan row of current node
                    for (int neighbor = 0; neighbor < V; neighbor++) {

                        if (adjMatrix[curr][neighbor] == 1 &&
                            !visited[neighbor]) {

                            queue.add(neighbor);
                            visited[neighbor] = true;
                        }
                    }
                }
            }
        }

        return result;
    }
}

