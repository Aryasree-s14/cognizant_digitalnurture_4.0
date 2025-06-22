package taskmanagement;

public class Node {
	Task t;
    Node next;

    public Node(Task task) {
        this.t = task;
        this.next = null;
    }

}
