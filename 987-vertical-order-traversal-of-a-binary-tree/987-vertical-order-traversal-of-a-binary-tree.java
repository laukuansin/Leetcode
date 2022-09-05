/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.Hashtable;
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        
        vertical(root, map, 0, 0);  
        
		List<List<Integer>> res = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> col: map.values()){
            res.add(new ArrayList<>()); 
            for(PriorityQueue<Integer> row: col.values()){
                
                // add all elements of hlevels pq in last added list
                while(!row.isEmpty()){
                    res.get(res.size()-1).add(row.poll());
                }
            }
        }
        return res;
    }
    
    void vertical(TreeNode root, TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map, int col, int row){
        
        if(root == null) return;
        
        if(!map.containsKey(col)) map.put(col, new TreeMap<>());
        
        if(!map.get(col).containsKey(row)) 
            map.get(col).put(row, new PriorityQueue<>());
        
        map.get(col).get(row).add(root.val);
        vertical(root.left, map, col-1, row+1);
        vertical(root.right, map, col+1, row+1);
        
    }
}