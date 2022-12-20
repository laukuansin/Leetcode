class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        set.add(0);

        while(!queue.isEmpty())
        {
            int size = queue.size();

            for(int i=0;i<size;i++)
            {
                int curr = queue.poll();
                List<Integer> currRoomList = rooms.get(curr);

                for(int room:currRoomList)
                {
                    if(set.contains(room))
                    {
                        continue;
                    }
                    queue.add(room);
                    set.add(room);
                }
            }
        }
        
        return set.size()==rooms.size();
    }
}