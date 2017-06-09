public interface Deque<T>{

    public void addFirst(T deqVal);
    public void addLast(T deqVal);
    
    public T removeFirst();
    public T removeLast();
    
    public boolean contains (T deqVal);
    
    public boolean removeFirstOccurrence (T deqVal);
    public boolean removeLastOccurrence (T deqVal);
        
    public T getFirst();
    public T getLast();
    
    public int size();
    
}
