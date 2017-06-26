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
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import de.rainer.basisanwendung.data.Data;

public class SpielePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPanel center;
	private JPanel right;

	private JPanel getCenter() {
		return this.center;
	}

	private void setCenter(JPanel center) {
		this.center = center;
	}

	private JPanel getRight() {
		return this.right;
	}

	private void setRight(JPanel right) {
		this.right = right;
	}

	public SpielePanel(JPanel center, JPanel right) {
		super();
		this.setCenter(center);
		this.setRight(right);
		this.init();
	}

	public SpielePanel() {
		this(new JPanel(), new JPanel());
	}

	private void init() {
		super.setLayout(new BorderLayout(5, 5));
		super.setBorder(new LineBorder(Color.BLACK, 2));
		super.setBackground(Color.WHITE);

		JPanel north = new JPanel();
		north.setBackground(Color.WHITE);
		JPanel east = new JPanel();
		east.setBackground(Color.WHITE);
		JPanel west = new JPanel();
		west.setBackground(Color.WHITE);
		JPanel south = new JPanel();
		south.setBackground(Color.WHITE);

		this.getCenter().setLayout(new BorderLayout(10, 10));

		JPanel left = new JPanel();
		left.setBorder(new LineBorder(Color.BLACK, 2));
		left.setBackground(Color.YELLOW);
		left.setLayout(new BorderLayout(5, 5));
		this.initLeft(left);

		this.getRight().setBorder(new LineBorder(Color.BLACK, 2));
		this.getRight().setBackground(Color.YELLOW);
		this.getRight().setLayout(new BorderLayout());
		JLabel label = new JLabel("Wähle ein Thema");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 30));
		this.getRight().add(label, BorderLayout.NORTH);

		this.getCenter().add(left, BorderLayout.WEST);
		this.getCenter().add(this.getRight(), BorderLayout.CENTER);

		super.add(north, BorderLayout.NORTH);
		super.add(east, BorderLayout.EAST);
		super.add(west, BorderLayout.WEST);
		super.add(south, BorderLayout.SOUTH);
		super.add(this.getCenter(), BorderLayout.CENTER);
	}

	private void initLeft(JPanel main) {
		JPanel north = new JPanel();
		north.setBackground(Color.YELLOW);
		JPanel east = new JPanel();
		east.setBackground(Color.YELLOW);
		JPanel west = new JPanel();
		west.setBackground(Color.YELLOW);
		JPanel south = new JPanel();
		south.setBackground(Color.YELLOW);
		JPanel center = new JPanel();
		center.setBackground(Color.YELLOW);
		center.setLayout(new GridLayout(5, 1, 25, 25));

		JLabel thema = new JLabel("Thema", SwingConstants.CENTER);
		thema.setFont(new Font("Tahoma", Font.BOLD, 40));
		center.add(thema);

		JButton mathe = new JButton("Mathematik");
		mathe.setFont(new Font("Tahoma", Font.BOLD, 20));
		mathe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SpielePanel.this.switchRightPanel(e.getActionCommand());
			}
		});
		center.add(mathe);
		JButton deutsch = new JButton("Deutsch");
		deutsch.setFont(new Font("Tahoma", Font.BOLD, 20));
		deutsch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SpielePanel.this.switchRightPanel(e.getActionCommand());
			}
		});
		center.add(deutsch);
		JButton englisch = new JButton("Englisch");
		englisch.setFont(new Font("Tahoma", Font.BOLD, 20));
		englisch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SpielePanel.this.switchRightPanel(e.getActionCommand());
			}
		});
		center.add(englisch);
		JPanel logoutPanel = new JPanel();
		logoutPanel.setBackground(Color.YELLOW);
		logoutPanel.setLayout(new BorderLayout());
		JButton logout = new JButton("Logout");
		logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Data.getInstance().clearData();
				Data.getInstance().notifyAllObserver(true);
			}
		});
		logoutPanel.add(logout, BorderLayout.SOUTH);
		center.add(logoutPanel);
		main.add(north, BorderLayout.NORTH);
		main.add(east, BorderLayout.EAST);
		main.add(west, BorderLayout.WEST);
		main.add(south, BorderLayout.SOUTH);
		main.add(center, BorderLayout.CENTER);
	}

	private void switchRightPanel(String thema) {
		super.setVisible(false);
		this.getCenter().remove(this.getRight());
		JPanel right = new JPanel();
		right.setBorder(new LineBorder(Color.BLACK, 2));
		right.setBackground(Color.YELLOW);
		right.setLayout(new BorderLayout());
		switch (thema) {
		case "Mathematik": {
			JLabel mathe = new JLabel("Wähle ein Mathematikspiel");
			mathe.setFont(new Font("Tahoma", Font.BOLD, 30));
			mathe.setHorizontalAlignment(SwingConstants.CENTER);
			right.add(mathe, BorderLayout.NORTH);
			JPanel center = new JPanel();
			center.setBackground(Color.YELLOW);
			center.setLayout(new GridLayout(9, 9, 10, 10));
			JButton zahlenpyramide = new JButton("Zahlenpyramide");
			zahlenpyramide.setFont(new Font("Tahoma", Font.PLAIN, 25));
			zahlenpyramide.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Data.getInstance().setSpiel(e.getActionCommand());
					Data.getInstance().notifyAllObserver(true);
				}
			});
			JPanel jp = new JPanel();
			jp.setBackground(Color.YELLOW);
			center.add(jp);
			JPanel jpB = new JPanel();
			jpB.setBackground(Color.YELLOW);
			jpB.add(zahlenpyramide);
			center.add(jpB);
			right.add(center, BorderLayout.CENTER);
			break;
		}
		case "Deutsch": {
			JLabel deutsch = new JLabel("Wähle ein Deutschspiel");
			deutsch.setFont(new Font("Tahoma", Font.BOLD, 30));
			deutsch.setHorizontalAlignment(SwingConstants.CENTER);
			right.add(deutsch, BorderLayout.NORTH);
			JPanel center = new JPanel();
			center.setBackground(Color.YELLOW);
			center.setLayout(new GridLayout(9, 9, 10, 10));
			JButton buchstabensalat = new JButton("Buchstabensalat");
			buchstabensalat.setFont(new Font("Tahoma", Font.PLAIN, 25));
			buchstabensalat.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Data.getInstance().setSpiel(e.getActionCommand());
					Data.getInstance().notifyAllObserver(true);
				}
			});
			JPanel jp = new JPanel();
			jp.setBackground(Color.YELLOW);
			center.add(jp);
			JPanel jpB = new JPanel();
			jpB.setBackground(Color.YELLOW);
			jpB.add(buchstabensalat);
			center.add(jpB);
			right.add(center, BorderLayout.CENTER);
			break;
		}
		case "Englisch": {
			JLabel englisch = new JLabel("Wähle ein Englischspiel");
			englisch.setFont(new Font("Tahoma", Font.BOLD, 30));
			englisch.setHorizontalAlignment(SwingConstants.CENTER);
			right.add(englisch, BorderLayout.NORTH);
			break;
		}
		default: {
			break;
		}
		}
		this.setRight(right);
		this.getCenter().add(this.getRight(), BorderLayout.CENTER);
		super.setVisible(true);
	}
}