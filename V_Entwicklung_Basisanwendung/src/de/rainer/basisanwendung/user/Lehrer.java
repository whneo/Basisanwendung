package de.rainer.basisanwendung.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import de.rainer.basisanwendung.datenbank.ElementaryDbManager;

public class Lehrer {

	private int lehrer_id;
	private String login;
	private String passwort;

	public int getLehrer_Id() {
		return this.lehrer_id;
	}

	public void setLehrer_Id(int lehrer_id) {
		this.lehrer_id = lehrer_id;
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

	public Lehrer(int lehrer_id, String login, String passwort) {
		super();
		this.setLehrer_Id(lehrer_id);
		this.setLogin(login);
		this.setPasswort(passwort);
	}

	public Lehrer() {
		this(0, "---", "passwort");
	}

	public Lehrer(String login, String passwort) {
		this(0, login, passwort);
	}

	public Lehrer(String login) {
		this(0, login, "passwort");
	}

	@Override
	public String toString() {
		return "Lehrer [lehrer_id=" + this.getLehrer_Id() + ", login="
				+ this.getLogin() + ", passwort=" + this.getPasswort() + "]";
	}

	public Lehrer getLehrerById(int lehrer_id) {
		Lehrer lehrer = new Lehrer();
		ResultSet rst = ElementaryDbManager.getInstance().getDbh()
				.select("SELECT * FROM Lehrer WHERE lehrer_id = " + lehrer_id);
		try {
			while (rst.next()) {
				lehrer.setLehrer_Id(lehrer_id);
				lehrer.setLogin(rst.getString("login"));
				lehrer.setPasswort(rst.getString("passwort"));
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
		return lehrer;
	}

	public boolean editLehrerLogin(String newLogin, String oldLogin) {
		boolean check = false;
		String selectQuery = "SELECT * FROM Lehrer WHERE login = '" + newLogin
				+ "'";
		ResultSet rst = ElementaryDbManager.getInstance().getDbh().select(selectQuery);
		try {
			if (!rst.next()) {
				rst.close();
				String updateQuery = "UPDATE Lehrer SET login = '" + newLogin
						+ "' WHERE login = '" + oldLogin + "'";
				ElementaryDbManager.getInstance().getDbh().execute(updateQuery);
				check = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	public void editLehrerPasswort(String newPasswort, String oldPasswort) {
		String updateQuery = "UPDATE Lehrer SET passwort = '" + newPasswort
				+ "' WHERE passwort = '" + oldPasswort + "'";
		ElementaryDbManager.getInstance().getDbh().execute(updateQuery);
	}

	public ArrayList<Lehrer> getAllLehrer() {
		ArrayList<Lehrer> lehrer = new ArrayList<Lehrer>();
		ResultSet rst = ElementaryDbManager.getInstance().getDbh()
				.select("SELECT * FROM Lehrer");
		try {
			while (rst.next()) {
				lehrer.add(new Lehrer(rst.getInt("lehrer_id"), rst
						.getString("login"), rst.getString("passwort")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lehrer;
	}

	public Lehrer getLehrerByLogin(String newLehrer) {
		Lehrer lehrer = null;
		ResultSet rst = ElementaryDbManager.getInstance().getDbh().select("SELECT * FROM Lehrer WHERE login = '" + newLehrer + "'");
		try {
			while (rst.next()) {
				lehrer = new Lehrer(rst.getInt("lehrer_id"), rst.getString("login"), rst.getString("passwort"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lehrer;
	}
}