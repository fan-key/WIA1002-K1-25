
import java.util.ArrayList;

public class AMatrix {

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addNode(new Node<String>("A"));
        graph.addNode(new Node<String>("B"));
        graph.addNode(new Node<String>("C"));
        graph.addNode(new Node<String>("D"));
        graph.addNode(new Node<String>("E"));

        graph.addEdge(0, 1); // A -> B
        graph.addEdge(0, 2); // A -> C
        graph.addEdge(1, 3); // B -> D
        graph.addEdge(2, 4); // C -> E  
        graph.addEdge(3, 4); // D -> E
        graph.addEdge(4, 0); // E -> A
        graph.addEdge(4, 1); // E -> B
        graph.addEdge(4, 2); // E -> C

        graph.printGraph();



    }
}

class Graph{
    ArrayList<Node> nodes = new ArrayList<>();
    int [][] matrix;

    Graph(int size) {
        nodes = new ArrayList<>();
        matrix = new int[size][size];
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void addEdge(int src, int dst){
        if(src < 0 || dst < 0 || src >= matrix.length || dst >= matrix.length) {
            throw new IllegalArgumentException("Invalid node index");
        }
        else matrix[src][dst] = 1;
    }

    public boolean hasEdge(int src, int dst){
        return matrix[src][dst] != 0;
    }

    public void printGraph() {

        System.out.print("  ");
        for(Node node : nodes) {
            System.out.print(node.data  + " ");
        }System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(nodes.get(i).data + " ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


}

class Node<T extends Comparable<T>> {
    T data;

    Node(T data) {
        this.data = data;
    }
}