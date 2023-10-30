class Solution {
    private  void dfs(int[][] graph,List<List<Integer>> ans,int start,List<Integer> l){
        if(start==graph.length-1){
            l.add(start);
            ans.add(new ArrayList<>(l));
            l.remove(l.size()-1);
        }
        l.add(start);
        for(int i=0;i<graph[start].length;i++){
            dfs(graph,ans,graph[start][i],l);
        }
        l.remove(l.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans=new ArrayList<>();
        dfs(graph,ans,0,new ArrayList<>());
        return ans;
    }
}
