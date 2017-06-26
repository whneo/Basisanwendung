package de.rainer.basisanwendung.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import de.rainer.basisanwendung.data.Data;
import de.rainer.basisanwendung.data.IObserver;
import de.rainer.basisanwendung.gui.button.AdminNavButton;
import de.rainer.basisanwendung.gui.label.BasisLabel;
import de.rainer.basisanwendung.gui.panel.BasisPanel;

public class AdminPanel extends JPanel implements IObserver {

	private static final long serialVersionUID = 1L;
	private JPanel center;
	private JPanel aktion;
	private JLabel label;
	private JButton benutzerverwaltung;
	private JButton einstellungen;
	private JButton statistiken;
	private JButton accountverwaltung;
	private JButton logout;

	private JPanel getCenter() {
		return this.center;
	}

	private void setCenter(JPanel center) {
		this.center = center;
	}

	private JPanel getAktion() {
		return this.aktion;
	}

	private void setAktion(JPanel aktion) {
		this.aktion = aktion;
	}

	private JLabel getLabel() {
		return this.label;
	}

	private void setLabel(JLabel label) {
		this.label = label;
	}

	private JButton getBenutzerverwaltung() {
		return this.benutzerverwaltung;
	}

	private void setBenutzerverwaltung(JButton benutzerverwaltung) {
		this.benutzerverwaltung = benutzerverwaltung;
	}

	private JButton getEinstellungen() {
		return this.einstellungen;
	}

	private void setEinstellungen(JButton einstellungen) {
		this.einstellungen = einstellungen;
	}

	private JButton getStatistiken() {
		return this.statistiken;
	}

	private void setStatistiken(JButton statistiken) {
		this.statistiken = statistiken;
	}

	private JButton getAccountverwaltung() {
		return this.accountverwaltung;
	}

	private void setAccountverwaltung(JButton accountverwaltung) {
		this.accountverwaltung = accountverwaltung;
	}

	private JButton getLogout() {
		return this.logout;
	}

	private void setLogout(JButton logout) {
		this.logout = logout;
	}

	public AdminPanel(JPanel center, JPanel aktion, JLabel label,
			JButton benutzerverwaltung, JButton einstellungen,
			JButton statistiken, JButton accountverwaltung, JButton logout) {
		super();
		Data.getInstance().addObserver(this);
		this.setCenter(center);
		this.setAktion(aktion);
		this.setLabel(label);
		this.setBenutzerverwaltung(benutzerverwaltung);
		this.setEinstellungen(einstellungen);
		this.setStatistiken(statistiken);
		this.setAccountverwaltung(accountverwaltung);
		this.setLogout(logout);
		this.init();
	}

	public AdminPanel() {
		this(new BasisPanel(Color.WHITE, new BorderLayout(10, 10)),
				new BasisPanel(new LineBorder(Color.BLACK, 2), Color.YELLOW),
				new BasisLabel(new Font("Tahoma", Font.BOLD, 15),
						SwingConstants.CENTER), new AdminNavButton(
						"Benutzerverwaltung"), new AdminNavButton(
						"Einstellungen"), new AdminNavButton("Statistiken"),
				new AdminNavButton("Accountverwaltung"), new AdminNavButton(
						"Logout"));
	}

	private void init() {
		super.setLayout(new BorderLayout());
		super.setBorder(new LineBorder(Color.BLACK, 2));
		BasisPanel north = new BasisPanel(Color.WHITE);
		BasisPanel south = new BasisPanel(Color.WHITE);
		BasisPanel east = new BasisPanel(Color.WHITE);
		BasisPanel west = new BasisPanel(Color.WHITE);
		super.add(north, BorderLayout.NORTH);
		super.add(south, BorderLayout.SOUTH);
		super.add(east, BorderLayout.EAST);
		super.add(west, BorderLayout.WEST);
		this.initControl();
		BasisLabel label = new BasisLabel("Willkommen auf der Adminoberfläche",
				new Font("Tahoma", Font.BOLD, 30), SwingConstants.CENTER);
		this.getAktion().add(label);
		this.getCenter().add(this.getAktion(), BorderLayout.CENTER);
		super.add(this.getCenter(), BorderLayout.CENTER);
	}

	private void initControl() {
		BasisPanel control = new BasisPanel(new LineBorder(Color.BLACK, 2),
				Color.YELLOW, new BorderLayout());
		BasisPanel north = new BasisPanel(Color.YELLOW);
		BasisPanel south = new BasisPanel(Color.YELLOW);
		BasisPanel east = new BasisPanel(Color.YELLOW);
		BasisPanel west = new BasisPanel(Color.YELLOW);
		BasisPanel center = new BasisPanel(Color.YELLOW, new GridLayout(1, 6,
				10, 5));
		center.add(this.getLabel());
		this.setButtons(center);
		control.add(north, BorderLayout.NORTH);
		control.add(south, BorderLayout.SOUTH);
		control.add(east, BorderLayout.EAST);
		control.add(west, BorderLayout.WEST);
		control.add(center, BorderLayout.CENTER);
		this.getCenter().add(control, BorderLayout.NORTH);
	}

	private void setButtons(JPanel center) {
		// JButton[] buttons = { this.getBenutzerverwaltung(),
		// this.getEinstellungen(), this.getStatistiken(),
		// this.getAccountverwaltung(), this.getLogout() };
		// ActionListener al = new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// switch (e.getActionCommand()) {
		// case "Logout": {
		// Data.getInstance().clearData();
		// Data.getInstance().notifyAllObserver(true);
		// break;
		// }
		// default: {
		// Data.getInstance().setObservedUsedButton(
		// e.getActionCommand());
		// Data.getInstance().notifyAllObserver(true);
		// break;
		// }
		// }
		// }
		// };
		// for (JButton jButton : buttons) {
		// jButton.setSelected(false);
		// jButton.setFocusable(false);
		// jButton.setEnabled(true);
		// jButton.addActionListener(al);
		// }
		// this.getBenutzerverwaltung().setText("Benutzerverwaltung");
		// this.getEinstellungen().setText("Einstellungen");
		// this.getStatistiken().setText("Statistiken");
		// this.getAccountverwaltung().setText("Accountverwaltung");
		// this.getLogout().setText("Logout");
		center.add(this.getBenutzerverwaltung());
		center.add(this.getEinstellungen());
		center.add(this.getStatistiken());
		center.add(this.getAccountverwaltung());
		center.add(this.getLogout());
	}

	@Override
	public void update(boolean setLabel) {
		if (setLabel) {
			this.getLabel().setText(
					Data.getInstance().getUser().getLoginBenutzer());
		}
		this.switchPanel();
	}

	private void switchPanel() {
		super.setVisible(false);
		switch (Data.getInstance().getUsedButton()) {
		case "Benutzerverwaltung": {
			this.getCenter().remove(this.getAktion());
			this.setAktion(new Benutzerverwaltung());
			this.getCenter().add(this.getAktion(), BorderLayout.CENTER);
			break;
		}
		case "Einstellungen": {
			this.getCenter().remove(this.getAktion());
			this.setAktion(new JPanel());
			this.getAktion().setBackground(Color.YELLOW);
			this.getAktion().setBorder(new LineBorder(Color.BLACK, 2));
			JLabel label = new JLabel();
			label.setText("Einstellungen");
			label.setFont(new Font("Tahoma", Font.BOLD, 30));
			label.setHorizontalAlignment(SwingConstants.CENTER);
			this.getAktion().add(label);
			this.getCenter().add(this.getAktion(), BorderLayout.CENTER);
			break;
		}
		case "Statistiken": {
			this.getCenter().remove(this.getAktion());
			this.setAktion(new Statistiken());
			this.getCenter().add(this.getAktion(), BorderLayout.CENTER);
			break;
		}
		case "Accountverwaltung": {
			this.getCenter().remove(this.getAktion());
			this.setAktion(new Accountverwaltung());
			this.getCenter().add(this.getAktion(), BorderLayout.CENTER);
			break;
		}
		default: {
			this.getCenter().remove(this.getAktion());
			this.setAktion(new JPanel());
			this.getAktion().setBackground(Color.YELLOW);
			this.getAktion().setBorder(new LineBorder(Color.BLACK, 2));
			JLabel label = new JLabel();
			label.setText("Willkommen auf der Adminoberfläche");
			label.setFont(new Font("Tahoma", Font.BOLD, 30));
			label.setHorizontalAlignment(SwingConstants.CENTER);
			this.getAktion().add(label);
			this.getCenter().add(this.getAktion(), BorderLayout.CENTER);
			break;
		}
		}
		super.setVisible(true);
	}
}
