class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        char[] str1Arr = s1.toCharArray();
        char[] str2Arr = s2.toCharArray();
        UnionFind uf = new UnionFind();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s1.length();i++)
        {
            int str1InNum = str1Arr[i]-'a';
            int str2InNum = str2Arr[i]-'a';
            uf.union(str1InNum,str2InNum);
        }

        for(char c:baseStr.toCharArray())
        {
            char currChar = (char)(uf.find(c-'a')+97);
            sb.append(currChar);
        }

        return sb.toString();

    }
}

class UnionFind{
    int[] root;
    UnionFind()
    {
        root = new int[26];

        for(int i=0;i<26;i++)
        {
            root[i] = i;
        }
    }

    public void union(int x,int y)
    {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX!=rootY)
        {
            if(rootX>rootY)
            {
                root[rootX] = rootY;
            }
            else{
                root[rootY] = rootX;
            }
        }
    }

    public int find(int x)
    {
        if(root[x]==x)
        {
            return root[x];
        }

        return find(root[x]);
    }
}