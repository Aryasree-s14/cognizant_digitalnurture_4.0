package mvcpattern;

public class Main {

	public static void main(String[] args) 
	{
		Student student = new Student("Emma", "2310", "B");
        StudentView view = new StudentView();

        StudentController controller = new StudentController(student, view);
        controller.updateView();

        controller.setStudentName("Emma gomes");
        controller.setStudentGrade("A");

        controller.updateView();
    }

		

	}


