public class Employee extends Person {
    protected double salary;
    protected String office;
    protected java.util.Date date;
	public Employee(String name){
		super(name);
	}
    public Employee(String name, double salary, String office, java.util.Date date) {
        super(name);
        this.salary = salary;
        this.office = office;
        this.date = date;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getOffice() {
        return office;
    }
    public void setOffice(String office) {
        this.office = office;
    }
    public java.util.Date getdate() {
        return date;
    }
    public void setdate(java.util.Date date) {
        this.date = date;
    }
    public String toString() {
        return "Name: " + getName() + " Class: " + this.getClass().getName();
    }
}