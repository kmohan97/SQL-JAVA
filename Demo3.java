import java.sql.*;
import java.util.*;
public class Demo3
{
public static void main(String ada[])
{
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
PreparedStatement ps=cn.prepareStatement("Select * from stud where roll=(?) and sqn=(?)");
ps.setInt(1,5);
ps.setString(2,"cde");
//ps.executeUpdate();
ResultSet rs=ps.executeQuery();
while(rs.next())
{
System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
}
ps.close();
cn.close();
}catch(ClassNotFoundException ce)
{
ce.printStackTrace();
}
catch(SQLException se)
{
se.printStackTrace();

}

}
}
