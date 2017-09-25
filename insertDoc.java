import java.io.*;
import java.util.*;
import java.sql.*;
//import java.text.*;
public class insertDoc
{
public static void main(String as[])
{
Scanner ss=new Scanner(System.in);
System.out.println("Eneter the roll");
int roll=ss.nextInt();
System.out.println("Eneter the path");
String path=ss.next();
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
PreparedStatement ps=cn.prepareStatement("insert into stud4 values(?,?)");
File f=new File(path);
FileReader fr=new FileReader(f);
int size=(int)f.length();
ps.setInt(1,roll);
ps.setCharacterStream(2,fr,size);
int k=ps.executeUpdate();
System.out.println(k);
ps.close();
fr.close();
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


