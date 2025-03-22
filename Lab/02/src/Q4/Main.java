package Q4;

public class Main {
    public static void main(String[] args) {
        Integer[] intArray = {5,3,7,11,4,9,8,2};
        String[] stringArray = {"red", "blue", "orange", "tan"};

        minmax(intArray);
        minmax(stringArray);
        
    }
    public static <T extends Comparable<T>> void minmax(T[] a){
        T min = a[0];
        T max = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(min) < 0) {
                min = a[i];
            }
            if (a[i].compareTo(max) > 0) {
                max = a[i];
            }
        }
        System.out.println("Min: " + min + ", Max: " + max);
    }
}
