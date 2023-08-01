class Solution {
    public int maximumGap(int[] nums) {
        if(nums==null||nums.length==0)
        {
            return 0;
        }
        radixSort(nums);
        int res=Integer.MIN_VALUE;
        for(int i=0;i<nums.length-1;i++)
        {
            res=Math.max(res,nums[i+1]-nums[i]);
        }
        return res==Integer.MIN_VALUE ? 0:res;
        
    }
    void radixSort(int[] nums){
        List<List<Integer>> arr=new ArrayList<>();
        for(int i=0;i<10;i++)
        {
            arr.add(i,new ArrayList<>());
        }
        int max=nums[0];
        for(int n:nums){
            max=Math.max(n,max);
        }
        int div=1;
        while(max/div>0){
            for(int n: nums){
                int dig=(n/div)%10;
                arr.get(dig).add(n);
            }
        
        int index=0;
        for(int j=0;j<10;j++){
             for(int n:arr.get(j)){
                 nums[index++]=n;
             }
             arr.get(j).clear();

        }
        div *=10;
        }
       
    }
}
