package Q1;

public class TestSList {
    public static void main(String[] args) {
        SList<String> list = new SList<>();

        list.appendEnd("Linked list");
        list.appendEnd("is");
        list.appendEnd("easy");

        list.display();

        System.out.println(list.removeInitial());

        System.out.println(list.contains("difficult"));

        list.clear();
    }
}
