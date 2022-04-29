public class Solution {
    public bool IsBipartite(int[][] graph) {
        int size = graph.Length;
        
        int[] visited = new int[size];
        for(int i=0;i<size;i++)
        {
            if(visited[i]!=0)
            {
                continue;
            }
            Queue<int> queue = new Queue<int>();
            queue.Enqueue(i);
            visited[i]=1;
            while(queue.Count!=0)
            {
                
                int cur=queue.Dequeue();
                int curLabel = visited[cur];
                int neighLabel = curLabel ==1?2:1;
                foreach(int neigh in graph[cur])
                {
                    if(visited[neigh]==0)
                    {
                        visited[neigh]=neighLabel;
                        queue.Enqueue(neigh);
                    }
                    else if(visited[neigh]!=neighLabel)
                    {
                        return false;
                    }
                }
                
            }
        }
        
        return true;
    }
}