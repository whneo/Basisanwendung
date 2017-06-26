package de.rainer.basisanwendung.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class Statistiken extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable adminTable;

	private JTable getAdminTable() {
		return this.adminTable;
	}

	private void setAdminTable(JTable adminTable) {
		this.adminTable = adminTable;
	}

	public Statistiken(JTable adminTable) {
		super();
		this.setAdminTable(adminTable);
		this.init();
	}

	public Statistiken() {
		this(new JTable());
	}

	private void init() {
		super.setLayout(new BorderLayout(25,25));
		super.setBackground(Color.YELLOW);
		super.setBorder(new LineBorder(Color.BLACK, 2));
		JPanel east = new JPanel();
		east.setOpaque(false);
		super.add(east, BorderLayout.EAST);
		JPanel west = new JPanel();
		west.setOpaque(false);
		super.add(west, BorderLayout.WEST);
		JPanel south = new JPanel();
		south.setOpaque(false);
		super.add(south, BorderLayout.SOUTH);
		JPanel north = new JPanel();
		north.setOpaque(false);
		JLabel label = new JLabel();
		label.setText("Statistiken");
		label.setFont(new Font("Tahoma", Font.BOLD, 30));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		north.add(label);
		this.initLeft();
		super.add(north, BorderLayout.NORTH);
		super.setVisible(true);
	}

	private void initLeft() {
		JPanel center = new JPanel();
		center.setOpaque(false);
		center.setLayout(new BorderLayout());
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
		center.add(left, BorderLayout.WEST);
		super.add(center, BorderLayout.CENTER);
	}
}
