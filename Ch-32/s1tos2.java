import java.sql.*;
import java.util.*;
public class s1tos2{
	public static void main(String[] args) throws Exception{
		ArrayList<String> list = new ArrayList<>();
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded ");
		Connection co = DriverManager.getConnection("jdbc:mysql://localhost/passwords","root","nurnur11");
		System.out.println("Database connected");
		Statement st = co.createStatement();
		ResultSet r = st.executeQuery("select * from Student1");
		while(r.next()){
			String s = "insert into Student2(username,password,firstname,lastname)";
			String[] h = r.getString(3).split(" ");
			String values = "values('"+r.getString(1)+"','"+r.getString(2)+"','"+h[0]+"','"+h[1]+"')";
			list.add(s+values);
		}
		r.close();
		System.out.println(list.get(0));
		for(int i = 0;i<list.size();i++)
			st.executeUpdate(list.get(i));
	}
}