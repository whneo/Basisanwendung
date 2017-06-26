package de.rainer.basisanwendung.datenbank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ElementaryDbConnector extends ElementaryDbConstants {

	private static ElementaryDbConnector instance;
	private Connection con;

	static ElementaryDbConnector getInstance() {
		if (ElementaryDbConnector.instance == null) {
			ElementaryDbConnector.setInstance(new ElementaryDbConnector());
		}
		return ElementaryDbConnector.instance;
	}

	private static void setInstance(ElementaryDbConnector instance) {
		ElementaryDbConnector.instance = instance;
	}

	Connection getCon() throws SQLException {
		if (this.con == null || this.con.isClosed()) {
			this.connect();
		}
		return this.con;
	}

	private void setCon(Connection con) {
		this.con = con;
	}

	private ElementaryDbConnector(Connection con) {
		super();
		this.setCon(con);
	}

	private ElementaryDbConnector() {
		this(null);
	}

	void connect() {
		try {
			Class.forName(super.CLASS_NAME);
			this.setCon(DriverManager.getConnection(super.CONNECTION));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void disconnect() {
		try {
			if (!this.getCon().isClosed()) {
				this.getCon().close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void closePreparedStatement(PreparedStatement pst) {
		try {
			if (pst != null) {
				pst.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void closeStatemant(Statement st) {
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeResultSet(ResultSet rst) {
		try {
			if (rst != null) {
				rst.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}