package arhangel.dim.lesson6;


public class Node {
    String data;
    Node next;
    // нужно доделать связь в обратную сторону
    Node prev;

    public Node(String data, Node next) {
        this.data = data;
        this.next = next;
    }
}

