public class homework {

    public static void main(String[] args) {

        Person person = new Person("Nurzhan");
        Student student = new Student("Nurzhan");
        Employee employee = new Employee("Nurzhan");		
        Faculty faculty = new Faculty("Nurzhan");
        Staff staff = new Staff("Nurzhan");
        
		System.out.println(person.toString());
        System.out.println(student.toString());
        System.out.println(employee.toString());
        System.out.println(faculty.toString());
        System.out.println(staff.toString());

    }


}