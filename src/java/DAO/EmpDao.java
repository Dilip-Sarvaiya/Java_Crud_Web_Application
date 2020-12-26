/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Dilip J Sarvaiya
 */
import java.util.*;  
import java.sql.*;  
import Pojo.Emp;
import java.io.IOException;
  
public class EmpDao {  
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            //Step-2 : Define the connection URL 
            String mysqlURL
                    = "jdbc:mysql://localhost:3307/java?user=root";
            con=DriverManager.getConnection(mysqlURL);  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
      public static int save(Emp obj)
   throws IOException {
          int rowsInserted = 0;
        try 
        {
            //Step-1 : Load the JDBC driver 
            Class.forName("com.mysql.jdbc.Driver");  // For MySQL

            //Step-2 : Define the connection URL 
            String mysqlURL
                    = "jdbc:mysql://localhost:3307/java?user=root";
        

            //Step-3 : Establish the connection 
            Connection con = DriverManager.getConnection(mysqlURL);

            //Step-4 : Create a PreparedStatement object 
            String sql = "INSERT INTO userdetails (email,password,conf_pass, age,branch,msg, gender, hobby) "
                    + "VALUES (?, ?, ?, ?,?,?,?,?)";

            //String sql = "UPDATE usersDetails " + 
             //       "SET password=?,conf_pass=?, age=?,branch=?,msg=?, gender=?, hobby=?" + 
              //    "WHERE username=?";
            //String sql = "DELET FROM Users " + 
            //        "WHERE username=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, obj.getEmail());
            st.setString(2, obj.getPass());
            st.setString(3, obj.getConf_pass());
            st.setInt(4, obj.getAge());
            st.setString(5, obj.getBranch());
            st.setString(6,obj.getMsg());
            st.setString(7,obj.getGender());
            st.setString(8,obj.getHobby());

            //Step-5 : Execute a query or update 
            rowsInserted = st.executeUpdate();

          

            //Step-7 : Close the connection 
            con.close();
    
        } catch (ClassNotFoundException cnfe) {
            System.err.println("Error loading driver:" + cnfe);
        } catch (SQLException sqle) {
            System.err.println("Error with connection:" + sqle);
        }
        return rowsInserted;
      }
     
       public static int update(Emp obj)
   throws IOException {
        int rowsUpdated=0;
        try 
        {
            //Step-1 : Load the JDBC driver 
            Class.forName("com.mysql.jdbc.Driver");  // For MySQL

            //Step-2 : Define the connection URL 
            String mysqlURL
                    = "jdbc:mysql://localhost:3307/java?user=root";
        

            //Step-3 : Establish the connection 
            Connection con = DriverManager.getConnection(mysqlURL);

            //Step-4 : Create a PreparedStatement object 
            //String sql = "INSERT INTO userdetails (email,password,conf_pass, age,branch,msg, gender, hobby) "
            //        + "VALUES (?, ?, ?, ?,?,?,?,?)";

            String sql = "UPDATE userdetails " + 
                    "SET email=?,password=?,conf_pass=?, age=?,branch=?,msg=?, gender=?, hobby=?" + 
                  "WHERE id=?";
            //String sql = "DELET FROM Users " + 
            //        "WHERE username=?";
            PreparedStatement st = con.prepareStatement(sql);
           
            st.setString(1,obj.getEmail());
            st.setString(2, obj.getPass());
            st.setString(3, obj.getConf_pass());
            st.setInt(4, obj.getAge());
            st.setString(5, obj.getBranch());
            st.setString(6,obj.getMsg());
            st.setString(7,obj.getGender());
            st.setString(8,obj.getHobby());
            st.setInt(9,obj.getId());
            

            //Step-5 : Execute a query or update 
            rowsUpdated = st.executeUpdate();

            System.out.println(rowsUpdated);

            //Step-7 : Close the connection 
            con.close();
    
        } catch (ClassNotFoundException cnfe) {
            System.err.println("Error loading driver:" + cnfe);
        } catch (SQLException sqle) {
            System.err.println("Error with connection:" + sqle);
        }
        return rowsUpdated;
     }
   
       public static int delete(int  id)
   throws IOException {
        int rowsDeleted=0;
        try 
        {   
            //Step-1 : Load the JDBC driver 
            Class.forName("com.mysql.jdbc.Driver");  // For MySQL

            //Step-2 : Define the connection URL 
            String mysqlURL
                    = "jdbc:mysql://localhost:3307/java?user=root";
        

            //Step-3 : Establish the connection 
            Connection con = DriverManager.getConnection(mysqlURL);

            //Step-4 : Create a PreparedStatement object 
            //String sql = "INSERT INTO userdetails (email,password,conf_pass, age,branch,msg, gender, hobby) "
            //        + "VALUES (?, ?, ?, ?,?,?,?,?)";

            String sql = "DELETE from userdetails " + 
                  "WHERE id=?";
            //String sql = "DELET FROM Users " + 
            //        "WHERE username=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
           

            //Step-5 : Execute a query or update 
            rowsDeleted = st.executeUpdate();

            System.out.println(rowsDeleted);

            //Step-7 : Close the connection 
            con.close();
    
        } catch (ClassNotFoundException cnfe) {
            System.err.println("Error loading driver:" + cnfe);
        } catch (SQLException sqle) {
            System.err.println("Error with connection:" + sqle);
        }
        return rowsDeleted;
     }
    public static Emp getEmployeeById(int id){  
        Emp e=new Emp();  
          
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from userdetails where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setEmail(rs.getString(2));  
                e.setPass(rs.getString(3));  
                e.setConf_pass(rs.getString(4));  
                e.setAge(rs.getInt(5));  
                e.setBranch(rs.getString(6));  
                e.setMsg(rs.getString(7));  
                e.setGender(rs.getString(8));  
                e.setHobby(rs.getString(9));  
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Emp> getAllEmployees(){  
        List<Emp> list=new ArrayList<Emp>();  
          
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from userdetails");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Emp e=new Emp();  
                e.setId(rs.getInt(1));  
                e.setEmail(rs.getString(2));  
                e.setPass(rs.getString(3));  
                e.setConf_pass(rs.getString(4));  
                e.setAge(rs.getInt(5));  
                e.setBranch(rs.getString(6));  
                e.setMsg(rs.getString(7));  
                e.setGender(rs.getString(8));  
                e.setHobby(rs.getString(9));  
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}