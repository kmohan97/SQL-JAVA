import java.sql.*;
import java.io.*;
public class Retrieve
{
public static void main(String sdf[])
{
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
PreparedStatement ps=cn.prepareStatement("Select * from  stud1");
ResultSet rs=ps.executeQuery();
while(rs.next())
{
byte bb[]=rs.getBytes(1);

ByteArrayInputStream bis=new ByteArrayInputStream(bb);
ObjectInputStream ois=new ObjectInputStream(bis);

stud1 aa=(stud1)ois.readObject();
System.out.println(aa.name+"\t"+aa.roll+"\t"+aa.fee);

}
ps.close();
cn.close();
}catch(SQLException se)
{
se.printStackTrace();
}
catch(ClassNotFoundException ve)
{
ve.printStackTrace();
}
catch(IOException see)
{
see.printStackTrace();
}


}
}