class Solution {
    public int[][] merge(int[][] mat) {
        Arrays.sort(mat,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> ans=new ArrayList<>();
        ans.add(mat[0]);
        for(int i=0;i<mat.length;i++){
            int[] pre=ans.get(ans.size()-1);
            if(pre[1]>=mat[i][0]) 
            ans.get(ans.size()-1)[1]=Math.max(ans.get(ans.size()-1)[1],mat[i][1]);
            else ans.add(mat[i]);
        }
        int res[][]=new int[ans.size()][2];
        for(int i=0;i<ans.size();i++) res[i]=ans.get(i);
        return res;

        
    }
}
