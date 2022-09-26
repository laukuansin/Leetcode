class UnionFind{
    private int[] root;
    
    public UnionFind()
    {
        root = new int[26];
        for(int i=0;i<26;i++)
        {
            root[i]=i;
        }
    }
    
    public boolean checkBind(int x,int y)
    {
        int rootX= find(x);
        int rootY= find(y);
        return rootX==rootY;
    }
    
    public int find(int x)
    {
        if(x==root[x])
        {
            return root[x];
        }
        return find(root[x]);
    }
    
    public void union(int x, int y)
    {
        int rootX= find(x);
        int rootY=find(y);
        
        if(rootX!=rootY)
        {
            root[rootX]=rootY;
        }
    }
}

class Solution {
    
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind();
        for(String equation:equations)
        {
            char[] charArray = equation.toCharArray();
            if(charArray[1]=='=')
            {
                uf.union(charArray[0]-'a',charArray[3]-'a');
            }
            
        }
        for(String equation:equations)
        {
            char[] charArray = equation.toCharArray();
            if(charArray[1]=='!')
            {
                if(uf.checkBind(charArray[0]-'a',charArray[3]-'a'))
                {
                    return false;
                }
            }
        }
        
        return true;
    }
}