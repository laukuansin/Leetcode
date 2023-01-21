class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();

        if(s.length()>12)
        {
            return res;
        }
        dfs(res,s,0,"",0);
        return res;
    }

    public void dfs(List<String> res, String s, int idx,String currIP,int countDot)
    {
        if(countDot==4)
        {
            if(idx==s.length())
            {
                res.add(currIP);
            }
            return ;
        }

        for(int i=1;i<=3;i++)
        {
            if(idx+i>s.length())
                break;
            String strIntIP = s.substring(idx,idx+i);
            if(strIntIP.length()>1)
            {
                if(strIntIP.charAt(0)=='0')
                {
                    continue;
                }
                int numOfIP = Integer.valueOf(strIntIP);

                if(numOfIP>255)
                {
                    continue;
                }
            }
            dfs(res,s,idx+i,countDot==0?strIntIP:currIP+"."+strIntIP,countDot+1);
        }
    }
}