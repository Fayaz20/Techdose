class Solution {
    public int maximumDetonation(int[][] bombs) {
        int max=0;
        for(int i=0;i<bombs.length;i++) max=Math.max(max,bfs(bombs,i));
        return max;
    }
    public int bfs(int[][] b,int i){
        Queue<Integer> q=new LinkedList<>();
        int count=1;
        boolean[] detonated=new boolean[b.length];
        q.offer(i);
        detonated[i]=true;
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int j=0;j<b.length;j++){
                if(!detonated[j] && isRange(b[curr],b[j])){
                    detonated[j]=true;
                    count++;
                    q.offer(j);
                }
            }
        }
        return count;
    }
    public boolean isRange(int []p1,int []p2){
        long dx = p1[0] - p2[0], dy = p1[1] - p2[1], radius = p1[2];
        long distance =  dx * dx + dy * dy;
        return distance <= radius * radius;
    }
}
