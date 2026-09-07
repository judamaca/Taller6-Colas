public class QueueNode {

    public Object dato;
    int priority;
    public QueueNode next;

    public QueueNode() {
        this.dato = null;
        this.priority = 0;
        this.next = null;
    }

    // Constructor que recibe solo el dato (para cola normal o por defecto)
    public QueueNode(Object dato) {
        this.dato = dato;
        this.priority = 0;
        this.next = null;
    }

    // Constructor que recibe el dato y la prioridad (para cola con prioridad)
    public QueueNode(Object dato, int priority) {
        this.dato = dato;
        this.priority = priority;
        this.next = null;
    }
}
