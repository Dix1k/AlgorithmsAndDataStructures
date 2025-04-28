package LaboratoryWorkNo7;

public class Main {
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(6);

        // Добавляем вершины
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');

        // Добавляем направленные рёбра
        graph.addEdge('A', 'B');
        graph.addEdge('A', 'C');
        graph.addEdge('B', 'D');
        graph.addEdge('C', 'D');
        graph.addEdge('D', 'E');
        graph.addEdge('F', 'E');

        // Выполняем топологическую сортировку
        graph.topologicalSort();
    }
}