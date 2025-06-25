import java.util.ArrayList;

public class TestMyWeightedGraph {
    public static void main(String[] args) {
        MyWeightedGraph<String,Integer> graph = new MyWeightedGraph<>();
        String[] cities = {"Alor Setar", "Kucing", "Langkawi", "Melaka", "Penang", "Tawau"};
        for(String city : cities) {
            graph.addVertex(city);
        }
        System.out.println("Vertices added: " + graph.size);

        System.out.println("Cities and their vertices:");
        for(int i = 0; i < graph.size; i++) {
            System.out.println("Vertex " + i + ": " + graph.getVertex(i));
        }

        System.out.println("Is 'Melaka' a vertex? " + graph.hasVertex("Melaka"));
        System.out.println("Is 'Kuala Lumpur' a vertex? " + graph.hasVertex("Kuala Lumpur"));
        System.out.println();

        System.out.println("Kuching at index: " + graph.getIndex("Kucing"));
        System.out.println("Ipoh at index: " + graph.getIndex("Ipoh"));
        System.out.println();

        System.out.println("Add edge Kuching - Melaka : " + graph.addEdge("Kucing", "Melaka", 800));
        System.out.println("Add edge Langkawi - Penang : " + graph.addEdge("Langkawi", "Penang", 100));
        System.out.println("Add edge Melaka - Penang : " + graph.addEdge("Melaka", "Penang", 300));
        System.out.println("Add edge Alor Setar - Kuching : " + graph.addEdge("Alor Setar", "Kuching", 1200));
        System.out.println("Add edge Tawau - Alor Setar : " + graph.addEdge("Tawau", "Alor Setar", 900));
        System.out.println("Add edge Langkawi - Ipoh : " + graph.addEdge("Langkawi", "Ipoh", 200));
        System.out.println();

        System.out.println("has edge Kucing - Melaka? " + graph.hasEdge("Kucing", "Melaka"));
        System.out.println("has edge Melaka - Langkawi? " + graph.hasEdge("Melaka", "Langkawi"));
        System.out.println("has edge Ipoh - Langkawi? " + graph.hasEdge("Ipoh", "Langkawi"));
        System.out.println();

        System.out.println("Weight of edge Kucing - Melaka: " + graph.getEdgeWeight("Kucing", "Melaka"));
        System.out.println("Weight of edge from Tawau to Alor Setar: " + graph.getEdgeWeight("Tawau", "Alor Setar"));
        System.out.println("Weight of edge from Semporna to Ipoh: " + graph.getEdgeWeight("Semporna", "Ipoh"));
        System.out.println();

        System.out.println("In and Out Degree for Kucing:" + 
                           "\nIn Degree: " + graph.getInDeg("Kucing") + 
                           "\nOut Degree: " + graph.getOutDeg("Kucing"));
        System.out.println("In and Out Degree for Penang:" + 
                           "\nIn Degree: " + graph.getInDeg("Penang") + 
                           "\nOut Degree: " + graph.getOutDeg("Penang"));
        System.out.println("In and Out Degree for Ipoh:" + 
                           "\nIn Degree: " + graph.getInDeg("Ipoh") + 
                           "\nOut Degree: " + graph.getOutDeg("Ipoh"));

        System.out.println();

        System.out.println("Neighbours of Kucing: " + graph.getNeighbours("Kucing"));
        System.out.println("\nPrint all edges in the graph: ");
        graph.printEdges();
    }
}
class MyWeightedGraph<T extends Comparable<T>, N extends Comparable<N>>{
    Vertex<T,N> head;
    Vertex<T,N> tail;
    int size;

    MyWeightedGraph(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean hasVertex(T t){
        if(head == null) return false;
        Vertex<T,N> curr = head;
        while(curr != null){
            if(curr.vertexInfo.compareTo(t) == 0) return true;
            curr = curr.nextVertex;
        }
        return false;
    }

    public boolean addVertex(T t){
        if(hasVertex(t)) return false;
        if(head == null){
            head = new Vertex<>(t);
            tail = head;
        }
        else{
            tail.nextVertex = new Vertex<>(t);
            tail = tail.nextVertex;
        }
        size ++;
        return true;
    }

    public int getInDeg(T t){
        Vertex<T,N> curr = head;
        while(curr != null){
            if(curr.vertexInfo.compareTo(t) == 0) return curr.inDeg;
            curr = curr.nextVertex;
        }
        return -1;
    }

    public int getOutDeg(T t){
        Vertex<T,N> curr = head;
        while(curr != null){
            if(curr.vertexInfo.compareTo(t) == 0) return curr.outDeg;
            curr = curr.nextVertex;
        }
        return -1;
    }

    public int getIndex(T t){
        Vertex<T,N> curr = head;
        int index = 0;
        while(curr != null){
            if(curr.vertexInfo.compareTo(t) == 0) return index;
            curr = curr.nextVertex;
            index ++;
        }
        return -1;
    }

    public ArrayList<T> getAllVertexObjects(){
        Vertex<T,N> curr = head;
        ArrayList<T> arr = new ArrayList<>();
        while(curr != null){
            arr.add(curr.vertexInfo);
            curr = curr.nextVertex;
        }
        return arr;
    }

    public T getVertex(int index){
        if(index < 0 || index >= size) return null;
        Vertex<T,N> curr = head;
        for(int i = 0 ; i < index ; i++) curr = curr.nextVertex;
        return curr.vertexInfo;
    }

    public boolean hasEdge(T source, T destination){
        if(size < 2) return false;
        Vertex<T,N> currVertex = head;
        while(currVertex != null){
            if(currVertex.vertexInfo.compareTo(source) == 0){
                Edge<T,N> currEdge = currVertex.firstEdge;
                while(currEdge != null){
                    if(currEdge.destination.vertexInfo.compareTo(destination) == 0) return true;
                    currEdge = currEdge.nextEdge;
                }
            }
            currVertex = currVertex.nextVertex;
        }
        return false;
    }

    public boolean addEdge(T source, T destination, N n){
        if(!hasVertex(destination) || !hasVertex(source)) return false;
        Vertex<T,N> sourceVertex = null;
        Vertex<T,N> destinationVertex = null;
        Vertex<T,N> curr = head;
        while(curr != null && (sourceVertex == null || destinationVertex == null)){
            if(curr.vertexInfo.compareTo(source) == 0) sourceVertex = curr;
            if(curr.vertexInfo.compareTo(destination) == 0) destinationVertex = curr;
            curr = curr.nextVertex;
        }
        if(sourceVertex != null && destinationVertex != null){
            Edge<T,N> newEdge = new Edge<>(destinationVertex, n, sourceVertex.firstEdge);
            sourceVertex.firstEdge = newEdge;
            sourceVertex.outDeg++;
            destinationVertex.inDeg++;
            return true;
        }
        return false;
    }

    public N getEdgeWeight(T source, T destination){
        Vertex<T,N> sourceVertex = head;
        while(sourceVertex != null){
            if(sourceVertex.vertexInfo.compareTo(source) == 0){
                Edge<T,N> currEdge = sourceVertex.firstEdge;
                while(currEdge != null){
                    if(currEdge.destination.vertexInfo.compareTo(destination) == 0) return currEdge.weight;
                    currEdge = currEdge.nextEdge;
                }
            }
            sourceVertex = sourceVertex.nextVertex;
        }
        return null;
    }

    public ArrayList<T> getNeighbours(T t){
        ArrayList<T> list = new ArrayList<>();
        Vertex<T,N> curr = head;
        while(curr!= null){
            if(curr.vertexInfo.compareTo(t) == 0){
                Edge<T,N> currEdge = curr.firstEdge;
                while(currEdge != null){
                    list.add(currEdge.destination.vertexInfo);
                    currEdge = currEdge.nextEdge;
                }
            }
            curr = curr.nextVertex;
        }
        return list;
    }

    public void printEdges(){
        Vertex<T,N> curr = head;
        while(curr != null){
            System.out.print(curr.vertexInfo);
            Edge<T,N> currEdge = curr.firstEdge;
            while(currEdge != null){
                System.out.print( " -> " + currEdge.destination.vertexInfo);
                currEdge = currEdge.nextEdge;
            }
            curr = curr.nextVertex;
            System.out.println();
        }
    }
}

class Vertex<T extends Comparable<T>, N extends Comparable<N>>{
    T vertexInfo;
    int inDeg;
    int outDeg;
    Vertex<T,N> nextVertex;
    Edge<T,N> firstEdge;
    
    public Vertex(){
        this.vertexInfo = null;
        this.inDeg = 0;
        this.outDeg = 0;
        this.nextVertex = null;
        this.firstEdge = null;
    }

    public Vertex(T vertexInfo){
        this.vertexInfo = vertexInfo;
        this.inDeg = 0;
        this.outDeg = 0;
        this.nextVertex = null;
        this.firstEdge = null;
    }

    public Vertex(T vertexInfo, Vertex <T,N> next) {
        this.vertexInfo = vertexInfo;
        this.inDeg = 0;
        this.outDeg = 0;
        this.nextVertex = next;
        this.firstEdge = null;
    }
}

class Edge<T extends Comparable<T>, N extends Comparable<N>>{
    Vertex<T,N> destination;
    N weight;
    Edge<T,N> nextEdge;

    public Edge(Vertex<T,N> destination, N weight, Edge<T,N> nextEdge) {
        this.destination = destination;
        this.weight = weight;
        this.nextEdge = nextEdge;
    }
}
