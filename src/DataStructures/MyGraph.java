package DataStructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyGraph {

    private int numberOfNode;
    private final Map<Integer, List<Integer>> adjacentList;

    public MyGraph() {
        this.numberOfNode = 0;
        this.adjacentList = new HashMap<>();
    }

    public void addVertex(int node) {
        adjacentList.computeIfAbsent(node, k -> {
            this.numberOfNode++;
            return new ArrayList<>();
        });
    }

    public void addEdge(int node1, int node2) {
        if (!adjacentList.containsKey(node1) || !adjacentList.containsKey(node2)) {
            System.out.println("The specified nodes don't exist");
        } else {
            List<Integer> listOfEdges = adjacentList.get(node1);
            if (!listOfEdges.contains(node2)) {
                listOfEdges.add(node2);
            }
        }
    }

    public void showConnections() {
        for (int n : this.adjacentList.keySet()) {
            System.out.println(n + ": " + this.adjacentList.get(n));
        }
    }

    public static void main(String[] args) {

        MyGraph myGraph = new MyGraph();
        myGraph.addVertex(0);
        myGraph.addVertex(1);
        myGraph.addVertex(2);
        myGraph.addVertex(3);
        myGraph.addVertex(4);
        myGraph.addVertex(5);
        myGraph.addVertex(6);
        myGraph.addEdge(3, 1);
        myGraph.addEdge(3, 4);
        myGraph.addEdge(4, 2);
        myGraph.addEdge(4, 5);
        myGraph.addEdge(1, 2);
        myGraph.addEdge(1, 0);
        myGraph.addEdge(0, 2);
        myGraph.addEdge(6, 5);

        myGraph.showConnections();

    }
}
