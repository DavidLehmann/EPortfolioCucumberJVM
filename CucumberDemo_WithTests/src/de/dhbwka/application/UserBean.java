package de.dhbwka.application;

public class UserBean {
	
	private String username;
	private String password;
	private boolean isAdmin;
	private boolean loginFailed = false;
	
	public boolean isLoginFailed() {
		return loginFailed;
	}
	public void setLoginFailed(boolean loginFailed) {
		this.loginFailed = loginFailed;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
