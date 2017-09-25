import java.io.*;
import java.util.*;
import java.sql.*;
//import java.text.*;
public class retrieveDoc
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
Reader rr=rs.getCharacterStream(2);
FileWriter fr=new FileWriter("f:/def.docx");
int ch;
while((ch=rr.read())!=-1)
{
fr.write(ch);
}
System.out.println("retrieved");
fr.close();
rr.close();

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
