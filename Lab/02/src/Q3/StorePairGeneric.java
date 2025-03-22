package Q3;

public class StorePairGeneric <T extends Comparable<T>> {
    private T first;
    private T second;

    public StorePairGeneric(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setPair(T first, T second) {
        this.first = first;
        this.second = second;
    }
    public int compareTo(StorePairGeneric<T> pair){
        return first.compareTo(pair.first);
    }
    
    public boolean equals(StorePairGeneric<T> pair){
        return first.equals(pair.first);
    }
    @Override
    public String toString() {
        return "First: " + first + ", Second: " + second;
    }

}
