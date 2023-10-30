class Solution {
    public int mDis(int[] P, int[] Q){
        return Math.abs(P[0]-Q[0])+Math.abs(P[1]-Q[1]);
    }
    
    public int minCostConnectPoints(int[][] points) {
        int l=points.length;
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));
        pq.add(new Pair<>(0, 0));
        boolean[] visited = new boolean[l];
        int ans = 0;
        int n = 0;
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> pair = pq.poll();
            int w = pair.getKey();
            int i = pair.getValue();
            if (visited[i]) continue; 
            visited[i]=true;
            ans+= w;
            n++;
            if (n == l) return ans;
            for (int j=0; j<l; j++){
                if (visited[j]) continue;
                int wt=mDis(points[i], points[j]);
                pq.add(new Pair<>(wt, j));
            }
        }
        return -1;
    }
}
