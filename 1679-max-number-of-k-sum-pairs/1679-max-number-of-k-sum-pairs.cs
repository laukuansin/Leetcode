public class Solution {
    public int MaxOperations(int[] nums, int k) {
        Dictionary<int,int> hashMap = new Dictionary<int,int>();
        int ans=0;
        foreach(int num in nums)
        {
            if(hashMap.ContainsKey(num))
            {
                hashMap[num]+=1;
            }
            else{
                hashMap.Add(num,1);
            }
        }
        
        foreach(KeyValuePair<int, int> kvp in hashMap)
        {
            
            if(kvp.Value==0)
            {
                continue;
            }
           // Console.WriteLine(kvp.Key+"");
            int target = k-kvp.Key;
            
            if(hashMap.ContainsKey(target))
            {
                if(target==kvp.Key)
                {
                    ans+=kvp.Value/2;
                    hashMap[target]=0;
                }
                else{
                    ans+= Math.Min(kvp.Value,hashMap[target]);
                    hashMap[kvp.Key]=0;
                    hashMap[target]=0;
                }
            }
            
        }
        
        return ans;
    }
}