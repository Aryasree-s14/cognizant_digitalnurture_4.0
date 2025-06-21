package employeemanagement;

public class EmployeeManager {
    private Employee[] e;
    private int size;

    public EmployeeManager(int cap) {
        e = new Employee[cap];
        size = 0;
    }

    public void add(Employee emp) 
    {
        if (size < e.length) 
        {
            e[size++] = emp;
            System.out.println("Employee Added: " + emp);
        } 
        else 
        {
            System.out.println("Array is full.");
        }
    }

   
    public Employee search(int id) {
        for (int i = 0; i < size; i++) {
            if (e[i].getEmployeeId() == id) {
                return e[i];
            }
        }
        return null;
    }

    public boolean delete(int id) {
        for (int i = 0; i < size; i++) {
            if (e[i].getEmployeeId() == id) {
                for (int j = i; j < size - 1; j++) {
                    e[j] = e[j + 1];
                }
                e[--size] = null;
                return true;
            }
        }
        return false;
    }
    public void display() {
        System.out.println("\nEmployee List:");
        for (int i = 0; i < size; i++) {
            System.out.println(e[i]);
        }
    }
}
