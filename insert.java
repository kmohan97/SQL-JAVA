import java.io.*;
import java.util.*;
import java.sql.*;
import java.text.*;
public class insert
{
public static void main(String asd[])
{
try{
Scanner ss=new Scanner(System.in);
int roll=ss.nextInt();
String name="mohan";
String dob="12/12/1945";
String doj="15/12/3050";

SimpleDateFormat sdf1=new SimpleDateFormat("dd/MM/yyyy");
java.util.Date udob=sdf1.parse(dob);
java.util.Date sqdob=new java.sql.Date(udob.getTime());
System.out.println(udob);

System.out.println(sqdob);
SimpleDateFormat sdf2=new SimpleDateFormat("dd/MM/yyyy");
java.util.Date udoj=sdf2.parse(doj);
java.util.Date sqdoj=new java.sql.Date(udoj.getTime());
System.out.println(udoj);

System.out.println(sqdoj);
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
PreparedStatement ps=cn.prepareStatement("insert into stud2 values(?,?,?,?)");

ps.setInt(1,roll);
ps.setString(2,name);
ps.setDate(3,(java.sql.Date)sqdob);
ps.setDate(4,(java.sql.Date)sqdoj);
int i=ps.executeUpdate();
if(i==1)
System.out.println("INserted");
else
System.out.println("Not Inserted");
ps.close();
cn.close();
}
catch(ClassNotFoundException ce)
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