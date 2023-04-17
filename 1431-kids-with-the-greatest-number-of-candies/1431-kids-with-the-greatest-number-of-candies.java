class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int candy:candies)
            max = Math.max(max,candy);

        for(int candy:candies)
            if(candy+extraCandies>=max)
                result.add(true);
            else
                result.add(false);

        return result;
    }
}