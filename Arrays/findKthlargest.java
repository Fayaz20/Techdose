class Solution {
    void reverse(int[] nums)
    {
        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[n - i - 1];
            nums[n - i - 1] = temp;
        }
    }

    public int findKthLargest(int[] nums, int k) {
         Arrays.sort(nums);
         reverse(nums);
         int ans=0;
         for(int i=0;i<nums.length;i++)
         {
             if(i+1==k)
             {
                 ans=nums[i];
             }
         }
         return ans;
        
    }
}
