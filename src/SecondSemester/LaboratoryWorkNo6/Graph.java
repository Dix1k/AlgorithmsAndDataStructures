package LaboratoryWorkNo6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private final int maxVertex;
    private Vertex[] vertexList;
    private List<List<Integer>> adjacencyList;
    private int vertexNumber;
    private Queue queue;

    public Graph(int maxVertex) {
        this.maxVertex = maxVertex;
        this.vertexList = new Vertex[maxVertex];
        this.adjacencyList = new ArrayList<>(maxVertex);
        this.vertexNumber = 0;

        for (int i = 0; i < maxVertex; i++) {
            adjacencyList.add(new LinkedList<>());
        }

        this.queue = new Queue(maxVertex);
    }

    public void addVertex(char label) {
        vertexList[vertexNumber++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjacencyList.get(start).add(end);
        adjacencyList.get(end).add(start);
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].getLabel() + " ");
    }

    public void breadthFirstTraversal() {
        vertexList[0].setVisited(true);
        displayVertex(0);
        queue.insert(0);

        int v2;
        while (!queue.isEmpty()) {
            int v1 = queue.remove();

            while ((v2 = getUnvisitedVertex(v1)) != -1) {
                vertexList[v2].setVisited(true);
                displayVertex(v2);
                queue.insert(v2);
            }
        }

        // Сброс посещённых вершин
        for (int i = 0; i < vertexNumber; i++) {
            vertexList[i].setVisited(false);
        }
    }

    private int getUnvisitedVertex(int index) {
        for (int neighbor : adjacencyList.get(index)) {
            if (!vertexList[neighbor].isVisited()) {
                return neighbor;
            }
        }
        return -1;
    }
}