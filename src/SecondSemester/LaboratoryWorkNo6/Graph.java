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

    // Добавление ребра по буквенным обозначениям вершин
    public void addEdge(char startLabel, char endLabel) {
        int start = findVertexIndex(startLabel);
        int end = findVertexIndex(endLabel);
        if (start != -1 && end != -1) {
            adjacencyList.get(start).add(end);
            adjacencyList.get(end).add(start);
        }
    }

    // Поиск индекса вершины по её буквенному обозначению
    private int findVertexIndex(char label) {
        for (int i = 0; i < vertexNumber; i++) {
            if (vertexList[i].getLabel() == label) {
                return i;
            }
        }
        return -1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].getLabel() + " ");
    }

    // Обход в ширину, начиная с вершины с заданным буквенным обозначением
    public void breadthFirstTraversal(char startLabel) {
        int startIndex = findVertexIndex(startLabel);
        if (startIndex == -1) return;

        vertexList[startIndex].setVisited(true);
        displayVertex(startIndex);
        queue.insert(startIndex);

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