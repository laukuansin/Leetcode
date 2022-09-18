class Solution {
    class TrieNode{
        TrieNode[] children;
        List<Integer> restPalindrome;
        int wordIndex;
        TrieNode(){
            children = new TrieNode[26];
            restPalindrome = new ArrayList<>();
            wordIndex=-1;
        }
        
    }
    TrieNode root = new TrieNode();
        List<List<Integer>> res = new ArrayList<>();
        int n=0;
    public List<List<Integer>> palindromePairs(String[] words) {
        n=words.length;
        
        for(int i=0;i<n;i++)
        {
            add(words[i],i);
        }
        
        for(int i=0;i<n;i++)
        {
            search(words[i],i);
        }
        return res;
    }
    
    public void add(String word,int index)
    {
        char[] chrArr = word.toCharArray();
        TrieNode cur = root;
        for(int i=word.length()-1;i>=0;i--)
        {
            int idx = chrArr[i]-'a';
            if(isPalindrome(chrArr,0,i))
            {
                cur.restPalindrome.add(index);
            }
            if(cur.children[idx]==null)
            {
                cur.children[idx] = new TrieNode();
            }
            cur=cur.children[idx];
        }
        cur.wordIndex=index;
    }
    
    public void search(String word, int index)
    {
        char[] chrArr = word.toCharArray();
        TrieNode cur = root;
        for(int i=0;i<word.length();i++)
        {
            int idx = chrArr[i]-'a';
            if(cur.wordIndex!=-1&&isPalindrome(chrArr,i,word.length()-1))
            {
                res.add(Arrays.asList(index,cur.wordIndex));
            }
            
            if(cur.children[idx]==null)
            {
                return;
            }
            cur=cur.children[idx];
        }
        
        if(cur.wordIndex!=-1&&index!=cur.wordIndex)
        {
             res.add(Arrays.asList(index,cur.wordIndex));
        }
        
        for(int i:cur.restPalindrome)
        {
            res.add(Arrays.asList(index,i));
        }
    }
    
    private boolean isPalindrome(char[] chrArr, int left, int right){
        while(left<right)
            if(chrArr[left++]!=chrArr[right--])
                return false;
        return true;
    }
}