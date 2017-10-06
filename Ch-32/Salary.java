import java.util.*;
import java.sql.*;
import java.net.*;
public class Salary{
	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded ");
		Connection co=DriverManager.getConnection("jdbc:mysql://localhost/passwords","root","nurnur11");
		System.out.println("Database connected");
		Statement st=co.createStatement();
		URL url = new URL("http://cs.armstrong.edu/liang/data/Salary.txt");
		Scanner sc = new Scanner(url.openStream());
		while(sc.hasNext()){
			String[] h = sc.nextLine().split("");
			String i = "insert into Salary(firstName,lastName,rank,salary)"+"values('"+h[0]+"','"+h[1]+"','"+h[2]+"',"+h[3]+")";
			st.executeUpdate(i);
		}
	}
}