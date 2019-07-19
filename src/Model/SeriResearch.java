package Model;

import java.io.Serializable;

import javax.swing.JTextField;

public class SeriResearch implements Serializable {

	private static final long serialVersionUID = 1L;
	//creating field for creating researchers details
	String resId, resName, resAddress, resPhone, resEmail, resUsername;
	//creating field for password as cahracter
	char[] resPassword;
	
	//constructor
	public SeriResearch(String resId,String resName,String resAddress,String resPhone,String resEmail,String resUsername,char[] resPassword) 
	{
		this.resId = resId;
		this.resName = resName;
		this.resAddress = resAddress;
		this.resPhone = resPhone;
		this.resEmail = resEmail;
		this.resUsername = resUsername;
		this.resPassword = resPassword;
	}

	//Default Constructor
	public SeriResearch() {

	}

	public String getResId() {
		return resId;
	}

	public void setResId(String resId) {
		this.resId = resId;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getResAddress() {
		return resAddress;
	}

	public void setResAddress(String resAddress) {
		this.resAddress = resAddress;
	}

	public String getResPhone() {
		return resPhone;
	}

	public void setResPhone(String resPhone) {
		this.resPhone = resPhone;
	}

	public String getResEmail() {
		return resEmail;
	}

	public void setResEmail(String resEmail) {
		this.resEmail = resEmail;
	}

	public String getResUsername() {
		return resUsername;
	}

	public void setResUsername(String resUsername) {
		this.resUsername = resUsername;
	}

	public char[] getResPassword() {
		return resPassword;
	}

	public void setResPassword(char[] resPassword) {
		this.resPassword = resPassword;
	}

	
}
