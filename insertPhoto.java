import java.io.*;
import java.util.*;
import java.sql.*;
//import java.text.*;
public class insertPhoto
{
public static void main(String as[])
{
Scanner ss=new Scanner(System.in);
System.out.println("Eneter the roll");
int roll=ss.nextInt();
System.out.println("Eneter the name:-");
String name=ss.next();
System.out.println("Eneter the path");
String path=ss.next();
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
PreparedStatement ps=cn.prepareStatement("insert into stud3 values(?,?,?)");
File f=new File(path);
FileInputStream fis=new FileInputStream(f);
int size=(int)f.length();
ps.setInt(1,roll);
ps.setString(2,name);
ps.setBinaryStream(3,fis,size);
int k=ps.executeUpdate();
System.out.println(k);
}