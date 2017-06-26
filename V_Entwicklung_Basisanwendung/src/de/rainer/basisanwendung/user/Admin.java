package de.rainer.basisanwendung.user;

public class Admin {

	private String login;
	private String passwort;

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPasswort() {
		return this.passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public Admin(String login, String passwort) {
		super();
		this.setLogin(login);
		this.setPasswort(passwort);
	}

	public Admin() {
		this("login", "passwort");
	}

	@Override
	public String toString() {
		return "Admin [login=" + this.getLogin() + ", passwort=" + this.getPasswort() + "]";
	}

}