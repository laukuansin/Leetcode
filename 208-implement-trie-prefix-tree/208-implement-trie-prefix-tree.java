class Trie {
    class TrieNode{
        TrieNode[] children;
        boolean isEndOfWord;
        
        TrieNode()
        {
            isEndOfWord = false;
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        char[] charArr = word.toCharArray();
        TrieNode cur = root;
        for(int i=0;i<word.length();i++)
        {
            int j=charArr[i]-'a';
            if(cur.children[j]==null)
            {
                cur.children[j]=new TrieNode();
            }
            cur=cur.children[j];
        }
        cur.isEndOfWord=true;
    }
    
    public boolean search(String word) {
        char[] charArr = word.toCharArray();
        TrieNode cur = root;
        for(int i=0;i<word.length();i++)
        {
            int j=charArr[i]-'a';
            if(cur.children[j]==null)
            {
                return false;
            }
            cur=cur.children[j];
        }
        return cur.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        char[] charArr = prefix.toCharArray();
        TrieNode cur = root;
        boolean check=true;
        for(int i=0;i<prefix.length();i++)
        {
            int j=charArr[i]-'a';
            if(cur.children[j]==null)
            {
                check= false;
                break;
            }
            cur=cur.children[j];
        }
        return check;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */