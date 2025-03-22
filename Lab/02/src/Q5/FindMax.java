package Q5;

public class FindMax {
    public static void main(String[] args) {
        Circle circle = new Circle(3);
        Circle circle2 = new Circle(2.9);   
        Circle circle3 = new Circle(5.9);

        Integer[] intArray = {1,2,3};
        String [] stringArray = {"red", "green", "blue"};
        Circle [] circleArray = {circle, circle2, circle3};

        System.out.println("Max Int    : " + max(intArray));
        System.out.println("Max String : " + max(stringArray));
        System.out.println("Max Crcle  : " + max(circleArray));

    }

    public static <E extends Comparable<E>> E max(E[] list) {
        E max = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i].compareTo(max) > 0) {
                max = list[i];
            }
        }
        return max;
    }
}
