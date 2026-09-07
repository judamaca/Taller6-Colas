public class Queue implements QueueInterface{

    QueueNode head;
    QueueNode tail;
    int size = 0;
    boolean isPriorityQueue;

    // 1
    @Override
    public void clear() {
        size = 0;
        this.head = null;
        this.tail = null;
    }

    // 2
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    // 3
    @Override
    public Object extract() {
        if (this.head == null) return null;

        Object aux = head.dato;
        head = head.next;
        if (this.head == null) tail = null;
        size--;
        return aux;
    }

    // 4. Insert
    // Sin prioridad:
    @Override
    public boolean insert(Object object) {
        return insert(object, 0);
    }

    // Con prioridad;
    public boolean insert(Object object, int priority) {
        if (object == null) return false;
        QueueNode nuevo = new QueueNode(object, priority);

        if (head == null) {
            head = nuevo;
            tail = nuevo;
        }

        else if (!isPriorityQueue) {
            tail.next = nuevo;
            tail = nuevo;
        }

        else {
            if (priority < head.priority) {
                nuevo.next = head;
                head = nuevo;
            } else {
                QueueNode actual = head;
                while (actual.next != null && actual.next.priority <= priority) {
                    actual = actual.next;
                }
                nuevo.next = actual.next;
                actual.next = nuevo;

                if (nuevo.next == null) tail = nuevo;
            }
        }
        size++;
        return true;
    }

    // 5
    @Override
    public int size() { return size;}

    // 6
    @Override
    public boolean search(Object object) {
        if (head == null) return false;

        QueueNode actual = head;
        while (actual != null) {
            if (actual.dato == null ? object == null : actual.dato.equals(object)) {
                return true;
            }
            actual = actual.next;
        }
        return false;
    }

    @Override
    public String toString() {
        if (head == null) return "Cola vacía";

        StringBuilder sb = new StringBuilder("Head -> ");
        QueueNode actual = this.head;
        while (actual != null) {
            if (isPriorityQueue) {
                sb.append("[").append(actual.dato).append(" (p:").append(actual.priority).append(")] -> ");
            } else {
                sb.append("[").append(actual.dato).append("] -> ");
            }
            actual = actual.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
