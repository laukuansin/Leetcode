class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> res=new ArrayList<>();
        if(arr.length==1)
        {
            res.add(arr[0]);
            return res;
        }
        int count=0;
         PriorityQueue<Integer> pq = new
             PriorityQueue<Integer>(arr.length, new CustomComparator(x));
        for(int num:arr)
        {
            pq.add(num);
        }
        while(count<k&&!pq.isEmpty())
        {
            res.add(pq.poll());
            count++;
        }
        /*
        int count =0;
        int start=0;
        int end=arr.length-1;
        
        while(count<k&&start<=end)
        {
            int a=arr[start];
            int b=arr[end];
            
            if((Math.abs(a-x)<Math.abs(b-x))||((Math.abs(a-x)==Math.abs(b-x)&&a<b)))
            {
                res.add(a);
                count++;
                start++;
            }
            else{
                res.add(b);
                count++;
                end--;
            }
        }
        */
        Collections.sort(res);
        return res;
    }
}
class CustomComparator implements Comparator<Integer>{
    int x;
    CustomComparator(int x)
    {
        this.x=x;
    }
    // Overriding compare()method of Comparator
                // for descending order of cgpa
    public int compare(Integer i1, Integer i2) {
        
        if(Math.abs(i1-x)<Math.abs(i2-x)||(Math.abs(i1-x)==Math.abs(i2-x)&&i1<i2))
        {
            return -1;
        }
        else {
            return 1;
        }
    }
}