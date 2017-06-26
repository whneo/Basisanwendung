package de.rainer.basisanwendung.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import de.rainer.basisanwendung.datenbank.ElementaryDbManager;

public class Eltern {

	private int eltern_id;
	private String login;
	private String passwort;

	public int getEltern_Id() {
		return this.eltern_id;
	}

	public void setEltern_Id(int eltern_id) {
		this.eltern_id = eltern_id;
	}

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

	public Eltern(int eltern_id, String login, String passwort) {
		super();
		this.setEltern_Id(eltern_id);
		this.setLogin(login);
		this.setPasswort(passwort);
	}

	public Eltern() {
		this(0, "---", "passwort");
	}

	public Eltern(String login, String passwort) {
		this(0, login, passwort);
	}
	
	public Eltern(String login) {
		this(0, login, "passwort");
	}

	@Override
	public String toString() {
		return "Eltern [eltern_id=" + this.getEltern_Id() + ", login="
				+ this.getLogin() + ", passwort=" + this.getPasswort() + "]";
	}

	public Eltern getElternById(int eltern_id) {
		Eltern eltern = new Eltern();
		ResultSet rst = ElementaryDbManager.getInstance().getDbh()
				.select("SELECT * FROM Eltern WHERE eltern_id = " + eltern_id);
		try {
			while (rst.next()) {
				eltern.setEltern_Id(eltern_id);
				eltern.setLogin(rst.getString("login"));
				eltern.setPasswort(rst.getString("passwort"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rst != null) {
				try {
					rst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return eltern;
	}
	
	public boolean editElternLogin(String newLogin, String oldLogin) {
		boolean check = false;
		String selectQuery = "SELECT * FROM Eltern WHERE login = '" + newLogin
				+ "'";
		ResultSet rst = ElementaryDbManager.getInstance().getDbh().select(selectQuery);
		try {
			if (!rst.next()) {
				rst.close();
				String updateQuery = "UPDATE Eltern SET login = '" + newLogin
						+ "' WHERE login = '" + oldLogin + "'";
				ElementaryDbManager.getInstance().getDbh().execute(updateQuery);
				check = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	public void editElternPasswort(String newPasswort, String oldPasswort) {
		String updateQuery = "UPDATE Eltern SET passwort = '" + newPasswort
				+ "' WHERE passwort = '" + oldPasswort + "'";
		ElementaryDbManager.getInstance().getDbh().execute(updateQuery);
	}
	
	public ArrayList<Eltern> getAllEltern(){
		ArrayList<Eltern> eltern = new ArrayList<Eltern>();
		ResultSet rst = ElementaryDbManager.getInstance().getDbh().select("SELECT * FROM Eltern");
		try {
			while (rst.next()) {
				eltern.add(new Eltern(rst.getInt("eltern_id"), rst.getString("login"), rst.getString("passwort")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eltern;
	}

	public Eltern getElternByLogin(String newEltern) {
		Eltern eltern = null;
		ResultSet rst = ElementaryDbManager.getInstance().getDbh().select("SELECT * FROM Eltern WHERE login = '" + newEltern + "'");
		try {
			while (rst.next()) {
				eltern = new Eltern(rst.getInt("eltern_id"), rst.getString("login"), rst.getString("passwort"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eltern;
	}
}