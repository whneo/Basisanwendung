package de.rainer.basisanwendung.datenbank;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ElementaryDbHandler {

	private static ElementaryDbHandler instance;
	private ElementaryDbConnector dbc;

	static ElementaryDbHandler getInstance() {
		if (ElementaryDbHandler.instance == null) {
			ElementaryDbHandler.setInstance(new ElementaryDbHandler());
		}
		return ElementaryDbHandler.instance;
	}

	private static void setInstance(ElementaryDbHandler instance) {
		ElementaryDbHandler.instance = instance;
	}

	public ElementaryDbConnector getDbc() {
		return dbc;
	}

	private void setDbc(ElementaryDbConnector dbc) {
		this.dbc = dbc;
	}

	private ElementaryDbHandler(ElementaryDbConnector dbc) {
		super();
		this.setDbc(dbc);
	}

	private ElementaryDbHandler() {
		this(ElementaryDbConnector.getInstance());
	}

	public int execute(String query) {
		int id = 0;
		PreparedStatement pst = null;
		Statement st = null;
		try {
			pst = this.getDbc().getCon().prepareStatement(query);
			pst.executeUpdate();
			st = this.getDbc().getCon().createStatement();
			ResultSet rst = st.executeQuery("SELECT last_insert_rowid()");
			if (rst.next()) {
				id = rst.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.getDbc().closePreparedStatement(pst);
			this.getDbc().closeStatemant(st);
		}
		return id;
	}

	public ResultSet select(String query) {
		Statement st = null;
		ResultSet rst = null;
		try {
			st = this.getDbc().getCon().createStatement();
			rst = st.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rst;
	}
	
}