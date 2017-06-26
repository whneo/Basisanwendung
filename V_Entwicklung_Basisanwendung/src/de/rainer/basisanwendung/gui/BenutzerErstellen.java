package de.rainer.basisanwendung.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import de.rainer.basisanwendung.data.Data;
import de.rainer.basisanwendung.user.Benutzer;
import de.rainer.basisanwendung.user.Eltern;
import de.rainer.basisanwendung.user.Lehrer;

public class BenutzerErstellen extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	private JTextField login;
	private JTextField passwort;
	private JTextField vorname;
	private JTextField nachname;
	private JComboBox<String> elternAuswahl;
	private JComboBox<String> lehrerAuswahl;
	private JButton abbrechen;
	private JButton speichern;

	private JPanel getMainPanel() {
		return this.mainPanel;
	}

	private void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	private JTextField getLogin() {
		return this.login;
	}

	private void setLogin(JTextField login) {
		this.login = login;
	}

	private JTextField getPasswort() {
		return this.passwort;
	}

	private void setPasswort(JTextField passwort) {
		this.passwort = passwort;
	}

	private JTextField getVorname() {
		return this.vorname;
	}

	private void setVorname(JTextField vorname) {
		this.vorname = vorname;
	}

	private JTextField getNachname() {
		return this.nachname;
	}

	private void setNachname(JTextField nachname) {
		this.nachname = nachname;
	}

	private JComboBox<String> getElternAuswahl() {
		return this.elternAuswahl;
	}

	private void setElternAuswahl(JComboBox<String> elternAuswahl) {
		this.elternAuswahl = elternAuswahl;
	}

	private JComboBox<String> getLehrerAuswahl() {
		return this.lehrerAuswahl;
	}

	private void setLehrerAuswahl(JComboBox<String> lehrerAuswahl) {
		this.lehrerAuswahl = lehrerAuswahl;
	}

	private JButton getSpeichern() {
		return this.speichern;
	}

	private void setSpeichern(JButton speichern) {
		this.speichern = speichern;
	}

	private JButton getAbbrechen() {
		return this.abbrechen;
	}

	private void setAbbrechen(JButton abbrechen) {
		this.abbrechen = abbrechen;
	}

	public BenutzerErstellen(JPanel mainPanel, JTextField login,
			JTextField passwort, JTextField vorname, JTextField nachname,
			JComboBox<String> elternAuswahl, JComboBox<String> lehrerAuswahl,
			JButton speichern, JButton abbrechen) {
		super();
		this.setMainPanel(mainPanel);
		this.setLogin(login);
		this.setPasswort(passwort);
		this.setVorname(vorname);
		this.setNachname(nachname);
		this.setElternAuswahl(elternAuswahl);
		this.setLehrerAuswahl(lehrerAuswahl);
		this.setSpeichern(speichern);
		this.setAbbrechen(abbrechen);
		this.init();
	}

	public BenutzerErstellen() {
		this(new JPanel(), new JTextField(), new JTextField(),
				new JTextField(), new JTextField(), new JComboBox<String>(),
				new JComboBox<String>(), new JButton(), new JButton());
	}

	private void init() {
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension d = t.getScreenSize();
		int width = 520;
		int height = 290;
		int x = (int) ((d.getWidth() - width) / 2);
		int y = (int) ((d.getHeight() - height) / 2);
		super.setBounds(x, y, width, height);
		super.setUndecorated(true);
		super.setModal(true);
		this.initMainPanel();
		this.initNorthPanel();
		this.initSidePanel();
		this.initSouthPanel();
		this.initCenterPanel();
		super.setVisible(true);
	}

	private void initMainPanel() {
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		jp.setBackground(Color.WHITE);
		jp.setBorder(new LineBorder(Color.BLACK, 2));
		JPanel north = new JPanel();
		north.setBackground(Color.WHITE);
		jp.add(north, BorderLayout.NORTH);
		JPanel south = new JPanel();
		south.setBackground(Color.WHITE);
		jp.add(south, BorderLayout.SOUTH);
		JPanel east = new JPanel();
		east.setBackground(Color.WHITE);
		jp.add(east, BorderLayout.EAST);
		JPanel west = new JPanel();
		west.setBackground(Color.WHITE);
		jp.add(west, BorderLayout.WEST);
		this.getMainPanel().setLayout(new BorderLayout());
		this.getMainPanel().setBackground(Color.YELLOW);
		this.getMainPanel().setBorder(new LineBorder(Color.BLACK, 2));
		jp.add(this.getMainPanel(), BorderLayout.CENTER);
		super.add(jp);
	}

	private void initNorthPanel() {
		JPanel north = new JPanel();
		north.setBackground(Color.YELLOW);
		JLabel ueberschrift = new JLabel("Benutzer erstellen");
		ueberschrift.setFont(new Font("Tahoma", Font.BOLD, 30));
		ueberschrift.setHorizontalAlignment(SwingConstants.CENTER);
		north.add(ueberschrift);
		this.getMainPanel().add(north, BorderLayout.NORTH);
	}

	private void initSidePanel() {
		JPanel west = new JPanel();
		west.setBackground(Color.YELLOW);
		this.getMainPanel().add(west, BorderLayout.WEST);
		JPanel east = new JPanel();
		east.setBackground(Color.YELLOW);
		this.getMainPanel().add(east, BorderLayout.EAST);
	}

	private void initSouthPanel() {
		JPanel south = new JPanel();
		south.setBackground(Color.YELLOW);
		this.getSpeichern().setText("Speichern");
		this.getSpeichern().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Benutzer benutzer = new Benutzer(BenutzerErstellen.this
						.getLogin().getText(), BenutzerErstellen.this
						.getPasswort().getText(), BenutzerErstellen.this
						.getVorname().getText(), BenutzerErstellen.this
						.getNachname().getText(), Data
						.getInstance()
						.getEltern()
						.getElternByLogin(
								(String) BenutzerErstellen.this
										.getElternAuswahl().getSelectedItem()),
						Data.getInstance()
								.getLehrer()
								.getLehrerByLogin(
										(String) BenutzerErstellen.this
												.getLehrerAuswahl()
												.getSelectedItem()));
				Data.getInstance().getBenutzer().setBenutzerIntoDb(benutzer);
				BenutzerErstellen.this.dispatchEvent(new WindowEvent(
						BenutzerErstellen.this, WindowEvent.WINDOW_CLOSING));
				Data.getInstance().notifyAllObserver(false);
			}
		});
		south.add(this.getSpeichern());
		this.getAbbrechen().setText("Abbrechen");
		this.getAbbrechen().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BenutzerErstellen.this.dispatchEvent(new WindowEvent(
						BenutzerErstellen.this, WindowEvent.WINDOW_CLOSING));
			}
		});
		south.add(this.getAbbrechen());
		this.getMainPanel().add(south, BorderLayout.SOUTH);
	}

	private void initCenterPanel() {
		JPanel center = new JPanel();
		center.setBackground(Color.YELLOW);
		center.setLayout(new BorderLayout(10, 10));
		JPanel centerLeft = new JPanel();
		centerLeft.setBackground(Color.YELLOW);
		centerLeft.setLayout(new GridLayout(6, 1));
		JPanel centerRight = new JPanel();
		centerRight.setBackground(Color.YELLOW);
		centerRight.setLayout(new GridLayout(6, 1));
		JLabel loginLabel = new JLabel("Login:");
		loginLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		loginLabel.setHorizontalAlignment(SwingConstants.LEFT);
		loginLabel.setBounds(10, 0, 100, 24);
		centerLeft.add(loginLabel);
		this.getLogin().setBounds(0, 0, 150, 20);
		// this.getLogin().setDocument(new
		// LettersAndDigitsDocument("benutzer"));
		centerRight.add(this.getLogin());
		JLabel passwortLabel = new JLabel("Passwort:");
		passwortLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwortLabel.setHorizontalAlignment(SwingConstants.LEFT);
		passwortLabel.setBounds(10, 0, 100, 24);
		centerLeft.add(passwortLabel);
		this.getPasswort().setBounds(0, 0, 150, 20);
		// this.getPasswort().setDocument(new LettersAndDigitsDocument());
		centerRight.add(this.getPasswort());
		JLabel vornameLabel = new JLabel("Vorname:");
		vornameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		vornameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		vornameLabel.setBounds(10, 0, 100, 24);
		centerLeft.add(vornameLabel);
		this.getVorname().setBounds(0, 0, 150, 20);
		centerRight.add(this.getVorname());
		JLabel nachnameLabel = new JLabel("Nachname:");
		nachnameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		nachnameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nachnameLabel.setBounds(10, 0, 100, 24);
		centerLeft.add(nachnameLabel);
		this.getNachname().setBounds(0, 0, 150, 20);
		centerRight.add(this.getNachname());
		JLabel elternLabel = new JLabel("Eltern:");
		elternLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		elternLabel.setHorizontalAlignment(SwingConstants.LEFT);
		elternLabel.setBounds(10, 0, 100, 24);
		centerLeft.add(elternLabel);
		ArrayList<Eltern> eltern = Data.getInstance().getEltern()
				.getAllEltern();
		this.setElternAuswahl(new JComboBox<String>());
		this.getElternAuswahl().addItem("");
		boolean hatEltern = false;
		for (Eltern el : eltern) {
			this.getElternAuswahl().addItem(el.getLogin());
			if (Data.getInstance().getUser().getLoginBenutzer()
					.equals(el.getLogin())) {
				this.getElternAuswahl().setSelectedIndex(
						this.getElternAuswahl().getItemCount() - 1);
				hatEltern = true;
			}
		}
		if (!hatEltern) {
			this.getElternAuswahl().setSelectedIndex(0);
		}
		this.getElternAuswahl().setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.getElternAuswahl().setBounds(0, 0, 150, 20);
		this.getElternAuswahl().setBackground(Color.WHITE);
		centerRight.add(this.getElternAuswahl());
		JLabel lehrerLabel = new JLabel("Lehrer:");
		lehrerLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lehrerLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lehrerLabel.setBounds(10, 0, 100, 24);
		centerLeft.add(lehrerLabel);
		ArrayList<Lehrer> lehrer = Data.getInstance().getLehrer()
				.getAllLehrer();
		this.setLehrerAuswahl(new JComboBox<String>());
		this.getLehrerAuswahl().addItem("");
		boolean hatLehrer = false;
		for (Lehrer le : lehrer) {
			this.getLehrerAuswahl().addItem(le.getLogin());
			if (Data.getInstance().getUser().getLoginBenutzer()
					.equals(le.getLogin())) {
				this.getLehrerAuswahl().setSelectedIndex(
						this.getLehrerAuswahl().getItemCount() - 1);
				hatLehrer = true;
			}
		}
		if (!hatLehrer) {
			this.getLehrerAuswahl().setSelectedIndex(0);
		}
		this.getLehrerAuswahl().setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.getLehrerAuswahl().setBounds(0, 0, 150, 20);
		this.getLehrerAuswahl().setBackground(Color.WHITE);
		centerRight.add(this.getLehrerAuswahl());
		center.add(centerLeft, BorderLayout.WEST);
		center.add(centerRight, BorderLayout.CENTER);
		this.getMainPanel().add(center, BorderLayout.CENTER);
	}

}