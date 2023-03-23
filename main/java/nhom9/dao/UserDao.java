package nhom9.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import nhom9.connection.DbCon;
import nhom9.model.User;

public class UserDao {
	private Connection con;

	private String query;
    private PreparedStatement pst;
    private ResultSet rs;

	public UserDao(Connection con) {
		this.con = con;
	}
	
	public User userLogin(String email, String password) {
		User user = null;
        try {
            query = "select * from User1 where email=? and password1=?";
           // query = "insert into user1(name,email,password) values(?,?,?)";
            pst = this.con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password);
       
            rs = pst.executeQuery();
            if(rs.next()){
            	user = new User();
            	user.setId(rs.getInt("id"));
            	user.setName(rs.getString("name"));
            	user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return user;
        
    }
	
	public List<User> getAllUser() {
        List<User> user= new ArrayList<>();
        try {

            query = "select * from User1";
            pst = this.con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
            	User row = new User();
                row.setId(rs.getInt("id"));
                row.setName(rs.getString("name"));
                row.setEmail(rs.getString("email"));
                row.setPassword(rs.getString("password1"));
              
                user.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return user;
	
}

	public User getSingleuser(int id) {
		User row = null;
	        try {
	            query = "select * from User1 where id=? ";
	           
	            pst = this.con.prepareStatement(query);
	            pst.setInt(1, id);
	            ResultSet rs = pst.executeQuery();

	            while (rs.next()) {
	            	row = new User();
	                row.setId(rs.getInt("id"));
	                row.setName(rs.getString("name"));
	                row.setEmail(rs.getString("email"));
	                row.setPassword(rs.getString("password1"));
	               
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }

	        return row;
	    }
	//tìm kiếm
	public List<User> searchLastName(String searchValue) throws SQLException, NamingException, Exception{
		   List<User> listAccounts;
		 
		   listAccounts = new ArrayList<>();
		   Connection con = null;
		   PreparedStatement stm = null;
		   ResultSet rs = null;
		   try {
			   con = DbCon.getConnetion();
			   if (con != null) {
				   String sql = "select * from User1 where name like? ";
				   stm = con.prepareStatement(sql);
				   stm.setString(1, "%" + searchValue + "%");
				   
				   rs = stm.executeQuery();
				   while (rs.next()) {
					   String name = rs.getString("name");
					   String email = rs.getString("email");
					   String password = rs.getString("password");
					  User dto = new User();
					  listAccounts.add(dto);
				   }
				   return listAccounts;
			   }
		   }finally {
			   
		   }
		
		   return null;
	   }
}
	
