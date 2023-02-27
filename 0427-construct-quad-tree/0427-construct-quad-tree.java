/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        int n = grid.length;
        return divideNConquer(grid,0,0,n);
    }

    public Node divideNConquer(int[][] grid,int x,int y, int size)
    {//0,8,0,8
        Node node = new Node();
        int checkGrid = check1Or0(grid,x,y,size);
        if(checkGrid==1||checkGrid==0)
        {
            return new Node(checkGrid==1?true:false,true);
        }
        else{
            node.topLeft=divideNConquer(grid,x,y,size/2);
            node.topRight=divideNConquer(grid,x,y+size/2,size/2); 
            node.bottomLeft=divideNConquer(grid,x+size/2,y,size/2); 
            node.bottomRight=divideNConquer(grid,x+size/2,y+size/2,size/2);
            return node;
        }


    }

    public int check1Or0(int[][] grid,int x,int y,int size)
    {
        int startValue = grid[x][y];//either all 1's,0's or no
        for(int i=x;i<x+size;i++)
        {
            for(int j=y;j<y+size;j++)
            {
                if(startValue!=grid[i][j])
                {
                    return -1;
                }
            }
        }
        return startValue;
    }
}