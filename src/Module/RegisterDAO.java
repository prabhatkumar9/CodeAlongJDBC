package Module;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO {
	public void addUser(RegisterPojo regpojo) throws ClassNotFoundException, SQLException {
		String firstname = regpojo.getFirstname();
		String lastname = regpojo.getLastname();
		String username = regpojo.getUsername();
		String password = regpojo.getPassword();
		String email = regpojo.getEmail();
		ConnectionManager cm = new ConnectionManager();
		// insert all the details in the database
		String sql = "insert into USERDETAILS(FIRSTNAME,LASTNAME,USERNAME,PASSWORD,EMAIL)VALUES(?,?,?,?,?)";
		// CREATE STATEMENT OBJECT
		PreparedStatement st = cm.getConnection().prepareStatement(sql);
		st.setString(1, firstname);
		st.setString(2, lastname);
		st.setString(3, username);
		st.setString(4, password);
		st.setString(5, email);
		st.executeUpdate();
		cm.getConnection().close();
	}
}
