class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int totalSize = nums1.length-1;
        int count1 = m-1;
        int count2=n-1;
        
        while(count1>=0&&count2>=0)
        {
           if(nums1[count1]>nums2[count2])
           {
               nums1[totalSize--]=nums1[count1--];
            }
            else{
                nums1[totalSize--]=nums2[count2--];
            }
        }
        while(count2>=0)
        {
            nums1[totalSize--]=nums2[count2--];
        }
    }
}