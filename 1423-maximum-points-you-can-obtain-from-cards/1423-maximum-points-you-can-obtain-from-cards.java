class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int max=0;//k =3,cp=7
        int windowSize = cardPoints.length-k;//4
        int totalSum = 0;
        int windowSum = 0;
        for(int i=0;i<cardPoints.length;i++)
        {
            totalSum+=cardPoints[i];
            if(i<windowSize)
            {
                windowSum+=cardPoints[i];
            }
        }
        for(int i=0;i<=k;i++)
        {
            if(i>0)
            {
                windowSum+=cardPoints[i+windowSize-1];
                windowSum-=cardPoints[i-1];
            }
            max = Math.max(max,totalSum-windowSum);
        }
       /* System.out.println(totalSum);
        System.out.println(windowSum);*/
        return max;
    }
}