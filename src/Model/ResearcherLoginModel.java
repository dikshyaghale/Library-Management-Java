package Model;

import java.util.Arrays;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ResearcherLoginModel {
	private String userName;
	char[] password;
	
	public ResearcherLoginModel(String userName, char[] password) {
		this.userName = userName;
		this.password = password;
	}
	
	//check the two string values entered
	public boolean successLog(String userName, char[] password) {
		String serNme = getUserName();
		char[] serPss = getPassword();
		if(serNme.equals(userName)) {
			if(Arrays.equals(serPss, password)) {
				return true;
			}
			else {
				return false;
			}
				
		}
		return false;
	}

	//getters and setters
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public char[] getPassword() {
		return password;
	}
	public void setPassword(char[] cs) {
		this.password = cs;
	}

}
