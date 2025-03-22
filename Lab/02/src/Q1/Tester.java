package Q1;

public class Tester {
    public static void main(String[] args) {
        MyGeneric<String> strObj = new MyGeneric<>();
        MyGeneric<Integer> intObj = new MyGeneric<>();
        strObj.setObject("Hello");
        intObj.setObject(123);
        System.out.println(strObj.getObject());
        System.out.println(intObj.getObject());
    }
}
