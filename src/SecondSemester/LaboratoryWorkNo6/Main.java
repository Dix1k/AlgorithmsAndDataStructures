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

        // Добавляем рёбра
        graph.addEdge(0, 1); // A - B
        graph.addEdge(1, 2); // B - C
        graph.addEdge(0, 3); // A - D
        graph.addEdge(3, 4); // D - E

        System.out.println("Обход в ширину:");
        graph.breadthFirstTraversal(); // Ожидаемый вывод: A B D C E
    }
}