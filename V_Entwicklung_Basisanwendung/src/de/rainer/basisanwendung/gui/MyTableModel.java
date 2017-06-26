package de.rainer.basisanwendung.gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import de.rainer.basisanwendung.data.Data;
import de.rainer.basisanwendung.user.Benutzer;

public class MyTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private ArrayList<Benutzer> adminBenutzerListe;
	private String[] columnNames;
	private Object[][] data;
	private boolean spezialisiert;

	private ArrayList<Benutzer> getAdminBenutzerListe() {
		return this.adminBenutzerListe;
	}

	private void setAdminBenutzerListe(ArrayList<Benutzer> adminBenutzerListe) {
		this.adminBenutzerListe = adminBenutzerListe;
	}

	private String[] getColumnNames() {
		return this.columnNames;
	}

	private void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}

	private Object[][] getData() {
		return this.data;
	}

	private void setData(Object[][] data) {
		this.data = data;
	}

	private boolean isSpezialisiert() {
		return this.spezialisiert;
	}

	private void setSpezialisiert(boolean spezialisiert) {
		this.spezialisiert = spezialisiert;
	}

	public MyTableModel(boolean spezialisiert) {
		super();
		this.setSpezialisiert(spezialisiert);
		this.setColumnNames(this.createTableHeader());
		if (this.isSpezialisiert()) {
			this.setAdminBenutzerListe(new Benutzer().getBenutzerByAdminId(Data
					.getInstance().getUser().getLoginTyp(), Data.getInstance()
					.getUser().getId()));
		} else {
			this.setAdminBenutzerListe(new Benutzer()
					.vergleicheBenutzerListen(new Benutzer()
							.getBenutzerByAdminId(Data.getInstance().getUser()
									.getLoginTyp(), Data.getInstance()
									.getUser().getId())));
		}
		this.setData(this.createDataArray());
	}

	@Override
	public int getColumnCount() {
		return this.getColumnNames().length;
	}

	@Override
	public int getRowCount() {
		return this.getData().length;
	}

	public String getColumnName(int col) {
		return this.getColumnNames()[col];
	}

	public Object getValueAt(int row, int col) {
		return this.getData()[row][col];
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	public boolean isCellEditable(int row, int col) {
		return false;
	}

	@Override
	public void setValueAt(Object value, int row, int col) {
		this.getData()[row][col] = value;
		fireTableCellUpdated(row, col);
	}

	private String[] createTableHeader() {
		String[] columnNames = { "<html><h2>Login</h2></html>", "<html><h2>Vorname</h2></html>",
				"<html><h2>Nachname</h2></html>" };
		return columnNames;
	}

	private Object[][] createDataArray() {
		Object[][] data = new Object[this.getAdminBenutzerListe().size()][3];
		for (int i = 0; i < this.getAdminBenutzerListe().size(); i++) {
			data[i][0] = this.getAdminBenutzerListe().get(i).getLogin();
			data[i][1] = this.getAdminBenutzerListe().get(i).getVorname();
			data[i][2] = this.getAdminBenutzerListe().get(i).getNachname();
		}
		return data;
	}
}
