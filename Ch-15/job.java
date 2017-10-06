public class job implements compare{
	public static void main(String[] args){
		job a=new job();
		job f=new job();
		a.abc(f);
	}
	public void abc(job l){
		System.out.print((this.a).equals(l));
	}
}