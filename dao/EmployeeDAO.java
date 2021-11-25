package com.quinnox.training.empcrud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.quinnox.training.empcrud.model.Employee;

//DAO-- Data Access Object layer is used for communication with db
public class EmployeeDAO {
	
	public static Connection getConnection()
	{
		
		Connection con=null;
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			con=DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe","vaishu","redhat123");
			
		}
		catch(Exception e)
		{
			
		}
		return con;
		
	}

	public static List<Employee> getAllRecords(){
		List<Employee> list=new ArrayList<Employee>();
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from employees1");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Employee u=new Employee();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setSex(rs.getString("sex"));
				u.setCountry(rs.getString("country"));
				list.add(u);
			}
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	
	public static int save(Employee u){
		int status=0;
		long myId=0;
		try{
			Connection con=getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select empID_seq.NEXTVAL from dual");
			if(rs.next())
				myId=rs.getLong(1);
			
			
			PreparedStatement ps=con.prepareStatement(
					"insert into employees1(id,name,password,email,sex,country) values(?,?,?,?,?,?)");
			ps.setLong(1,myId);
			ps.setString(2,u.getName()); // ps.setString("Raj")
			ps.setString(3,u.getPassword());
			ps.setString(4,u.getEmail());
			ps.setString(5,u.getSex());
			ps.setString(6,u.getCountry());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static Employee getRecordById(int id){
		Employee u=null;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from employees1 where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				u=new  Employee();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setSex(rs.getString("sex"));
				u.setCountry(rs.getString("country"));
			}
		}catch(Exception e){System.out.println(e);}
		return u;
	}
	
	public static int updateUser(Employee u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement(
					"update employees1 set name=?,password=?,email=?,sex=?,country=? where id=?");
			ps.setString(1,u.getName());
			ps.setString(2,u.getPassword());
			ps.setString(3,u.getEmail());
			ps.setString(4,u.getSex());
			ps.setString(5,u.getCountry());
			ps.setInt(6,u.getId());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static int deleteUser(Employee u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("delete from employees1 where id=?");
			ps.setInt(1,u.getId());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}

		return status;
	}
	
	public static boolean loginEmployee(Employee u){
        boolean status=false;
        System.out.println(u.getEmail()+" "+u.getPassword());
        try{
            Connection con=getConnection();
            PreparedStatement ps=con.prepareStatement("select email,password from employees1 where "
                    +"email=? and password=?");
            ps.setString(1, u.getEmail());
            ps.setString(2, u.getPassword());

            ResultSet rs=ps.executeQuery();
            status=rs.next();
            while(rs.next())
            {
                System.out.println(rs.getString(1)+" "+rs.getString(2));
            }
        }catch(Exception e){System.out.println(e);}
        return status;
    }
}

