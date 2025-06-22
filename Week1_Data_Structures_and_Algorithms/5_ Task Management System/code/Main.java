package taskmanagement;

public class Main {

	public static void main(String[] args)
	{
		LinkedList taskList = new LinkedList();
		taskList.add(new Task(1, "Frontend", "In progress"));
        taskList.add(new Task(2, "Backend", "Pending"));
        taskList.add(new Task(3, "Testing", "Pending"));
        System.out.println("Tasks:");
        taskList.traverse();
        System.out.println("\nSearching Task ID 3:");
        Task found= taskList.search(3);
        if (found != null) 
        {
            System.out.println(found);
        } else 
        {
            System.out.println("Task not found.");
        }
        
        System.out.println("\nDeleting Task ID 2");
        boolean deleted = taskList.delete(2);
        System.out.println("Deleted Task: " + deleted);
        
        System.out.println("\nTasks:");
        taskList.traverse();
		

	}

}
