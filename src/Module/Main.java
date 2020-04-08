package Module;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		System.out.println("1. Register Here.");
		System.out.println("2. Login");
		int x;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		x = Integer.parseInt(br.readLine().trim());

		// Objects
		RegisterPojo regpojo = new RegisterPojo();
		RegisterDAO regDao = new RegisterDAO();
		LoginPojo login = new LoginPojo();
		LoginDAO logDao = new LoginDAO();
		
		switch(x) {
		case 1:
			System.out.println("Enter first name : ");
			String firstname = br.readLine();
			System.out.println("Enter last name : ");
			String lastname = br.readLine();
			System.out.println("Enter username : ");
			String username = br.readLine();
			System.out.println("Enter password : ");
			String password = br.readLine();
			System.out.println("Enter Email : ");
			String email = br.readLine();
			
			regpojo.setFirstname(firstname);
			regpojo.setLastname(lastname);
			regpojo.setUsername(username);
			regpojo.setPassword(password);
			regpojo.setEmail(email);
			
			regDao.addUser(regpojo);
			break;
			
		case 2:
			System.out.println("Enter username : ");
			String name = br.readLine();
			System.out.println("Enter password : ");
			String pass = br.readLine();
			login.setUsername(name);
			login.setPassword(pass);
			
			if(logDao.validate(login)==true) {
				Luck luck = new Luck();
				luck.display();
			}else {
				System.out.println("Incorrect username and password.");
			}
			break;
		}
		
		
	
	}
}
