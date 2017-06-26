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

public class BenutzerBearbeiten extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	private JPanel elternPanel;
	private JPanel lehrerPanel;
	private Benutzer benutzer;
	private JTextField login;
	private JTextField passwort;
	private JTextField vorname;
	private JTextField nachname;
	private JTextField eltern;
	private JTextField lehrer;
	private JComboBox<String> elternAuswahl;
	private JComboBox<String> lehrerAuswahl;
	private JButton loginChangeButton;
	private JButton passwortChangeButton;
	private JButton vornameChangeButton;
	private JButton nachnameChangeButton;
	private JButton elternChangeButton;
	private JButton lehrerChangeButton;
	private JButton abbrechen;

	private JPanel getMainPanel() {
		return this.mainPanel;
	}

	private void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	private JPanel getElternPanel() {
		return this.elternPanel;
	}

	private void setElternPanel(JPanel elternPanel) {
		this.elternPanel = elternPanel;
	}

	private JPanel getLehrerPanel() {
		return this.lehrerPanel;
	}

	private void setLehrerPanel(JPanel lehrerPanel) {
		this.lehrerPanel = lehrerPanel;
	}

	private Benutzer getBenutzer() {
		return this.benutzer;
	}

	private void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
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

	private JTextField getEltern() {
		return this.eltern;
	}

	private void setEltern(JTextField eltern) {
		this.eltern = eltern;
	}

	private JTextField getLehrer() {
		return this.lehrer;
	}

	private void setLehrer(JTextField lehrer) {
		this.lehrer = lehrer;
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

	private JButton getLoginChangeButton() {
		return loginChangeButton;
	}

	private void setLoginChangeButton(JButton loginChangeButton) {
		this.loginChangeButton = loginChangeButton;
	}

	private JButton getPasswortChangeButton() {
		return passwortChangeButton;
	}

	private void setPasswortChangeButton(JButton passwortChangeButton) {
		this.passwortChangeButton = passwortChangeButton;
	}

	private JButton getVornameChangeButton() {
		return vornameChangeButton;
	}

	private void setVornameChangeButton(JButton vornameChangeButton) {
		this.vornameChangeButton = vornameChangeButton;
	}

	private JButton getNachnameChangeButton() {
		return nachnameChangeButton;
	}

	private void setNachnameChangeButton(JButton nachnameChangeButton) {
		this.nachnameChangeButton = nachnameChangeButton;
	}

	private JButton getElternChangeButton() {
		return elternChangeButton;
	}

	private void setElternChangeButton(JButton elternChangeButton) {
		this.elternChangeButton = elternChangeButton;
	}

	private JButton getLehrerChangeButton() {
		return lehrerChangeButton;
	}

	private void setLehrerChangeButton(JButton lehrerChangeButton) {
		this.lehrerChangeButton = lehrerChangeButton;
	}

	private JButton getAbbrechen() {
		return this.abbrechen;
	}

	private void setAbbrechen(JButton abbrechen) {
		this.abbrechen = abbrechen;
	}

	public BenutzerBearbeiten(JPanel mainPanel, JPanel elternPanel,
			JPanel lehrerPanel, String loginString, JTextField login,
			JTextField passwort, JTextField vorname, JTextField nachname,
			JTextField eltern, JTextField lehrer,
			JComboBox<String> elternAuswahl, JComboBox<String> lehrerAuswahl,
			JButton loginChangeButton, JButton passwortChangeButton,
			JButton vornameChangeButton, JButton nachnameChangeButton,
			JButton elternChangeButton, JButton lehrerChangeButton,
			JButton abbrechen) {
		super();
		this.setMainPanel(mainPanel);
		this.setElternPanel(elternPanel);
		this.setLehrerPanel(lehrerPanel);
		this.setBenutzer(Data.getInstance().getBenutzer()
				.getBenutzerByLogin(loginString));
		this.setLogin(login);
		this.setPasswort(passwort);
		this.setVorname(vorname);
		this.setNachname(nachname);
		this.setEltern(eltern);
		this.setLehrer(lehrer);
		this.setElternAuswahl(elternAuswahl);
		this.setLehrerAuswahl(lehrerAuswahl);
		this.setLoginChangeButton(loginChangeButton);
		this.setPasswortChangeButton(passwortChangeButton);
		this.setVornameChangeButton(vornameChangeButton);
		this.setNachnameChangeButton(nachnameChangeButton);
		this.setElternChangeButton(elternChangeButton);
		this.setLehrerChangeButton(lehrerChangeButton);
		this.setAbbrechen(abbrechen);
		this.init();
	}

	public BenutzerBearbeiten() {
		this(new JPanel(), new JPanel(), new JPanel(), "", new JTextField(),
				new JTextField(), new JTextField(), new JTextField(),
				new JTextField(), new JTextField(), new JComboBox<String>(),
				new JComboBox<String>(), new JButton(), new JButton(),
				new JButton(), new JButton(), new JButton(), new JButton(),
				new JButton());
	}

	public BenutzerBearbeiten(String login) {
		this(new JPanel(), new JPanel(), new JPanel(), login, new JTextField(),
				new JTextField(), new JTextField(), new JTextField(),
				new JTextField(), new JTextField(), new JComboBox<String>(),
				new JComboBox<String>(), new JButton(), new JButton(),
				new JButton(), new JButton(), new JButton(), new JButton(),
				new JButton());
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
		JLabel ueberschrift = new JLabel("Benutzer bearbeiten");
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
		this.getAbbrechen().setText("Zurück");
		this.getAbbrechen().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Zurück")) {
					BenutzerBearbeiten.this
							.dispatchEvent(new WindowEvent(
									BenutzerBearbeiten.this,
									WindowEvent.WINDOW_CLOSING));
					Data.getInstance().notifyAllObserver(false);
				} else {
					BenutzerBearbeiten.this.setVisible(false);
					BenutzerBearbeiten.this.getLogin().setEditable(false);
					BenutzerBearbeiten.this.getPasswort().setEditable(false);
					BenutzerBearbeiten.this.getVorname().setEditable(false);
					BenutzerBearbeiten.this.getNachname().setEditable(false);
					BenutzerBearbeiten.this.getElternPanel().removeAll();
					BenutzerBearbeiten.this.getEltern().setText(
							BenutzerBearbeiten.this.getBenutzer().getEltern()
									.getLogin());
					BenutzerBearbeiten.this.getElternPanel().add(
							BenutzerBearbeiten.this.getEltern());
					BenutzerBearbeiten.this.getEltern().setEditable(false);
					BenutzerBearbeiten.this.getLehrerPanel().removeAll();
					BenutzerBearbeiten.this.getLehrer().setText(
							BenutzerBearbeiten.this.getBenutzer().getLehrer()
									.getLogin());
					BenutzerBearbeiten.this.getLehrerPanel().add(
							BenutzerBearbeiten.this.getLehrer());
					BenutzerBearbeiten.this.getLehrer().setEditable(false);
					BenutzerBearbeiten.this.getLoginChangeButton().setText(
							"Ändern");
					BenutzerBearbeiten.this.getPasswortChangeButton().setText(
							"Ändern");
					BenutzerBearbeiten.this.getVornameChangeButton().setText(
							"Ändern");
					BenutzerBearbeiten.this.getNachnameChangeButton().setText(
							"Ändern");
					BenutzerBearbeiten.this.getElternChangeButton().setText(
							"Ändern");
					BenutzerBearbeiten.this.getLehrerChangeButton().setText(
							"Ändern");
					BenutzerBearbeiten.this.getLoginChangeButton().setEnabled(
							true);
					BenutzerBearbeiten.this.getPasswortChangeButton()
							.setEnabled(true);
					BenutzerBearbeiten.this.getVornameChangeButton()
							.setEnabled(true);
					BenutzerBearbeiten.this.getNachnameChangeButton()
							.setEnabled(true);
					BenutzerBearbeiten.this.getElternChangeButton().setEnabled(
							true);
					BenutzerBearbeiten.this.getLehrerChangeButton().setEnabled(
							true);
					BenutzerBearbeiten.this.getAbbrechen().setText("Zurück");
					BenutzerBearbeiten.this.setVisible(true);
				}
			}
		});
		south.add(this.getAbbrechen());
		this.getMainPanel().add(south, BorderLayout.SOUTH);
	}

	private void initCenterPanel() {
		JPanel center = new JPanel();
		center.setBackground(Color.YELLOW);
		center.setLayout(new GridLayout(6, 3));
		JPanel loginLabelPanel = new JPanel();
		loginLabelPanel.setOpaque(false);
		loginLabelPanel.setLayout(null);
		JLabel loginLabel = new JLabel("Login:");
		loginLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		loginLabel.setHorizontalAlignment(SwingConstants.LEFT);
		loginLabel.setBounds(10, 0, 100, 24);
		loginLabelPanel.add(loginLabel);
		center.add(loginLabelPanel);
		JPanel loginPanel = new JPanel();
		loginPanel.setOpaque(false);
		loginPanel.setLayout(null);
		this.getLogin().setText(this.getBenutzer().getLogin());
		this.getLogin().setBounds(0, 0, 150, 20);
		this.getLogin().setEditable(false);
		// loginField.setDocument(
		// new LettersAndDigitsDocument("benutzer"));
		loginPanel.add(this.getLogin());
		center.add(loginPanel);
		JPanel loginButtonPanel = new JPanel();
		loginButtonPanel.setOpaque(false);
		loginButtonPanel.setLayout(null);
		this.getLoginChangeButton().setText("Ändern");
		this.getLoginChangeButton().setBounds(45, 0, 100, 24);
		this.getLoginChangeButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Ändern")) {
					BenutzerBearbeiten.this.getLogin().setEditable(true);
					BenutzerBearbeiten.this.getLoginChangeButton().setText(
							"Speichern");
					BenutzerBearbeiten.this.getPasswortChangeButton()
							.setEnabled(false);
					BenutzerBearbeiten.this.getVornameChangeButton()
							.setEnabled(false);
					BenutzerBearbeiten.this.getNachnameChangeButton()
							.setEnabled(false);
					BenutzerBearbeiten.this.getElternChangeButton().setEnabled(
							false);
					BenutzerBearbeiten.this.getLehrerChangeButton().setEnabled(
							false);
					BenutzerBearbeiten.this.getAbbrechen().setText("Abbrechen");
				} else {
					String newLogin = BenutzerBearbeiten.this.getLogin()
							.getText();
					if (Data.getInstance()
							.getBenutzer()
							.editBenutzerLogin(
									newLogin,
									BenutzerBearbeiten.this.getBenutzer()
											.getLogin())) {
						BenutzerBearbeiten.this.getBenutzer()
								.setLogin(newLogin);
					} else {
						new Warning("Loginname existiert bereits !");
					}
					BenutzerBearbeiten.this.getLogin().setText(
							BenutzerBearbeiten.this.getBenutzer().getLogin());
					BenutzerBearbeiten.this.getLogin().setEditable(false);
					BenutzerBearbeiten.this.getLoginChangeButton().setText(
							"Ändern");
					BenutzerBearbeiten.this.getPasswortChangeButton()
							.setEnabled(true);
					BenutzerBearbeiten.this.getVornameChangeButton()
							.setEnabled(true);
					BenutzerBearbeiten.this.getNachnameChangeButton()
							.setEnabled(true);
					BenutzerBearbeiten.this.getElternChangeButton().setEnabled(
							true);
					BenutzerBearbeiten.this.getLehrerChangeButton().setEnabled(
							true);
					BenutzerBearbeiten.this.getAbbrechen().setText("Zurück");
				}
			}
		});
		loginButtonPanel.add(this.getLoginChangeButton());
		center.add(loginButtonPanel);
		JPanel passwortLabelPanel = new JPanel();
		passwortLabelPanel.setLayout(null);
		passwortLabelPanel.setOpaque(false);
		JLabel passwortLabel = new JLabel("Passwort:");
		passwortLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwortLabel.setHorizontalAlignment(SwingConstants.LEFT);
		passwortLabel.setBounds(10, 0, 100, 24);
		passwortLabelPanel.add(passwortLabel);
		center.add(passwortLabelPanel);
		JPanel passwortTextFieldPanel = new JPanel();
		passwortTextFieldPanel.setOpaque(false);
		passwortTextFieldPanel.setLayout(null);
		this.getPasswort().setText(this.getBenutzer().getPasswort());
		this.getPasswort().setBounds(0, 0, 150, 20);
		this.getPasswort().setEditable(false);
		// passwortField.setDocument(new LettersAndDigitsDocument());
		passwortTextFieldPanel.add(this.getPasswort());
		center.add(passwortTextFieldPanel);
		JPanel passwortButtonPanel = new JPanel();
		passwortButtonPanel.setLayout(null);
		passwortButtonPanel.setOpaque(false);
		this.getPasswortChangeButton().setText("Ändern");
		this.getPasswortChangeButton().setBounds(45, 0, 100, 24);
		this.getPasswortChangeButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Ändern")) {
					BenutzerBearbeiten.this.getPasswort().setEditable(true);
					BenutzerBearbeiten.this.getPasswortChangeButton().setText(
							"Speichern");
					BenutzerBearbeiten.this.getLoginChangeButton().setEnabled(
							false);
					BenutzerBearbeiten.this.getVornameChangeButton()
							.setEnabled(false);
					BenutzerBearbeiten.this.getNachnameChangeButton()
							.setEnabled(false);
					BenutzerBearbeiten.this.getElternChangeButton().setEnabled(
							false);
					BenutzerBearbeiten.this.getLehrerChangeButton().setEnabled(
							false);
					BenutzerBearbeiten.this.getAbbrechen().setText("Abbrechen");
				} else {
					String newPasswort = BenutzerBearbeiten.this.getPasswort()
							.getText();
					Data.getInstance()
							.getBenutzer()
							.editBenutzerPasswort(
									newPasswort,
									BenutzerBearbeiten.this.getBenutzer()
											.getPasswort());
					BenutzerBearbeiten.this.getBenutzer().setPasswort(
							newPasswort);
					BenutzerBearbeiten.this.getPasswort().setEditable(false);
					BenutzerBearbeiten.this.getPasswortChangeButton().setText(
							"Ändern");
					BenutzerBearbeiten.this.getLoginChangeButton().setEnabled(
							true);
					BenutzerBearbeiten.this.getVornameChangeButton()
							.setEnabled(true);
					BenutzerBearbeiten.this.getNachnameChangeButton()
							.setEnabled(true);
					BenutzerBearbeiten.this.getElternChangeButton().setEnabled(
							true);
					BenutzerBearbeiten.this.getLehrerChangeButton().setEnabled(
							true);
					BenutzerBearbeiten.this.getAbbrechen().setText("Zurück");
				}
			}
		});
		passwortButtonPanel.add(this.getPasswortChangeButton());
		center.add(passwortButtonPanel);
		JPanel vornameLabelPanel = new JPanel();
		vornameLabelPanel.setLayout(null);
		vornameLabelPanel.setOpaque(false);
		JLabel vornameLabel = new JLabel("Vorname:");
		vornameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		vornameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		vornameLabel.setBounds(10, 0, 100, 24);
		vornameLabelPanel.add(vornameLabel);
		center.add(vornameLabelPanel);
		JPanel vornamePanel = new JPanel();
		vornamePanel.setLayout(null);
		vornamePanel.setOpaque(false);
		this.getVorname().setText(this.getBenutzer().getVorname());
		this.getVorname().setBounds(0, 0, 150, 20);
		this.getVorname().setEditable(false);
		vornamePanel.add(this.getVorname());
		center.add(vornamePanel);
		JPanel vornameButtonPanel = new JPanel();
		vornameButtonPanel.setLayout(null);
		vornameButtonPanel.setOpaque(false);
		this.getVornameChangeButton().setText("Ändern");
		this.getVornameChangeButton().setBounds(45, 0, 100, 24);
		this.getVornameChangeButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Ändern")) {
					BenutzerBearbeiten.this.getVorname().setEditable(true);
					BenutzerBearbeiten.this.getVornameChangeButton().setText(
							"Speichern");
					BenutzerBearbeiten.this.getLoginChangeButton().setEnabled(
							false);
					BenutzerBearbeiten.this.getPasswortChangeButton()
							.setEnabled(false);
					BenutzerBearbeiten.this.getNachnameChangeButton()
							.setEnabled(false);
					BenutzerBearbeiten.this.getElternChangeButton().setEnabled(
							false);
					BenutzerBearbeiten.this.getLehrerChangeButton().setEnabled(
							false);
					BenutzerBearbeiten.this.getAbbrechen().setText("Abbrechen");
				} else {
					String newVorname = BenutzerBearbeiten.this.getVorname()
							.getText();
					Data.getInstance()
							.getBenutzer()
							.editBenutzerVorname(
									newVorname,
									BenutzerBearbeiten.this.getBenutzer()
											.getVorname());
					BenutzerBearbeiten.this.getBenutzer()
							.setVorname(newVorname);
					BenutzerBearbeiten.this.getVorname().setEditable(false);
					BenutzerBearbeiten.this.getVornameChangeButton().setText(
							"Ändern");
					BenutzerBearbeiten.this.getLoginChangeButton().setEnabled(
							true);
					BenutzerBearbeiten.this.getPasswortChangeButton()
							.setEnabled(true);
					BenutzerBearbeiten.this.getNachnameChangeButton()
							.setEnabled(true);
					BenutzerBearbeiten.this.getElternChangeButton().setEnabled(
							true);
					BenutzerBearbeiten.this.getLehrerChangeButton().setEnabled(
							true);
					BenutzerBearbeiten.this.getAbbrechen().setText("Zurück");
				}
			}
		});
		vornameButtonPanel.add(this.getVornameChangeButton());
		center.add(vornameButtonPanel);
		JPanel nachnameLabelPanel = new JPanel();
		nachnameLabelPanel.setLayout(null);
		nachnameLabelPanel.setOpaque(false);
		JLabel nachnameLabel = new JLabel("Nachname:");
		nachnameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		nachnameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nachnameLabel.setBounds(10, 0, 100, 24);
		nachnameLabelPanel.add(nachnameLabel);
		center.add(nachnameLabelPanel);
		JPanel nachnamePanel = new JPanel();
		nachnamePanel.setLayout(null);
		nachnamePanel.setOpaque(false);
		this.getNachname().setText(this.getBenutzer().getNachname());
		this.getNachname().setBounds(0, 0, 150, 20);
		this.getNachname().setEditable(false);
		nachnamePanel.add(this.getNachname());
		center.add(nachnamePanel);
		JPanel nachnameButtonPanel = new JPanel();
		nachnameButtonPanel.setLayout(null);
		nachnameButtonPanel.setOpaque(false);
		this.getNachnameChangeButton().setText("Ändern");
		this.getNachnameChangeButton().setBounds(45, 0, 100, 24);
		this.getNachnameChangeButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Ändern")) {
					BenutzerBearbeiten.this.getNachname().setEditable(true);
					BenutzerBearbeiten.this.getNachnameChangeButton().setText(
							"Speichern");
					BenutzerBearbeiten.this.getLoginChangeButton().setEnabled(
							false);
					BenutzerBearbeiten.this.getPasswortChangeButton()
							.setEnabled(false);
					BenutzerBearbeiten.this.getVornameChangeButton()
							.setEnabled(false);
					BenutzerBearbeiten.this.getElternChangeButton().setEnabled(
							false);
					BenutzerBearbeiten.this.getLehrerChangeButton().setEnabled(
							false);
					BenutzerBearbeiten.this.getAbbrechen().setText("Abbrechen");
				} else {
					String newNachname = BenutzerBearbeiten.this.getNachname()
							.getText();
					Data.getInstance()
							.getBenutzer()
							.editBenutzerNachname(
									newNachname,
									BenutzerBearbeiten.this.getBenutzer()
											.getNachname());
					BenutzerBearbeiten.this.getBenutzer().setNachname(
							newNachname);
					BenutzerBearbeiten.this.getNachname().setEditable(false);
					BenutzerBearbeiten.this.getNachnameChangeButton().setText(
							"Ändern");
					BenutzerBearbeiten.this.getLoginChangeButton().setEnabled(
							true);
					BenutzerBearbeiten.this.getPasswortChangeButton()
							.setEnabled(true);
					BenutzerBearbeiten.this.getVornameChangeButton()
							.setEnabled(true);
					BenutzerBearbeiten.this.getElternChangeButton().setEnabled(
							true);
					BenutzerBearbeiten.this.getLehrerChangeButton().setEnabled(
							true);
					BenutzerBearbeiten.this.getAbbrechen().setText("Zurück");
				}
			}
		});
		nachnameButtonPanel.add(this.getNachnameChangeButton());
		center.add(nachnameButtonPanel);
		JPanel elternLabelPanel = new JPanel();
		elternLabelPanel.setLayout(null);
		elternLabelPanel.setOpaque(false);
		JLabel elternLabel = new JLabel("Eltern:");
		elternLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		elternLabel.setHorizontalAlignment(SwingConstants.LEFT);
		elternLabel.setBounds(10, 0, 100, 24);
		elternLabelPanel.add(elternLabel);
		center.add(elternLabelPanel);
		this.getElternPanel().setLayout(null);
		this.getElternPanel().setOpaque(false);
		this.getEltern().setText(this.getBenutzer().getEltern().getLogin());
		this.getEltern().setBounds(0, 0, 150, 20);
		this.getEltern().setEditable(false);
		this.getElternPanel().add(this.getEltern());
		center.add(this.getElternPanel());
		JPanel elternButtonPanel = new JPanel();
		elternButtonPanel.setLayout(null);
		elternButtonPanel.setOpaque(false);
		this.getElternChangeButton().setText("Ändern");
		this.getElternChangeButton().setBounds(45, 0, 100, 24);
		this.getElternChangeButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Ändern")) {
					BenutzerBearbeiten.this.setVisible(false);
					BenutzerBearbeiten.this.getElternPanel().removeAll();
					ArrayList<Eltern> eltern = Data.getInstance().getEltern()
							.getAllEltern();
					BenutzerBearbeiten.this
							.setElternAuswahl(new JComboBox<String>());
					BenutzerBearbeiten.this.getElternAuswahl().addItem("---");
					boolean hatEltern = false;
					for (Eltern el : eltern) {
						BenutzerBearbeiten.this.getElternAuswahl().addItem(
								el.getLogin());
						if (el.getLogin().equals(
								BenutzerBearbeiten.this.getBenutzer()
										.getEltern().getLogin())) {
							BenutzerBearbeiten.this.getElternAuswahl()
									.setSelectedIndex(
											BenutzerBearbeiten.this
													.getElternAuswahl()
													.getItemCount() - 1);
							hatEltern = true;
						}
					}
					if (!hatEltern) {
						BenutzerBearbeiten.this.getElternAuswahl()
								.setSelectedIndex(0);
					}
					BenutzerBearbeiten.this.getElternAuswahl().setFont(
							new Font("Tahoma", Font.PLAIN, 12));
					BenutzerBearbeiten.this.getElternAuswahl().setBounds(0, 0,
							150, 20);
					BenutzerBearbeiten.this.getElternAuswahl().setBackground(
							Color.WHITE);
					BenutzerBearbeiten.this.getElternPanel().add(
							BenutzerBearbeiten.this.getElternAuswahl());
					BenutzerBearbeiten.this.getElternChangeButton().setText(
							"Speichern");
					BenutzerBearbeiten.this.getLoginChangeButton().setEnabled(
							false);
					BenutzerBearbeiten.this.getPasswortChangeButton()
							.setEnabled(false);
					BenutzerBearbeiten.this.getVornameChangeButton()
							.setEnabled(false);
					BenutzerBearbeiten.this.getNachnameChangeButton()
							.setEnabled(false);
					BenutzerBearbeiten.this.getLehrerChangeButton().setEnabled(
							false);
					BenutzerBearbeiten.this.getAbbrechen().setText("Abbrechen");
					BenutzerBearbeiten.this.setVisible(true);
				} else {
					String newEltern = BenutzerBearbeiten.this
							.getElternAuswahl().getSelectedItem().toString();
					BenutzerBearbeiten.this.getBenutzer().editBenutzerEltern(
							newEltern,
							BenutzerBearbeiten.this.getBenutzer()
									.getBenutzer_id());
					BenutzerBearbeiten.this.getBenutzer().setEltern(
							Data.getInstance().getEltern()
									.getElternByLogin(newEltern));
					BenutzerBearbeiten.this.setVisible(false);
					BenutzerBearbeiten.this.getElternPanel().removeAll();
					if (BenutzerBearbeiten.this.getBenutzer().getEltern() == null) {
						BenutzerBearbeiten.this.getEltern().setText(
								BenutzerBearbeiten.this.getElternAuswahl()
										.getItemAt(0));
					} else {
						BenutzerBearbeiten.this.getEltern().setText(
								BenutzerBearbeiten.this.getBenutzer()
										.getEltern().getLogin());
					}
					BenutzerBearbeiten.this.getElternPanel().add(
							BenutzerBearbeiten.this.getEltern());
					BenutzerBearbeiten.this.getElternChangeButton().setText(
							"Ändern");
					BenutzerBearbeiten.this.getLoginChangeButton().setEnabled(
							true);
					BenutzerBearbeiten.this.getPasswortChangeButton()
							.setEnabled(true);
					BenutzerBearbeiten.this.getVornameChangeButton()
							.setEnabled(true);
					BenutzerBearbeiten.this.getNachnameChangeButton()
							.setEnabled(true);
					BenutzerBearbeiten.this.getLehrerChangeButton().setEnabled(
							true);
					BenutzerBearbeiten.this.getAbbrechen().setText("Zurück");
					BenutzerBearbeiten.this.setVisible(true);
				}
			}
		});
		elternButtonPanel.add(this.getElternChangeButton());
		center.add(elternButtonPanel);
		JPanel lehrerLabelPanel = new JPanel();
		lehrerLabelPanel.setLayout(null);
		lehrerLabelPanel.setOpaque(false);
		JLabel lehrerLabel = new JLabel("Lehrer:");
		lehrerLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lehrerLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lehrerLabel.setBounds(10, 0, 100, 24);
		lehrerLabelPanel.add(lehrerLabel);
		center.add(lehrerLabelPanel);
		this.getLehrerPanel().setLayout(null);
		this.getLehrerPanel().setOpaque(false);
		this.getLehrer().setText(this.getBenutzer().getLehrer().getLogin());
		this.getLehrer().setBounds(0, 0, 150, 20);
		this.getLehrer().setEditable(false);
		this.getLehrerPanel().add(this.getLehrer());
		center.add(this.getLehrerPanel());
		JPanel lehrerButtonPanel = new JPanel();
		lehrerButtonPanel.setLayout(null);
		lehrerButtonPanel.setOpaque(false);
		this.getLehrerChangeButton().setText("Ändern");
		this.getLehrerChangeButton().setBounds(45, 0, 100, 24);
		this.getLehrerChangeButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Ändern")) {
					BenutzerBearbeiten.this.setVisible(false);
					BenutzerBearbeiten.this.getLehrerPanel().removeAll();
					ArrayList<Lehrer> lehrer = Data.getInstance().getLehrer()
							.getAllLehrer();
					BenutzerBearbeiten.this
							.setLehrerAuswahl(new JComboBox<String>());
					BenutzerBearbeiten.this.getLehrerAuswahl().addItem("---");
					boolean hatLehrer = false;
					for (Lehrer l : lehrer) {
						BenutzerBearbeiten.this.getLehrerAuswahl().addItem(
								l.getLogin());
						if (l.getLogin().equals(
								BenutzerBearbeiten.this.getBenutzer()
										.getLehrer().getLogin())) {
							BenutzerBearbeiten.this.getLehrerAuswahl()
									.setSelectedIndex(
											BenutzerBearbeiten.this
													.getLehrerAuswahl()
													.getItemCount() - 1);
							hatLehrer = true;
						}
					}
					if (!hatLehrer) {
						BenutzerBearbeiten.this.getLehrerAuswahl()
								.setSelectedIndex(0);
					}
					BenutzerBearbeiten.this.getLehrerAuswahl().setFont(
							new Font("Tahoma", Font.PLAIN, 12));
					BenutzerBearbeiten.this.getLehrerAuswahl().setBounds(0, 0,
							150, 20);
					BenutzerBearbeiten.this.getLehrerAuswahl().setBackground(
							Color.WHITE);
					BenutzerBearbeiten.this.getLehrerPanel().add(
							BenutzerBearbeiten.this.getLehrerAuswahl());
					BenutzerBearbeiten.this.getLehrerChangeButton().setText(
							"Speichern");
					BenutzerBearbeiten.this.getLoginChangeButton().setEnabled(
							false);
					BenutzerBearbeiten.this.getPasswortChangeButton()
							.setEnabled(false);
					BenutzerBearbeiten.this.getVornameChangeButton()
							.setEnabled(false);
					BenutzerBearbeiten.this.getNachnameChangeButton()
							.setEnabled(false);
					BenutzerBearbeiten.this.getElternChangeButton().setEnabled(
							false);
					BenutzerBearbeiten.this.getAbbrechen().setText("Abbrechen");
					BenutzerBearbeiten.this.setVisible(true);
				} else {
					String newLehrer = BenutzerBearbeiten.this
							.getLehrerAuswahl().getSelectedItem().toString();
					BenutzerBearbeiten.this.getBenutzer().editBenutzerLehrer(
							newLehrer,
							BenutzerBearbeiten.this.getBenutzer()
									.getBenutzer_id());
					BenutzerBearbeiten.this.getBenutzer().setLehrer(
							Data.getInstance().getLehrer()
									.getLehrerByLogin(newLehrer));
					BenutzerBearbeiten.this.setVisible(false);
					BenutzerBearbeiten.this.getLehrerPanel().removeAll();
					if (BenutzerBearbeiten.this.getBenutzer().getLehrer() == null) {
						BenutzerBearbeiten.this.getLehrer().setText(
								BenutzerBearbeiten.this.getLehrerAuswahl()
										.getItemAt(0));
					} else {
						BenutzerBearbeiten.this.getLehrer().setText(
								BenutzerBearbeiten.this.getBenutzer()
										.getLehrer().getLogin());
					}
					BenutzerBearbeiten.this.getLehrerPanel().add(
							BenutzerBearbeiten.this.getLehrer());
					BenutzerBearbeiten.this.getLehrerChangeButton().setText(
							"Ändern");
					BenutzerBearbeiten.this.getLoginChangeButton().setEnabled(
							true);
					BenutzerBearbeiten.this.getPasswortChangeButton()
							.setEnabled(true);
					BenutzerBearbeiten.this.getVornameChangeButton()
							.setEnabled(true);
					BenutzerBearbeiten.this.getNachnameChangeButton()
							.setEnabled(true);
					BenutzerBearbeiten.this.getElternChangeButton().setEnabled(
							true);
					BenutzerBearbeiten.this.getAbbrechen().setText("Zurück");
					BenutzerBearbeiten.this.setVisible(true);
				}
			}
		});
		lehrerButtonPanel.add(this.getLehrerChangeButton());
		center.add(lehrerButtonPanel);
		this.getMainPanel().add(center, BorderLayout.CENTER);
	}

}