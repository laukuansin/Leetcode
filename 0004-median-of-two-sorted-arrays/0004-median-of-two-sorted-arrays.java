class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length+nums2.length;
        int medianIndex = (total+1)/2;
        int[] nums3 = new int[total];
        int index1 = 0 , index2 = 0 , index3 = 0;
        while(index1<nums1.length&&index2<nums2.length)
        {
            if(nums1[index1]<nums2[index2])
            {
                nums3[index3++] = nums1[index1++];
            }
            else{
                nums3[index3++] = nums2[index2++];
            }
        }

        while(index1<nums1.length)
        {
            nums3[index3++] = nums1[index1++];
        }

        while(index2<nums2.length)
        {
            nums3[index3++] = nums2[index2++];
        }

        return total%2==0?(double)(nums3[medianIndex]+nums3[medianIndex-1])/2:nums3[medianIndex-1];
    }   
}