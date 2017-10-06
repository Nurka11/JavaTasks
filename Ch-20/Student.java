public class Student {
	private String name;
	private int id;
	Student(String name,int id){
		this.name=name;
		this.id=id;
	}
	public int getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public int compareTo(Student s){
		if(getName().equals(s.getName()))return 0;
		return 1;
	}
}