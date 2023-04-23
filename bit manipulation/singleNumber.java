class Solution {
    public int singleNumber(int[] nums) {
        int shift=1;
        int val=0;
        for(int i=0;i<32;i++)
        {
            int c=0;
            for(int s:nums)
            {
                if((s&shift)!=0)
                {
                    c++;
                }
            }
            if(c%3!=0)
            {
                val+=shift;
            }
            shift*=2;

        }
        return val;
        
    }
}