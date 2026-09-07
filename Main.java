void main() {
    Queue queue = new Queue();
    queue.isPriorityQueue = true; // Se activa el modo de prioridad

    System.out.println("isEmpty: " + queue.isEmpty());

    System.out.println("insert C (p:3): " + queue.insert("C", 3));
    System.out.println("insert A (p:1): " + queue.insert("A", 1));
    System.out.println("insert B (p:2): " + queue.insert("B", 2));

    System.out.println("size: " + queue.size());
    System.out.println("search 'B': " + queue.search("B"));
    System.out.println("toString: " + queue);

    System.out.println("extract (mayor prioridad): " + queue.extract());
    System.out.println("size after extract: " + queue.size());
    System.out.println("toString after extract: " + queue);

    queue.clear();
    System.out.println("isEmpty after clear: " + queue.isEmpty());
    System.out.println("size after clear: " + queue.size());
}