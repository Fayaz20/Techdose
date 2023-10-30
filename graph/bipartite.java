class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] odd = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!bfs(i, odd, graph)) return false;
        }
        return true;
    }

    public boolean bfs(int i, int[] odd, int[][] graph) {
        if (odd[i] != 0) return true;
        Deque<Integer> q = new ArrayDeque<>();
        odd[i] = 1; // Instead of -1
        q.add(i);
        while (!q.isEmpty()) {
            i = q.poll();
            for (int node : graph[i]) { // Iterate over neighbors of node i
                if (odd[i] == odd[node]) return false;
                else if (odd[node] == 0) {
                    q.add(node);
                    odd[node] = -odd[i];
                }
            }
        }
        return true;
    }
}
