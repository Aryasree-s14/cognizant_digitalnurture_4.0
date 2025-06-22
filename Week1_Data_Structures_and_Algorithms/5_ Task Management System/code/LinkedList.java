package taskmanagement;

public class LinkedList {
	
	private Node head;

    public void add(Task task) 
    {
        Node newNode = new Node(task);
        if (head == null) 
        {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null)
            {
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }
    public Task search(int taskId) 
    {
        Node curr = head;
        while (curr != null)
        {
            if (curr.t.taskId == taskId)
            {
                return curr.t;
            }
            curr = curr.next;
        }
        return null;
    }
    
    public boolean delete(int taskId) 
    {
        if (head == null) 
        	return false;

        if (head.t.taskId == taskId) 
        {
            head = head.next;
            return true;
        }
        Node curr = head;
        while (curr.next != null && curr.next.t.taskId != taskId) 
        {
            curr = curr.next;
        }

        if (curr.next == null) return false;

        curr.next = curr.next.next;
        return true;
    }
    public void traverse() {
        Node curr = head;
        while (curr!= null) {
            System.out.println(curr.t);
            curr= curr.next;
        }
    }
}
    


