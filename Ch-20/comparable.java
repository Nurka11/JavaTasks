public interface comparable extends Comparable<Student>{
	public int compareTo(Student s){
		if(getName().equals(s.getName()))return 0;
		return 1;
	}
}