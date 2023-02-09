class Solution {
    public long distinctNames(String[] ideas) {
        long res = 0 ;
        List<String>[] alphabetList = new List[26];

        for(int i=0;i<26;i++)
        {
            alphabetList[i] = new ArrayList<>();
        }
        //use Array of ArrayList as HashMap
        //Key: First character
        //Val: Following string
        for(String idea:ideas)
        {
            char firstChar = idea.charAt(0);
            String otherString = idea.substring(1);
            alphabetList[firstChar-'a'].add(otherString);
        }

        //Outer loop from A-Y
        //inner loop from each current character+1 until Z
        //For example: 
        //Outer Loop:A
        //Inner Loop:B~Z
        //Outer Loop:B
        //Inner Loop:C~Z
        for(int i=0;i<25;i++)
        {
            //if did not have specific character then skip
            if(alphabetList[i].size()==0)
                continue;

            //Hash set to check whether got duplicate or not
            Set<String> set = new HashSet<>();
            for(String strI:alphabetList[i])
                set.add(strI);

            for(int j=i+1;j<26;j++)
            {
                if(alphabetList[j].size()==0)
                    continue;
                
                int availableStringInI = alphabetList[i].size();
                int availableStringInJ = alphabetList[j].size();

                for(String strJ:alphabetList[j])
                {
                    //if both character also have same other string mean that swap the first letters also same name
                    //Example: 
                    //string 1: "A"pple
                    //string 2: "B"pple
                    //After swapping firsr char
                    //string 1: "B"pple
                    //string 2: "A"pple
                    if(set.contains(strJ))
                    {
                        availableStringInI--;
                        availableStringInJ--;
                    }
                }
                res += (availableStringInI*availableStringInJ*2);
            }
        }
        return res;
    }
}