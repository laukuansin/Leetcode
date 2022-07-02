class Solution {
    long MOD = 1000000007;
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long maxHeight = 0;
        long maxWidth = 0;
        int startHeightIndex = 0;
        int startWidthIndex = 0;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        for(int i =0;i<horizontalCuts.length;i++)
        {
            int temp = horizontalCuts[i]-startHeightIndex;
            maxHeight=Math.max(maxHeight,temp);
            startHeightIndex = horizontalCuts[i];
        }
        
        maxHeight = Math.max(maxHeight,h-startHeightIndex);
        
        for(int i =0;i<verticalCuts.length;i++)
        {
            int temp = verticalCuts[i]-startWidthIndex;
            maxWidth=Math.max(maxWidth,temp);
            startWidthIndex = verticalCuts[i];
        }
        maxWidth = Math.max(maxWidth,w-startWidthIndex);
        
        return (int)((maxHeight*maxWidth)%MOD);
    }
}