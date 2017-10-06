public class Faculty extends Employee {
    public static String Teacher= "Teacher";
    public static String Assistant = "Assistant";
    public static String Proffessor = "Professor";
    protected String officeHours;
    protected String rank;
    public Faculty(String name) {
        this(name, "9:00 | 18:00", "Employee");
    }
    public Faculty(String name, String officeHours, String rank) {
        super(name);
        this.officeHours = officeHours;
        this.rank = rank;
    }
    public String getOfficeHours() {
        return officeHours;
    }
    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }
    public String getRank() {
        return rank;
    }
    public void setRank(String rank) {
        this.rank = rank;
    }
    public String toString() {
        return "Name: " + getName() + " Class: " + this.getClass().getName();
    }
}