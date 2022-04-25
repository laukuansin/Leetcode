// C# IEnumerator interface reference:
// https://docs.microsoft.com/en-us/dotnet/api/system.collections.ienumerator?view=netframework-4.8

class PeekingIterator {
    // iterators refers to the first element of the array.
    int currentPos = 0;
    int size=0;
    int[] arr;
    
    public PeekingIterator(IEnumerator<int> iterator) {
        // initialize any member here.
        int idx=0;
        arr = new int[1000];
        arr[idx]=iterator.Current;
        while (iterator.MoveNext())
        {
            arr[++idx]=iterator.Current;
            //size++;
        }
    }
    
    // Returns the next element in the iteration without advancing the iterator.
    public int Peek() {
        return arr[currentPos];
    }
    
    // Returns the next element in the iteration and advances the iterator.
    public int Next(){
        int cur = arr[currentPos++];

        return cur;
    }
    
    // Returns false if the iterator is refering to the end of the array of true otherwise.
    public bool HasNext() {
	    if(arr[currentPos]==0)
        {
            return false;
        }
        return true;
    }
}