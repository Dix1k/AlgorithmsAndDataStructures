package LaboratoryWorkNo7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DirectedGraph {
    private final int maxVertex;
    private Vertex[] vertexList;
    private List<List<Integer>> adjacencyList;
    private int vertexNumber;

    public DirectedGraph(int maxVertex) {
        this.maxVertex = maxVertex;
        this.vertexList = new Vertex[maxVertex];
        this.adjacencyList = new ArrayList<>(maxVertex);
        this.vertexNumber = 0;

        for (int i = 0; i < maxVertex; i++) {
            adjacencyList.add(new LinkedList<>());
        }
    }

    public void addVertex(char label) {
        vertexList[vertexNumber++] = new Vertex(label);
    }

    // Добавление направленного ребра
    public void addEdge(char startLabel, char endLabel) {
        int start = findVertexIndex(startLabel);
        int end = findVertexIndex(endLabel);
        if (start != -1 && end != -1) {
            adjacencyList.get(start).add(end);
        }
    }

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

    // Топологическая сортировка
    public void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertexNumber];
        boolean[] tempVisited = new boolean[vertexNumber]; // Для обнаружения циклов

        for (int i = 0; i < vertexNumber; i++) {
            if (!visited[i]) {
                if (topologicalSortUtil(i, visited, tempVisited, stack)) {
                    System.out.println("Граф содержит цикл, топологическая сортировка невозможна");
                    return;
                }
            }
        }

        System.out.println("Топологическая сортировка:");
        while (!stack.empty()) {
            displayVertex(stack.pop());
        }
    }

    private boolean topologicalSortUtil(int v, boolean[] visited, boolean[] tempVisited, Stack<Integer> stack) {
        if (tempVisited[v]) {
            return true; // Обнаружен цикл
        }

        if (visited[v]) {
            return false;
        }

        visited[v] = true;
        tempVisited[v] = true;

        for (int neighbor : adjacencyList.get(v)) {
            if (topologicalSortUtil(neighbor, visited, tempVisited, stack)) {
                return true;
            }
        }

        tempVisited[v] = false;
        stack.push(v);
        return false;
    }
}