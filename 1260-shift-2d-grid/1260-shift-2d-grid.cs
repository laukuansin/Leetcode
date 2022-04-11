public class Solution {
    public IList<IList<int>> ShiftGrid(int[][] grid, int k) {
        int row = grid.Length;
        int col = grid[0].Length;
        int total = row*col;
        k %=(total);
        IList<IList<int>> list = new List<IList<int>>();
        
        for(int i=0;i<row;i++)
        {
            IList<int> tmpList = new List<int>();
            for(int j=0;j<col;j++)
            {
                int index = ((i*col+j)-k+total)%total;
                tmpList.Add(grid[index/col][index%col]);
            }
            list.Add(tmpList);

        }
        
        return list;
        
    }
}