import java.sql.*;
import java.io.*;
import java.util.*;
public class quiz{
	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded ");
		Connection co=DriverManager.getConnection("jdbc:mysql://localhost/passwords","root","nurnur11");
		System.out.println("Database connected");
		for(int i=0;i<4;i++)System.out.println();
		Statement st=co.createStatement();
		ArrayList<String> list = new ArrayList<>();
		ArrayList<String> list2 = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int count=0;
		String res="";
		ResultSet r = st.executeQuery("select * from quiz1");
		while(r.next()){
			System.out.println(r.getString(2)+":");
			System.out.println("a:"+r.getString(3));
			System.out.println("b:"+r.getString(4));
			System.out.println("c:"+r.getString(5));
			list2.add(r.getString(6));
			System.out.print("Answer: ");
			String h = sc.nextLine();
			list.add(h);
			System.out.println();
		}
		int ar=0;
		for(int i=0;i<list.size();i++){
			if(list.get(i).equals(list2.get(i)))
				ar++;
		}
		System.out.println(""+ar+" true answers!!!");
	}
}