import java.util.ArrayList;
import java.util.LinkedList;

public class AList {
    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        graph.addNode(new Node<>("A"));
        graph.addNode(new Node<>("B"));
        graph.addNode(new Node<>("C"));
        graph.addNode(new Node<>("D"));
        graph.addNode(new Node<>("E"));


        graph.printGraph();
    }
}

class Graph<T>{
    ArrayList<LinkedList<Node<T>>> nodes = new ArrayList<>();

    Graph() {
        nodes = new ArrayList<> ();
    }

    public void addNode(Node<T> node) {
        LinkedList<Node<T>> currList = new LinkedList<>();
        currList.add(node);
        nodes.add(currList);
    }

    public void printGraph() {
        for (int i = 0; i < nodes.size(); i++) {
            System.out.print("Node " + i + ": ");
            System.out.println();
        }
    }


}
class Node<T> {
    T data;

    Node(T data) {
        this.data = data;
    }
}


