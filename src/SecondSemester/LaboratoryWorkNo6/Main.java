package LaboratoryWorkNo6;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(5);

        // Добавляем вершины (A, B, C, D, E)
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');

        // Добавляем рёбра, используя буквенные обозначения вершин
        graph.addEdge('A', 'B'); // A - B
        graph.addEdge('B', 'C'); // B - C
        graph.addEdge('A', 'D'); // A - D
        graph.addEdge('D', 'E'); // D - E

        System.out.println("Обход в ширину:");
        graph.breadthFirstTraversal('A'); // Начинаем обход с вершины A
    }
}