package employeemanagement;

public class Main {

	public static void main(String[] args) {
		
		EmployeeManager m = new EmployeeManager(5);
		m.add(new Employee(1, "Ana", "Manager", 60000));
        m.add(new Employee(2, "Bill", "Software Developer", 90000));
        m.add(new Employee(3, "Carl", "Web Designer", 50000));
        
        m.display();
        
        Employee e = m.search(2);
        System.out.println("\n Result:");
        System.out.println(e != null ? e: "Employee not found");
        
        boolean deleted = m.delete(1);
        System.out.println("\n ID 102 deleted status: " + (deleted ? "Success" : "Failed"));
        m.display();

		

	}

}
