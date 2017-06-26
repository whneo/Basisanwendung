package de.rainer.basisanwendung.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import de.rainer.basisanwendung.datenbank.ElementaryDbManager;

public class Benutzer {

	private int benutzer_id;
	private String login;
	private String passwort;
	private String vorname;
	private String nachname;
	private Eltern eltern;
	private Lehrer lehrer;

	public int getBenutzer_id() {
		return this.benutzer_id;
	}

	public void setBenutzer_id(int benutzer_id) {
		this.benutzer_id = benutzer_id;
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

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public Eltern getEltern() {
		return eltern;
	}

	public void setEltern(Eltern eltern) {
		this.eltern = eltern;
	}

	public Lehrer getLehrer() {
		return lehrer;
	}

	public void setLehrer(Lehrer lehrer) {
		this.lehrer = lehrer;
	}

	public Benutzer(int benutzer_id, String login, String passwort,
			String vorname, String nachname, Eltern eltern, Lehrer lehrer) {
		super();
		this.setBenutzer_id(benutzer_id);
		this.setLogin(login);
		this.setPasswort(passwort);
		this.setVorname(vorname);
		this.setNachname(nachname);
		this.setEltern(eltern);
		this.setLehrer(lehrer);
	}

	public Benutzer() {
		this(0, "login", "passwort", "vorname", "nachname", new Eltern(),
				new Lehrer());
	}

	public Benutzer(String vorname, String nachname) {
		this(0, "login", "passwort", vorname, nachname, new Eltern(),
				new Lehrer());
	}

	public Benutzer(String login, String passwort, String vorname,
			String nachname, Eltern eltern, Lehrer lehrer) {
		this(0, login, passwort, vorname, nachname, eltern, lehrer);
	}

	@Override
	public String toString() {
		return "Benutzer [benutzer_id=" + this.getBenutzer_id() + ", login="
				+ this.getLogin() + ", passwort=" + this.getPasswort()
				+ ", vorname=" + this.getVorname() + ", nachname="
				+ this.getNachname() + ", eltern=" + this.getEltern()
				+ ", lehrer=" + this.getLehrer() + "]";
	}

	public ArrayList<Benutzer> getAllBenutzer() {
		ArrayList<Benutzer> benutzer = new ArrayList<Benutzer>();
		String query = "SELECT * FROM Benutzer";
		ResultSet rst = ElementaryDbManager.getInstance().getDbh().select(query);
		try {
			while (rst.next()) {
				benutzer.add(new Benutzer(rst.getInt("benutzer_id"), rst
						.getString("login"), rst.getString("passwort"), rst
						.getString("vorname"), rst.getString("nachname"),
						new Eltern().getElternById(rst.getInt("eltern_id")),
						new Lehrer().getLehrerById(rst.getInt("lehrer_id"))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return benutzer;
	}

	public ArrayList<Benutzer> getBenutzerByAdminId(String adminTyp, int adminId) {
		ArrayList<Benutzer> benutzer = new ArrayList<Benutzer>();
		String query = "";
		switch (adminTyp) {
		case "Lehrer": {
			query = "SELECT * FROM Benutzer WHERE lehrer_id = " + adminId;
			break;
		}
		case "Eltern": {
			query = "SELECT * FROM Benutzer WHERE eltern_id = " + adminId;
			break;
		}
		}
		ResultSet rst = ElementaryDbManager.getInstance().getDbh().select(query);
		try {
			while (rst.next()) {
				benutzer.add(new Benutzer(rst.getInt("benutzer_id"), rst
						.getString("login"), rst.getString("passwort"), rst
						.getString("vorname"), rst.getString("nachname"),
						new Eltern().getElternById(rst.getInt("eltern_id")),
						new Lehrer().getLehrerById(rst.getInt("lehrer_id"))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return benutzer;
	}

	public ArrayList<Benutzer> vergleicheBenutzerListen(
			ArrayList<Benutzer> adminBenutzer) {
		ArrayList<Benutzer> benutzerOhneAdminBenutzer = new ArrayList<Benutzer>();
		ArrayList<Benutzer> alleBenutzer = this.getAllBenutzer();
		for (int i = 0; i < alleBenutzer.size(); i++) {
			boolean check = false;
			for (int j = 0; j < adminBenutzer.size(); j++) {
				if (adminBenutzer.get(j).getLogin()
						.equals(alleBenutzer.get(i).getLogin())) {
					check = true;
				}
			}
			if (!check) {
				benutzerOhneAdminBenutzer.add(alleBenutzer.get(i));
			}
		}
		return benutzerOhneAdminBenutzer;

	}

	public Benutzer getBenutzerByLogin(String login) {
		Benutzer benutzer = null;
		String query = "SELECT * FROM Benutzer WHERE login = '" + login + "'";
		ResultSet rst = ElementaryDbManager.getInstance().getDbh().select(query);
		try {
			while (rst.next()) {
				benutzer = new Benutzer(rst.getInt("benutzer_id"),
						rst.getString("login"), rst.getString("passwort"),
						rst.getString("vorname"), rst.getString("nachname"),
						new Eltern().getElternById(rst.getInt("eltern_id")),
						new Lehrer().getLehrerById(rst.getInt("lehrer_id")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return benutzer;
	}

	public boolean editBenutzerLogin(String newLogin, String oldLogin) {
		boolean check = false;
		String selectQuery = "SELECT * FROM Benutzer WHERE login = '"
				+ newLogin + "'";
		ResultSet rst = ElementaryDbManager.getInstance().getDbh().select(selectQuery);
		try {
			if (!rst.next()) {
				rst.close();
				String updateQuery = "UPDATE Benutzer SET login = '" + newLogin
						+ "' WHERE login = '" + oldLogin + "'";
				ElementaryDbManager.getInstance().getDbh().execute(updateQuery);
				check = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	public void editBenutzerPasswort(String newPasswort, String oldPasswort) {
		String updateQuery = "UPDATE Benutzer SET passwort = '" + newPasswort
				+ "' WHERE passwort = '" + oldPasswort + "'";
		ElementaryDbManager.getInstance().getDbh().execute(updateQuery);
	}

	public void editBenutzerVorname(String newVorname, String oldVorname) {
		String updateQuery = "UPDATE Benutzer SET vorname = '" + newVorname
				+ "' WHERE vorname = '" + oldVorname + "'";
		ElementaryDbManager.getInstance().getDbh().execute(updateQuery);
	}

	public void editBenutzerNachname(String newNachname, String oldNachname) {
		String updateQuery = "UPDATE Benutzer SET nachname = '" + newNachname
				+ "' WHERE nachname = '" + oldNachname + "'";
		ElementaryDbManager.getInstance().getDbh().execute(updateQuery);
	}

	public void editBenutzerEltern(String newEltern, int benutzer_id) {
		String updateQuery = "";
		if (newEltern.equals("")) {
			updateQuery = "UPDATE Benutzer SET eltern_id = null WHERE benutzer_id = "
					+ benutzer_id;
		} else {
			updateQuery = "UPDATE Benutzer SET eltern_id = (SELECT eltern_id FROM Eltern WHERE login = '"
					+ newEltern + "') WHERE benutzer_id = " + benutzer_id;
		}
		ElementaryDbManager.getInstance().getDbh().execute(updateQuery);
	}

	public void editBenutzerLehrer(String newLehrer, int benutzer_id) {
		String updateQuery = "";
		if (newLehrer.equals("")) {
			updateQuery = "UPDATE Benutzer SET lehrer_id = null WHERE benutzer_id = "
					+ benutzer_id;
		} else {
			updateQuery = "UPDATE Benutzer SET lehrer_id = (SELECT lehrer_id FROM Lehrer WHERE login = '"
					+ newLehrer + "') WHERE benutzer_id = " + benutzer_id;
		}
		ElementaryDbManager.getInstance().getDbh().execute(updateQuery);
	}

	public int getBenutzerIdByLogin(String login) {
		int id = 0;
		String query = "SELECT benutzer_id FROM Benutzer WHERE login = '"
				+ login + "'";
		ResultSet rst = ElementaryDbManager.getInstance().getDbh().select(query);
		try {
			if (rst.next()) {
				id = rst.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	public void setBenutzerIntoDb(Benutzer benutzer) {
		String login = benutzer.getLogin();
		String passwort = benutzer.getPasswort();
		String vorname = benutzer.getVorname();
		String nachname = benutzer.getNachname();
		String query = "";
		if (benutzer.getEltern() == null) {
			if (benutzer.getLehrer() == null) {
				query = "INSERT INTO Benutzer (login, passwort, vorname, nachname) VALUES('"
						+ login
						+ "', '"
						+ passwort
						+ "', '"
						+ vorname
						+ "', '"
						+ nachname + "')";
			} else {
				query = "INSERT INTO Benutzer (login, passwort, vorname, nachname, lehrer_id) VALUES('"
						+ login
						+ "', '"
						+ passwort
						+ "', '"
						+ vorname
						+ "', '"
						+ nachname
						+ "', "
						+ benutzer.getLehrer().getLehrer_Id() + ")";
			}
		} else {
			if (benutzer.getLehrer() == null) {
				query = "INSERT INTO Benutzer (login, passwort, vorname, nachname, eltern_id) VALUES('"
						+ login
						+ "', '"
						+ passwort
						+ "', '"
						+ vorname
						+ "', '"
						+ nachname
						+ "', "
						+ benutzer.getEltern().getEltern_Id() + ")";
			} else {
				query = "INSERT INTO Benutzer (login, passwort, vorname, nachname, eltern_id, lehrer_id) VALUES('"
						+ benutzer.getLogin()
						+ "', '"
						+ benutzer.getPasswort()
						+ "', '"
						+ benutzer.getVorname()
						+ "', '"
						+ benutzer.getNachname()
						+ "', "
						+ benutzer.getEltern().getEltern_Id()
						+ ", "
						+ benutzer.getLehrer().getLehrer_Id() + ")";
			}
		}
		ElementaryDbManager.getInstance().getDbh().execute(query);
	}

	public void deleteBenutzer(String login) {
		String query = "DELETE FROM Benutzer WHERE login = '" + login + "'";
		ElementaryDbManager.getInstance().getDbh().execute(query);
	}

}