public class Codec {
    Dictionary<string,string> hashMap;
    int num = 916132831;
    string str = "abcdefghijklmnopqrstuvwyxzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    // Encodes a URL to a shortened URL
    public string encode(string longUrl) {
        Random rdm = new Random();
        hashMap = new Dictionary<string,string>();
        int randomNum = rdm.Next(num);
        string ans = Convertto64(randomNum);
        while(hashMap.ContainsKey(ans))
        {
            randomNum = rdm.Next(num);
            ans=Convertto64(randomNum);
        }
        hashMap.Add(ans,longUrl);
        return ans;
    }
    
    
    public string Convertto64(int num)
    {
        string ans="";
        while(num!=0)
        {
            ans+=str[(num%62)];
            num/=62;
        }
        return ans;
    }


    // Decodes a shortened URL to its original URL.
    public string decode(string shortUrl) {
        return hashMap[shortUrl];
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));