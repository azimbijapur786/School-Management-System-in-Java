package GuiSwing2;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseForAttendanceConnect
{
	Connection con = null;
	java.sql.PreparedStatement pst;
	
	public static Connection dbconnect()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolmanagement","root","");
			return con;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
			
		}
	}

}
