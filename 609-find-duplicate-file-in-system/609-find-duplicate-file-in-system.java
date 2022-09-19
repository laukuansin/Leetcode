import java.util.Hashtable;
class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        Hashtable<String,List<String>> ht = new Hashtable<>();
        for(String path: paths)
        {
            String[] strArr = path.split(" ");
            String root = strArr[0];
            for(int i=1;i<strArr.length;i++)
            {
                String fileName = strArr[i];
                int indexOfFirstB = fileName.indexOf("(");
                int indexOfSecondB = fileName.indexOf(")");
                String fileExten = fileName.substring(0,indexOfFirstB);
                String key = fileName.substring(indexOfFirstB,indexOfSecondB);
                String fullFileName = root+"/"+fileExten;
                if(ht.containsKey(key))
                {
                    List<String> list = ht.get(key);
                    list.add(fullFileName);
                    ht.put(key,list);
                }
                else{
                    List<String> list = new ArrayList<>();
                    list.add(fullFileName);
                    ht.put(key,list);
                }
            }
            
        }
        for (Map.Entry<String, List<String>> e : ht.entrySet())
        {
            List<String> list = e.getValue();
            if(list.size()==1)
                continue;
            res.add(list);
        }
        return res;
        
    }
}