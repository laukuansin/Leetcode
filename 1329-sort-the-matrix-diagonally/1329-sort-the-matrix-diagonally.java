import java.util.Hashtable;
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        Hashtable<Integer,List<Integer>> ht=new Hashtable<>();
        int row = mat.length;
        int col = mat[0].length;
        
        
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                int key = j-i;
                if(ht.containsKey(key))
                {
                    List<Integer> list = ht.get(key);
                    list.add(mat[i][j]);
                    Collections.sort(list);
                    ht.put(key,list);
                }
                else{
                    List<Integer> list = new ArrayList<>();
                    list.add(mat[i][j]);
                    ht.put(key,list);
                }
            }
        }
        for(int i=0;i<row;i++)
        {
            int key = 0-i;
            List<Integer> list = ht.get(key);
            int x = i;
            int y = 0;
            int index= 0;
            
            while(x<row&&y<col)
            {
                mat[x][y] = list.get(index++);
                x++;
                y++;
            }
        }
        for(int i=0;i<col;i++)
        {
            int key = i-0;
            List<Integer> list = ht.get(key);
            int x = 0;
            int y = i;
            int index= 0;
            
            while(x<row&&y<col)
            {
                mat[x][y] = list.get(index++);
                x++;
                y++;
            }
        }
        return mat;
        
    }
}