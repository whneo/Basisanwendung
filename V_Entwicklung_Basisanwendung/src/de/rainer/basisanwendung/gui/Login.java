package de.rainer.basisanwendung.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import de.rainer.basisanwendung.data.Data;
import de.rainer.basisanwendung.datenbank.ElementaryDbManager;

public class Login extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel mainPanel;
	private JTextField textField;
	private JPasswordField passwordField;

	private JPanel getMainPanel() {
		return this.mainPanel;
	}

	private void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	private JTextField getTextField() {
		return this.textField;
	}

	private void setTextField(JTextField textField) {
		this.textField = textField;
	}

	private JPasswordField getPasswordField() {
		return this.passwordField;
	}

	private void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public Login(JPanel mainPanel, JTextField textField,
			JPasswordField passwordField) {
		super();
		this.setMainPanel(mainPanel);
		this.setTextField(textField);
		this.setPasswordField(passwordField);
		this.init();
	}

	public Login() {
		this(new JPanel(), new JTextField(), new JPasswordField());
	}

	private void init() {
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension d = t.getScreenSize();
		int width = 400;
		int height = 150;
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
		super.add(this.getMainPanel());
		super.setVisible(true);
	}

	private void initMainPanel() {
		this.getMainPanel().setLayout(new BorderLayout());
		this.getMainPanel().setBackground(Color.YELLOW);
		this.getMainPanel().setBorder(new LineBorder(Color.BLACK, 2));
	}

	private void initNorthPanel() {
		JPanel north = new JPanel();
		north.setBackground(Color.YELLOW);
		JLabel ueberschrift = new JLabel("Login");
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
		JButton login = new JButton("Login");
		login.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_SPACE) {
					Login.this.login();
				}
			}
		});
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Login.this.login();
			}
		});
		south.add(login);
		JButton beenden = new JButton("Beenden");
		beenden.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_SPACE) {
					System.exit(0);
				}
			}
		});
		beenden.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		south.add(beenden);
		this.getMainPanel().add(south, BorderLayout.SOUTH);
	}

	private void initCenterPanel() {
		JPanel center = new JPanel();
		center.setBackground(Color.YELLOW);
		center.setLayout(null);
		JLabel benutzer = new JLabel("Benutzer:");
		benutzer.setFont(new Font("Tahoma", Font.BOLD, 15));
		benutzer.setHorizontalAlignment(SwingConstants.LEFT);
		benutzer.setBounds(10, 0, 100, 24);
		center.add(benutzer);
		this.getTextField().setBackground(Color.WHITE);
		this.getTextField().setForeground(Color.BLACK);
		this.getTextField().setBounds(100, 2, 270, 20);
		this.getTextField().setDocument(
				new LettersAndDigitsDocument("benutzer"));
		this.getTextField().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					if (Data.getInstance().getUser().getLoginBenutzer()
							.length() > 0) {
						Data.getInstance()
								.getUser()
								.setLoginBenutzer(
										Data.getInstance()
												.getUser()
												.getLoginBenutzer()
												.substring(
														0,
														Data.getInstance()
																.getUser()
																.getLoginBenutzer()
																.length() - 1));
					}
				}
			}
		});
		center.add(this.getTextField());
		JLabel passwort = new JLabel("Passwort:");
		passwort.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwort.setHorizontalAlignment(SwingConstants.LEFT);
		passwort.setBounds(10, 30, 100, 24);
		center.add(passwort);
		this.getPasswordField().setBackground(Color.WHITE);
		this.getPasswordField().setForeground(Color.BLACK);
		this.getPasswordField().setBounds(100, 32, 270, 20);
		this.getPasswordField().setDocument(new LettersAndDigitsDocument());
		this.getPasswordField().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					if (Data.getInstance().getUser().getLoginPasswort()
							.length() > 0) {
						Data.getInstance()
								.getUser()
								.setLoginPasswort(
										Data.getInstance()
												.getUser()
												.getLoginPasswort()
												.substring(
														0,
														Data.getInstance()
																.getUser()
																.getLoginPasswort()
																.length() - 1));
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					Login.this.login();
				}
			}
		});
		center.add(this.getPasswordField());
		this.getMainPanel().add(center, BorderLayout.CENTER);
	}

	private void login() {
		String[] benutzer = { "Admin", "Eltern", "Lehrer", "Benutzer" };
		for (int i = 0; i < benutzer.length;) {
			ResultSet rst = ElementaryDbManager
					.getInstance()
					.getDbh()
					.select("SELECT * FROM " + benutzer[i] + " WHERE Login = '"
							+ Data.getInstance().getUser().getLoginBenutzer()
							+ "' AND Passwort = '"
							+ Data.getInstance().getUser().getLoginPasswort()
							+ "'");
			try {
				if (rst.next()) {
					Data.getInstance().getUser()
							.setObservedLoginTyp(benutzer[i]);
					switch (benutzer[i]) {
					case "Admin": {
						Data.getInstance().getAdmin()
								.setLogin(rst.getString("login"));
						Data.getInstance().getAdmin()
								.setPasswort(rst.getString("passwort"));
						Data.getInstance().getUser()
								.setLoginBenutzer(rst.getString("login"));
						Data.getInstance().getUser()
								.setLoginPasswort(rst.getString("passwort"));
						Data.getInstance().getUser()
								.setObservedLoginTyp("Admin");
						break;
					}
					case "Eltern": {
						Data.getInstance().getEltern()
								.setEltern_Id(rst.getInt("eltern_id"));
						Data.getInstance().getEltern()
								.setLogin(rst.getString("login"));
						Data.getInstance().getEltern()
								.setPasswort(rst.getString("passwort"));
						Data.getInstance().getUser()
								.setId(rst.getInt("eltern_id"));
						Data.getInstance().getUser()
								.setLoginBenutzer(rst.getString("login"));
						Data.getInstance().getUser()
								.setLoginPasswort(rst.getString("passwort"));
						Data.getInstance().getUser()
								.setObservedLoginTyp("Eltern");
						break;
					}
					case "Lehrer": {
						Data.getInstance().getLehrer()
								.setLehrer_Id(rst.getInt("lehrer_id"));
						Data.getInstance().getLehrer()
								.setLogin(rst.getString("login"));
						Data.getInstance().getLehrer()
								.setPasswort(rst.getString("passwort"));
						Data.getInstance().getUser()
								.setId(rst.getInt("lehrer_id"));
						Data.getInstance().getUser()
								.setLoginBenutzer(rst.getString("login"));
						Data.getInstance().getUser()
								.setLoginPasswort(rst.getString("passwort"));
						Data.getInstance().getUser()
								.setObservedLoginTyp("Lehrer");
						break;
					}
					case "Benutzer": {
						Data.getInstance().getBenutzer()
								.setBenutzer_id(rst.getInt("benutzer_id"));
						Data.getInstance().getBenutzer()
								.setLogin(rst.getString("login"));
						Data.getInstance().getBenutzer()
								.setPasswort(rst.getString("passwort"));
						Data.getInstance().getUser()
								.setId(rst.getInt("benutzer_id"));
						Data.getInstance().getUser()
								.setLoginBenutzer(rst.getString("login"));
						Data.getInstance().getUser()
								.setLoginPasswort(rst.getString("passwort"));
						Data.getInstance().getUser()
								.setObservedLoginTyp("Benutzer");
						break;
					}
					}
					break;
				} else {
					i++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ElementaryDbManager.getInstance().getDbh().getDbc().closeResultSet(rst);
			}
		}
		if (Data.getInstance().getUser().getLoginTyp().equals("")) {
			Data.getInstance().getUser().setLoginBenutzer("");
			Data.getInstance().getUser().setLoginPasswort("");
			this.getTextField().setText("");
			this.getPasswordField().setText("");
			this.getTextField().requestFocus();
			new Warning("Login oder Passwort falsch !");
		} else {
			Data.getInstance().notifyAllObserver(true);
			this.setVisible(false);
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
	}
}