package Q1;

public class ArrayBag<T> implements BagInterface<T> {
    private final T[] bag;
    private static int DEFAULT_CAPACITY = 25;
    int numberOfEntries;

    public ArrayBag() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayBag(int capacity) {
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[]) new Object[capacity];
        bag = tempBag;
        numberOfEntries = 0;
    }

    public int getCurrentSize() {
        return numberOfEntries;
    }

    public boolean isFull() {
        return numberOfEntries == bag.length;
    }

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    public boolean add(T newEntry) {
        if (!isFull()) {
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
            return true;
        }
        return false;
    }

    public T remove() {
        if (!isEmpty()) {
            numberOfEntries--;
            T removedEntry = bag[numberOfEntries];
            bag[numberOfEntries] = null;
            return removedEntry;
        }
        return null;
    }

    public boolean remove(T anEntry) {
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                numberOfEntries--;
                bag[i] = bag[numberOfEntries];
                bag[numberOfEntries] = null;
                return true;
            }
        }
        return false;
    }

    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    }

    public int getFrequencyOf(T anEntry) {
        int frequency = 0;
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                frequency++;
            }
        }
        return frequency;
    }

    public boolean contains(T anEntry) {
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                return true;
            }
        }
        return false;
    }

    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        for (int i = 0; i < numberOfEntries; i++) {
            result[i] = bag[i];
        }
        return result;
    }

    public BagInterface<T> union(BagInterface<T> anotherBag){
        BagInterface<T> unionBag = new ArrayBag<>(this.getCurrentSize() + anotherBag.getCurrentSize());
        for (T entry : this.toArray()) {
            unionBag.add(entry);
        }
        for (T entry : anotherBag.toArray()) {
            unionBag.add(entry);
        }
        return unionBag;
    }

    public BagInterface<T> intersection(BagInterface<T> anotherBag){
        BagInterface<T> intersectionBag = new ArrayBag<>(this.getCurrentSize());
        BagInterface<T> tempBag = new ArrayBag<>(anotherBag.getCurrentSize());
        for (T entry : anotherBag.toArray()) {
            tempBag.add(entry);
        }
        for (T entry : this.toArray()) {
            if (tempBag.contains(entry)) {
                intersectionBag.add(entry);
                tempBag.remove(entry);
            }
        }
        return intersectionBag;
    }

    public BagInterface<T> difference(BagInterface<T> anotherBag){
        BagInterface<T> differenceBag = new ArrayBag<>(this.getCurrentSize());
        for(T entry : this.toArray()){
            differenceBag.add(entry);
        }
        for(T entry : anotherBag.toArray()){
            if (differenceBag.contains(entry)) {
                differenceBag.remove(entry);
            }
        }
        return differenceBag;
    }
}
