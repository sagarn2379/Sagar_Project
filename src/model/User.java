package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable{
	
	private static final long serialVersionUID = 6297385302078200511L;
	
	private String fname;
	private String lname;
	private String email;
	private String telephone;
	private String password;
	private List<Application> applist;
	
	public User(String fname, String lname, String email, String telephone, String password) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.telephone = telephone;
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public List<Application> getApplist() {
		if(applist == null){
			applist = new ArrayList<Application>();
		}
		return applist;
	}

	public void setApplist(List<Application> applist) {
		
		this.applist = applist;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		
		return true;
	}

	@Override
	public String toString() {
		return "User [fname=" + fname + ", lname=" + lname + ", email=" + email + ", telephone=" + telephone
				+ ", password=" + password + "]";
	}

	
	
}