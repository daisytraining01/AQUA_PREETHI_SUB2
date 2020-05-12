package project.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DbProgram {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		ArrayList<String> recepients=new ArrayList<String>();
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","mysql");
		
		Statement st=con.createStatement();
		
		ResultSet rs=st.executeQuery("select * from receipient");
		
		while(rs.next()){
			
			recepients.add(rs.getString("name"));
			recepients.add(rs.getString("email"));
			recepients.add(rs.getString("pno"));
			recepients.add(rs.getString("accountno"));
			recepients.add(rs.getString("description"));
		}
		
		for(int i=0;i<recepients.size();i++) {
			
			System.out.println(""+recepients.get(i));
			
		}
		
	}

}
