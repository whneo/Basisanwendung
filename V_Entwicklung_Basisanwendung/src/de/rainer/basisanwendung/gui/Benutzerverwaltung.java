package de.rainer.basisanwendung.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

import de.rainer.basisanwendung.data.Data;

public class Benutzerverwaltung extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable adminTable;
	private JTable otherTable;

	private JTable getAdminTable() {
		return this.adminTable;
	}

	private void setAdminTable(JTable adminTable) {
		this.adminTable = adminTable;
	}

	private JTable getOtherTable() {
		return this.otherTable;
	}

	private void setOtherTable(JTable otherTable) {
		this.otherTable = otherTable;
	}

	public Benutzerverwaltung(JTable adminTable, JTable otherTable) {
		super();
		this.setAdminTable(adminTable);
		this.setOtherTable(otherTable);
		this.init();
	}

	public Benutzerverwaltung() {
		this(new JTable(), new JTable());
	}

	private void init() {
		super.setBackground(Color.YELLOW);
		super.setBorder(new LineBorder(Color.BLACK, 2));
		super.setLayout(new BorderLayout(25, 25));
		JPanel east = new JPanel();
		east.setOpaque(false);
		super.add(east, BorderLayout.EAST);
		JPanel west = new JPanel();
		west.setOpaque(false);
		super.add(west, BorderLayout.WEST);
		JPanel north = new JPanel();
		north.setOpaque(false);
		JLabel ueberschrift = new JLabel(
				"<html><center>Benutzerverwaltung</center></html>");
		ueberschrift.setFont(new Font("Tahoma", Font.BOLD, 30));
		ueberschrift.setHorizontalAlignment(SwingConstants.CENTER);
		ueberschrift.setVerticalAlignment(SwingConstants.TOP);
		north.add(ueberschrift);
		super.add(north, BorderLayout.NORTH);
		JPanel south = new JPanel();
		south.setOpaque(false);
		super.add(south, BorderLayout.SOUTH);
		JPanel center = new JPanel();
		center.setOpaque(false);
		center.setLayout(new GridLayout(1, 3));

		// links kinder des admins
		JPanel left = new JPanel();
		left.setOpaque(false);
		left.setLayout(new BorderLayout(25, 25));
		JLabel label = new JLabel("<html><center>Ihre Benutzer</center></html>");
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.TOP);
		left.add(label, BorderLayout.NORTH);
		JPanel leftSpace = new JPanel();
		leftSpace.setOpaque(false);
		left.add(leftSpace, BorderLayout.EAST);

		this.getAdminTable().setModel(new MyTableModel(true));
		this.getAdminTable().addMouseListener(new BenutzerverwaltungListener());
		this.getAdminTable().setRowHeight(30);
		this.getAdminTable().setFont(new Font("Tahoma", Font.PLAIN, 15));
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		this.getAdminTable().getColumnModel().getColumn(0)
				.setCellRenderer(renderer);
		this.getAdminTable().getColumnModel().getColumn(1)
				.setCellRenderer(renderer);
		this.getAdminTable().getColumnModel().getColumn(2)
				.setCellRenderer(renderer);
		this.getAdminTable().setFillsViewportHeight(true);
		left.add(new JScrollPane(this.getAdminTable()), BorderLayout.CENTER);
		center.add(left);

		// mitte buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		buttonPanel.setLayout(null);
		JButton zurAdminListeDazu = new JButton("<<<");
		zurAdminListeDazu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int row : Benutzerverwaltung.this.getOtherTable()
						.getSelectedRows()) {
					String login = (String) Benutzerverwaltung.this
							.getOtherTable().getValueAt(row, 0);
					switch (Data.getInstance().getUser().getLoginTyp()) {
					case "Lehrer": {
						Data.getInstance()
								.getBenutzer()
								.editBenutzerLehrer(
										Data.getInstance().getUser()
												.getLoginBenutzer(),
										Data.getInstance().getBenutzer()
												.getBenutzerIdByLogin(login));
						break;
					}
					case "Eltern": {
						Data.getInstance()
								.getBenutzer()
								.editBenutzerEltern(
										Data.getInstance().getUser()
												.getLoginBenutzer(),
										Data.getInstance().getBenutzer()
												.getBenutzerIdByLogin(login));
						break;
					}
					}
				}
				Data.getInstance().notifyAllObserver(false);
			}
		});
		zurAdminListeDazu.setBounds(200, 200, 100, 25);
		buttonPanel.add(zurAdminListeDazu);
		JButton neuerBenutzer = new JButton("Benutzer erstellen");
		neuerBenutzer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new BenutzerErstellen();				
			}
		});
		neuerBenutzer.setBounds(150, 300, 200, 25);
		buttonPanel.add(neuerBenutzer);
		JButton vonAdminListeStreichen = new JButton(">>>");
		vonAdminListeStreichen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int row : Benutzerverwaltung.this.getAdminTable()
						.getSelectedRows()) {
					String login = (String) Benutzerverwaltung.this
							.getAdminTable().getValueAt(row, 0);
					switch (Data.getInstance().getUser().getLoginTyp()) {
					case "Lehrer": {
						Data.getInstance()
								.getBenutzer()
								.editBenutzerLehrer(
										"",
										Data.getInstance().getBenutzer()
												.getBenutzerIdByLogin(login));
						break;
					}
					case "Eltern": {
						Data.getInstance()
								.getBenutzer()
								.editBenutzerEltern(
										"",
										Data.getInstance().getBenutzer()
												.getBenutzerIdByLogin(login));
						break;
					}
					}
				}
				Data.getInstance().notifyAllObserver(false);
			}
		});
		vonAdminListeStreichen.setBounds(200, 400, 100, 25);
		buttonPanel.add(vonAdminListeStreichen);
		center.add(buttonPanel);

		// rechts alle anderen kinder
		JPanel right = new JPanel();
		right.setOpaque(false);
		right.setLayout(new BorderLayout(25, 25));
		JLabel labelR = new JLabel(
				"<html><center>Restliche Benutzer</center></html>");
		labelR.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelR.setHorizontalAlignment(SwingConstants.CENTER);
		labelR.setVerticalAlignment(SwingConstants.TOP);
		right.add(labelR, BorderLayout.NORTH);
		this.getOtherTable().setModel(new MyTableModel(false));
		this.getOtherTable().addMouseListener(new BenutzerverwaltungListener());
		this.getOtherTable().setRowHeight(30);
		this.getOtherTable().setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.getOtherTable().getColumnModel().getColumn(0)
				.setCellRenderer(renderer);
		this.getOtherTable().getColumnModel().getColumn(1)
				.setCellRenderer(renderer);
		this.getOtherTable().getColumnModel().getColumn(2)
				.setCellRenderer(renderer);
		JScrollPane scrollPaneR = new JScrollPane(this.getOtherTable());
		this.getOtherTable().setFillsViewportHeight(true);
		right.add(scrollPaneR, BorderLayout.CENTER);
		JPanel rightSpace = new JPanel();
		rightSpace.setOpaque(false);
		right.add(rightSpace, BorderLayout.WEST);
		center.add(right);

		super.add(center, BorderLayout.CENTER);
	}
}