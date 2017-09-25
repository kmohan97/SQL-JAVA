//24 is roll number;
//stud3
import java.io.*;
import java.util.*;
import java.sql.*;
//import java.text.*;
public class retrievePhoto
{
public static void main(String as[])
{
Scanner ss=new Scanner(System.in);
System.out.println("Eneter the roll");
int roll=ss.nextInt();
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
Statement st=cn.createStatement();
ResultSet rs=st.executeQuery("select * from stud3 where roll='"+roll+"'");
while(rs.next())
{
InputStream is=rs.getBinaryStream(3);
FileOutputStream fos=new FileOutputStream("c:/s1/awt/s2/sql/an.jpg");
int ch=0;
while((ch=is.read())!=-1)
{
fos.write(ch);
}
fos.close();
is.close();
System.out.println("retrieved");

}
st.close();
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
