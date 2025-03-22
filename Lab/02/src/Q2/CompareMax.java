package Q2;

public class CompareMax {
    public static void main(String[] args) {
        System.out.println(maximum(3, 4, 5));
        System.out.println(maximum(6.6, 8.8, 7.7));
        System.out.println(maximum("pear", "apple", "orange"));
    }

    public static <T extends Comparable<T>> T maximum(T first, T second, T third){
        T max = first;
        if (second.compareTo(max) > 0) {
            max = second;
        }
        if (third.compareTo(max) > 0) {
            max = third;
        }
        return max;
    }
}
