package de.rainer.basisanwendung.datenbank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ElementaryDbManager extends ElementaryDbConstants {

	private static ElementaryDbManager instance;
	private ElementaryDbConnector dbc;
	private ElementaryDbHandler dbh;

	public static ElementaryDbManager getInstance() {
		if (ElementaryDbManager.instance == null) {
			ElementaryDbManager.setInstance(new ElementaryDbManager());
		}
		return ElementaryDbManager.instance;
	}

	private static void setInstance(ElementaryDbManager instance) {
		ElementaryDbManager.instance = instance;
	}

	private ElementaryDbConnector getDbc() {
		return this.dbc;
	}

	private void setDbc(ElementaryDbConnector dbc) {
		this.dbc = dbc;
	}

	public ElementaryDbHandler getDbh() {
		return this.dbh;
	}

	private void setDbh(ElementaryDbHandler dbh) {
		this.dbh = dbh;
	}

	private ElementaryDbManager(ElementaryDbConnector dbc,
			ElementaryDbHandler dbh) {
		super();
		this.setDbc(dbc);
		this.setDbh(dbh);
	}

	private ElementaryDbManager() {
		this(ElementaryDbConnector.getInstance(), ElementaryDbHandler
				.getInstance());
	}

	public void createDatabase() {
		if (this.createDatabaseFile()) {
			String sql = this.readSqlFile(super.DDL_FILE);
			Statement st = null;
			try {
				Connection con = ElementaryDbConnector.getInstance().getCon();
				st = con.createStatement();
				st.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				this.getDbc().closeStatemant(st);
			}
			this.fillDatabase();
		}
	}

	private boolean createDatabaseFile() {
		boolean result = true;
		File file = new File(super.DB_PATH + super.DB_NAME);
		try {
			if (!file.exists()) {
				file.createNewFile();
			} else {
				result = false;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	private String readSqlFile(String fileName) {
		String zeile = "";
		String text = "";
		try {
			FileReader fr = new FileReader(super.DB_PATH + fileName);
			BufferedReader br = new BufferedReader(fr);
			while ((zeile = br.readLine()) != null) {
				text = text.concat(zeile);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;
	}

	private void fillDatabase() {
		String sql = this.readSqlFile(super.DML_FILE);
		Statement st = null;
		try {
			Connection con = ElementaryDbConnector.getInstance().getCon();
			st = con.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.getDbc().closeStatemant(st);
		}
	}

}