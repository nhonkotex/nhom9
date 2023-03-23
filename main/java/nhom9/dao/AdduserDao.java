package nhom9.dao;

import java.sql.Connection;





import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nhom9.connection.DbCon;
import nhom9.model.Adduser;
import nhom9.model.User;


public class AdduserDao {
	public int registerAdduser(Adduser adduser) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO User1" +
            "  (id, ten, email, password1, sodienthoai, diachi) VALUES " +
            " (?, ?, ?, ?, ?, ? );";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
        		.getConnection("jdbc:mysql://localhost:3306/nhom9","root","07191908");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, adduser.getId() );
            preparedStatement.setString(2, adduser.getName());
            preparedStatement.setString(3, adduser.getEmail());
            preparedStatement.setString(4, adduser.getPassword());
            preparedStatement.setString(5, adduser.getSodienthoai());
            preparedStatement.setString(6, adduser.getDiachi());
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    private Connection con;
   	private String query;
   	private PreparedStatement pst;
   	private ResultSet rs;
   	public AdduserDao(Connection con) {
   		this.con = con;
   	}
   	
   	public User  CheckUsername(String username)
    {
   		PreparedStatement stm = null;
  	  ResultSet rs = null;
  	Connection con = null;
  	 String query = "SELECT * FROM nhom9.User1 where ten = ? ";
  	 try {
  		con = DbCon.getConnetion();
  		stm = con.prepareStatement(query);
  		stm.setString(1, username);
  		rs = stm.executeQuery();
  		while(rs.next())
  		{
  			return new User(rs.getInt(1),
  					rs.getString(2),
  					rs.getString(3),
  					rs.getString(4));
  		}
  	} catch (Exception e) {
  		// TODO: handle exception
  	}
  	 
  	return null;
  	  
    }
   	
   	
   	public List<Adduser> getAllUser1() {
        List<Adduser> user= new ArrayList<>();
        try {

            query = "select * from User1";
            pst = this.con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
            	Adduser row = new Adduser();
                row.setId(rs.getInt("id"));
                row.setName(rs.getString("ten"));
                row.setEmail(rs.getString("email"));
                row.setPassword(rs.getString("password1"));
                row.setSodienthoai(rs.getString("sodienthoai"));
                row.setDiachi(rs.getString("diachi"));
                user.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return user;
	
}
    public void xoauser(int id) {
        //boolean result = false;
        try {
            query = "delete from User1 where id=?";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            pst.execute();
            //result = true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
        //return result;
    }
	
   
}
