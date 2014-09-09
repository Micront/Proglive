package arhangel.dim.lesson6;


public class List {
    // указатель на голову
    private Node head;


    public void add(String data) {
        // если головы еще нет, то создаем голову списка
        if (head == null) {
            head = new Node(data, null);
        } else {
            // если есть, то добавляем новый элемент в голову
            Node current = new Node(data, head);
            head = current;
        }
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        List list = new List();
        list.add("A");
        list.add("B");
        list.add("C");
        list.print();
    }
}
