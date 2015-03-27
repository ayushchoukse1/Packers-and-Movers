package packersandmovers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Idgenerator {
	static int num;
	static StringBuilder finalstring;
public  String tempfeed;
static String final_string,final_string1,final_string3_emp;
public StringBuilder string;
public StringBuilder tempfeed3;
	public Idgenerator() {
		// TODO Auto-generated constructor stub
		CustomerIdGenerator();
	}

	public static void main(String[] args) {
		new Idgenerator();
		// TODO Auto-generated method stub
	
	}

	public String feedBackIdGenerator() {
		 
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl","scott","palash");

			Statement st = con.createStatement();
			String temp = "SELECT feedbackid FROM feedback where ROWNUM<=1 order by feedbackid desc";
			ResultSet rs = st.executeQuery(temp);
			while (rs.next()) {
				String feed = rs.getString(1);
				System.out.println(feed);
				String tempfeed1 = feed.substring(0, 4);
				 tempfeed3=new StringBuilder(tempfeed1);
				tempfeed = feed.substring(4, 10);
				
				String tempfeed2 = String.valueOf(Integer.parseInt(tempfeed) + 1);
				int i=tempfeed2.length();
				System.out.println(i);
				if(i==1)
				{
					 string=new StringBuilder("00000");
					string.append(tempfeed2);
					tempfeed3.append(string);
					System.out.println(tempfeed3.toString());	
					final_string=tempfeed3.toString();
					
				}
				if(i==2)
				{
					 string=new StringBuilder("0000");
					string.append(tempfeed2);
					tempfeed3.append(string);
					System.out.println(tempfeed3);
					final_string=tempfeed3.toString();
					
				}
				if(i==3)
				{
					 string=new StringBuilder("000");
					string.append(tempfeed2);
					tempfeed3.append(string);
					System.out.println(tempfeed3);
					final_string=tempfeed3.toString();
					
				}
				if(i==4)
				{
					 string=new StringBuilder("00");
					string.append(tempfeed2);
					tempfeed3.append(string);
					System.out.println(tempfeed3);
					final_string=tempfeed3.toString();
					
				}
				if(i==5)
				{
					 string=new StringBuilder("0");
					string.append(tempfeed2);
					tempfeed3.append(string);
					System.out.println(tempfeed3);
					final_string=tempfeed3.toString();
					
				}
				
				if(i==6)
				{
					 string=new StringBuilder("");
					string.append(tempfeed2);
					tempfeed3.append(string);
					System.out.println(tempfeed3);
					final_string=tempfeed3.toString();
					
				}
			
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return final_string;
		
		
		
	}
	public String CustomerIdGenerator() {
	System.out.println(tempfeed+tempfeed3+final_string1);
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl","scott","palash");

			Statement st = con.createStatement();
			String temp = "SELECT customerid FROM client where ROWNUM<=1 order by customerid desc";
			ResultSet rs = st.executeQuery(temp);
			while (rs.next()) {
				String feed = rs.getString(1);
				System.out.println(feed);
				String tempfeed1 = feed.substring(0, 4);
				System.out.println(tempfeed1);
				StringBuilder tempfeed3=new StringBuilder(tempfeed1);
				tempfeed = feed.substring(4, 10);
				System.out.println(tempfeed);
				
				String tempfeed2 = String.valueOf(Integer.parseInt(tempfeed) + 1);
				System.out.println(tempfeed2);
				int i=tempfeed2.length();
				System.out.println(i);
				if(i==1)
				{
					StringBuilder string=new StringBuilder("00000");
					string.append(tempfeed2);
					tempfeed3.append(string);
					System.out.println(tempfeed3);	
					final_string1=tempfeed3.toString();
					
				}
				if(i==2)
				{
					StringBuilder string=new StringBuilder("0000");
					string.append(tempfeed2);
					tempfeed3.append(string);
					System.out.println(tempfeed3);
					final_string1=tempfeed3.toString();
					
				}
				if(i==3)
				{
					StringBuilder string=new StringBuilder("000");
					string.append(tempfeed2);
					tempfeed3.append(string);
					System.out.println(tempfeed3);
					final_string1=tempfeed3.toString();
					
				}
				if(i==4)
				{
					StringBuilder string=new StringBuilder("00");
					string.append(tempfeed2);
					tempfeed3.append(string);
					System.out.println(tempfeed3);
					final_string1=tempfeed3.toString();
					
				}
				if(i==5)
				{
					StringBuilder string=new StringBuilder("0");
					string.append(tempfeed2);
					tempfeed3.append(string);
					System.out.println(tempfeed3);
					final_string1=tempfeed3.toString();
					
				}
				
				if(i==6)
				{
					StringBuilder string=new StringBuilder("");
					string.append(tempfeed2);
					tempfeed3.append(string);
					System.out.println(tempfeed3);
					final_string1=tempfeed3.toString();
					
				}
			
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(final_string1);
		return final_string1;
		
		
	}
	public String EmployeeIdGenerator() {
		System.out.println(tempfeed+tempfeed3+final_string1);
			try {
				Class.forName("oracle.jdbc.OracleDriver");

				Connection con = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:orcl","scott","palash");

				Statement st = con.createStatement();
				String temp = "SELECT employeeid FROM employee where ROWNUM<=1 order by employeeid desc";
				ResultSet rs = st.executeQuery(temp);
				while (rs.next()) {
					String feed = rs.getString(1);
					System.out.println(feed);
					String tempfeed1 = feed.substring(0, 4);
					StringBuilder tempfeed3=new StringBuilder(tempfeed1);
					tempfeed = feed.substring(4, 10);
					
					String tempfeed2 = String.valueOf(Integer.parseInt(tempfeed) + 1);
					int i=tempfeed2.length();
					System.out.println(i);
					if(i==1)
					{
						StringBuilder string=new StringBuilder("00000");
						string.append(tempfeed2);
						tempfeed3.append(string);
						System.out.println(tempfeed3);	
						final_string3_emp=tempfeed3.toString();
						
					}
					if(i==2)
					{
						StringBuilder string=new StringBuilder("0000");
						string.append(tempfeed2);
						tempfeed3.append(string);
						System.out.println(tempfeed3);
						final_string3_emp=tempfeed3.toString();
						
					}
					if(i==3)
					{
						StringBuilder string=new StringBuilder("000");
						string.append(tempfeed2);
						tempfeed3.append(string);
						System.out.println(tempfeed3);
						final_string3_emp=tempfeed3.toString();
						
					}
					if(i==4)
					{
						StringBuilder string=new StringBuilder("00");
						string.append(tempfeed2);
						tempfeed3.append(string);
						System.out.println(tempfeed3);
						final_string3_emp=tempfeed3.toString();
						
					}
					if(i==5)
					{
						StringBuilder string=new StringBuilder("0");
						string.append(tempfeed2);
						tempfeed3.append(string);
						System.out.println(tempfeed3);
						final_string3_emp=tempfeed3.toString();
						
					}
					
					if(i==6)
					{
						StringBuilder string=new StringBuilder("");
						string.append(tempfeed2);
						tempfeed3.append(string);
						System.out.println(tempfeed3);
						final_string3_emp=tempfeed3.toString();
						
					}
				
				}
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(final_string3_emp);
			return final_string3_emp;
			
			
		}
}
