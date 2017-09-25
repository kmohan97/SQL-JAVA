import java.io.*;
import java.util.*;
import java.sql.*;
import java.text.*;
public class retrieveDate
{
public static void main(String as[])
{
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
Statement st=cn.createStatement();
ResultSet rs=st.executeQuery("Select * from stud2");
while(rs.next())
{
int roll=rs.getInt(1);
String name=rs.getString(2);
java.sql.Date sqdob=rs.getDate(3);
java.util.Date udob=(java.util.Date)sqdob;
SimpleDateFormat sdf1=new SimpleDateFormat("dd/MM/yyyy");
String dob=sdf1.format(udob);

java.sql.Date sqdoj=rs.getDate(4);
java.util.Date udoj=(java.util.Date)sqdoj;
SimpleDateFormat sdf2=new SimpleDateFormat("dd/MM/yyyy");
String doj=sdf2.format(udoj);

System.out.println(name+"\t"+roll+"\t"+dob+"\t"+doj);
}
st.close();
cn.close();
}catch(ClassNotFoundException ce)
{
ce.printStackTrace();
}
catch(SQLException se)
{
se.printStackTrace();
}
catch(Exception qe)
{
qe.printStackTrace();
}
}
}