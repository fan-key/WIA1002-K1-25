package Q6;

public class MinMaxTwoArray {
    public static <E extends Comparable<E>> E min(E[][] list) {
        E min = list[0][0];
        for(E[] row : list){
            for(E col : row){
                if(col.compareTo(min) < 0){
                    min = col;
                }
            }
        }
        return min;
    }
    public static <E extends Comparable<E>> E max(E[][] list) {
        E max = list[0][0];
        for(E[] row : list){
            for(E col : row){
                if(col.compareTo(max) > 0){
                    max = col;
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Integer[][] intArray = {{4,5,6},{1,2,3}};
        System.out.println("Min: " + min(intArray) + ", Max: " + max(intArray));

    }
}
