class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length;

        while(start<end)//0 3
        {
            int middle = (end-start)/2+start;
            
            if(arr[middle]>arr[middle+1])
            {
                end = middle;
            }
            else{
                start = middle+1;
            }
        }
        return start;
    }
}