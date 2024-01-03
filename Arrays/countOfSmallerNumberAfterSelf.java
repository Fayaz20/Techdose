class Solution {
    int[] count;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result= new ArrayList<>();
        count=new int[nums.length];
        int[] origIndex=new int[nums.length];

        for(int i=0;i<nums.length;i++)
        {
            origIndex[i]=i;
        }

        sort(nums,origIndex,0,nums.length-1);
        for(int i=0;i<nums.length;i++)
        {
            result.add(count[i]);
        }
        return result;
        
    }
    private void sort(int[] arr,int[] origIndex,int l,int r)
    {
        if(l<r){
            int mid=(l+r)/2;
            sort(arr,origIndex,l,mid);
            sort(arr,origIndex,mid+1,r);
            merge(arr,origIndex,l,mid,r);
        }
    }

    private void merge(int[] arr,int[] origIndex,int left,int mid,int right)
    {
        int lArrSize=mid-left+1;
        int rArrSize=right-mid;

        int[] lArr=new int[lArrSize];
        int[] rArr=new int[rArrSize];

        for(int i=0;i<lArrSize;i++)
        {
            lArr[i]=origIndex[left+i];
        }
        for(int i=0;i<rArrSize;i++)
        {
            rArr[i]=origIndex[i+mid+1];
        }

        int i=0,j=0,k=left,rightCount=0;

        while(i<lArrSize && j<rArrSize)
        {
            if(arr[lArr[i]]<=arr[rArr[j]])
            {
                origIndex[k]=lArr[i];
                count[lArr[i]]+=rightCount;
                i++;
            }
            else
            {
                origIndex[k]=rArr[j];
                rightCount++;
                j++;
            }
            k++;
        }
        while(i<lArrSize){
            origIndex[k]=lArr[i];
            count[lArr[i]]+=rightCount;
            i++;
            k++;
        }
        while(i<rArrSize){
            origIndex[k]=rArr[i];
            j++;
            k++;
        }

    }
}
