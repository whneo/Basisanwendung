package de.rainer.basisanwendung.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import de.rainer.basisanwendung.data.Data;
import de.rainer.basisanwendung.gui.label.BasisLabel;
import de.rainer.basisanwendung.gui.panel.BasisPanel;

public class Accountverwaltung extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField loginTextField;
	private JTextField passwortTextField;
	private JButton loginChangeButton;
	private JButton passwortChangeButton;
	private JButton delete_cancel;

	private JTextField getLoginTextField() {
		return this.loginTextField;
	}

	private void setLoginTextField(JTextField loginTextField) {
		this.loginTextField = loginTextField;
	}

	private JTextField getPasswortTextField() {
		return this.passwortTextField;
	}

	private void setPasswortTextField(JTextField passwortTextField) {
		this.passwortTextField = passwortTextField;
	}

	private JButton getLoginChangeButton() {
		return this.loginChangeButton;
	}

	private void setLoginChangeButton(JButton loginChangeButton) {
		this.loginChangeButton = loginChangeButton;
	}

	private JButton getPasswortChangeButton() {
		return this.passwortChangeButton;
	}

	private void setPasswortChangeButton(JButton passwortChangeButton) {
		this.passwortChangeButton = passwortChangeButton;
	}

	private JButton getDelete_cancel() {
		return delete_cancel;
	}

	private void setDelete_cancel(JButton delete_cancel) {
		this.delete_cancel = delete_cancel;
	}

	public Accountverwaltung(JTextField loginTextfield,
			JTextField passwortTextField, JButton loginChangeButton,
			JButton passwortChangeButton, JButton delete_cancel) {
		super();
		this.setLoginTextField(loginTextfield);
		this.setPasswortTextField(passwortTextField);
		this.setLoginChangeButton(loginChangeButton);
		this.setPasswortChangeButton(passwortChangeButton);
		this.setDelete_cancel(delete_cancel);
		this.init();
	}

	public Accountverwaltung() {
		this(new JTextField(), new JTextField(), new JButton(), new JButton(),
				new JButton());
	}

	private void init() {
		super.setLayout(new BorderLayout());
		super.setBackground(Color.YELLOW);
		super.setBorder(new LineBorder(Color.BLACK, 2));
		BasisPanel main = new BasisPanel(Color.YELLOW, null);
		BasisPanel outter = new BasisPanel(new LineBorder(Color.BLACK, 2),
				Color.WHITE, new BorderLayout());
		outter.setBounds(471, 224, 600, 250);
		BasisPanel north = new BasisPanel(Color.WHITE);
		outter.add(north, BorderLayout.NORTH);
		BasisPanel south = new BasisPanel(Color.WHITE);
		outter.add(south, BorderLayout.SOUTH);
		BasisPanel west = new BasisPanel(Color.WHITE);
		outter.add(west, BorderLayout.WEST);
		BasisPanel east = new BasisPanel(Color.WHITE);
		outter.add(east, BorderLayout.EAST);
		BasisPanel inner = new BasisPanel(new LineBorder(Color.BLACK, 2),
				Color.YELLOW, new BorderLayout());
		BasisPanel labelPanel = new BasisPanel(Color.YELLOW);
		BasisLabel label = new BasisLabel("Accountverwaltung", new Font(
				"Tahoma", Font.BOLD, 30), SwingConstants.CENTER);
		labelPanel.add(label);
		inner.add(labelPanel, BorderLayout.NORTH);
		BasisPanel center = new BasisPanel(Color.YELLOW, new GridLayout(2, 3));
		BasisPanel loginLabelPanel = new BasisPanel(Color.YELLOW, null);
		BasisLabel loginLabel = new BasisLabel("Login:", new Font("Tahoma",
				Font.BOLD, 15));
		loginLabel.setBounds(50, 45, 100, 24);
		loginLabelPanel.add(loginLabel);
		center.add(loginLabelPanel);
		BasisPanel loginTextFieldPanel = new BasisPanel(Color.YELLOW, null);
		this.getLoginTextField().setText(
				Data.getInstance().getUser().getLoginBenutzer());
		this.getLoginTextField().setEditable(false);
		this.getLoginTextField().setBounds(0, 45, 190, 24);
		loginTextFieldPanel.add(this.getLoginTextField());
		center.add(loginTextFieldPanel);
		BasisPanel loginButtonPanel = new BasisPanel(Color.YELLOW, null);
		// ================================================================================================================
		this.getLoginChangeButton().setText("Ändern");
		this.getLoginChangeButton().setBounds(50, 45, 100, 24);
		this.getLoginChangeButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Ändern")) {
					Accountverwaltung.this.getLoginTextField()
							.setEditable(true);
					Accountverwaltung.this.getLoginChangeButton().setText(
							"Speichern");
					Accountverwaltung.this.getDelete_cancel()
							.setText("Abbruch");
					Accountverwaltung.this.getDelete_cancel().setBackground(
							UIManager.getColor("Button.background"));
					Accountverwaltung.this.getPasswortChangeButton()
							.setEnabled(false);
				} else {
					String newLogin = Accountverwaltung.this
							.getLoginTextField().getText();
					if (Data.getInstance()
							.getLehrer()
							.editLehrerLogin(
									newLogin,
									Data.getInstance().getUser()
											.getLoginBenutzer())) {
						Data.getInstance().getLehrer().setLogin(newLogin);
						Data.getInstance().getUser().setLoginBenutzer(newLogin);
						Data.getInstance().notifyAllObserver(true);
					} else {
						new Warning("Loginname existiert bereits !");
					}
					Accountverwaltung.this.getLoginTextField().setText(
							Data.getInstance().getUser().getLoginBenutzer());
					Accountverwaltung.this.getLoginTextField().setEditable(
							false);
					Accountverwaltung.this.getLoginChangeButton().setText(
							"Ändern");
					Accountverwaltung.this.getDelete_cancel().setText(
							"Account löschen");
					Accountverwaltung.this.getDelete_cancel().setBackground(
							Color.RED);
					Accountverwaltung.this.getPasswortChangeButton()
							.setEnabled(true);
				}
			}
		});
		loginButtonPanel.add(this.getLoginChangeButton());
		center.add(loginButtonPanel);
		BasisPanel passwortLabelPanel = new BasisPanel(Color.YELLOW, null);
		BasisLabel passwortLabel = new BasisLabel("Passwort", new Font(
				"Tahoma", Font.BOLD, 15));
		passwortLabel.setBounds(50, 20, 100, 24);
		passwortLabelPanel.add(passwortLabel);
		center.add(passwortLabelPanel);
		BasisPanel passwortTextFieldPanel = new BasisPanel(Color.YELLOW, null);
		this.getPasswortTextField().setText(
				Data.getInstance().getUser().getLoginPasswort());
		this.getPasswortTextField().setEditable(false);
		this.getPasswortTextField().setBounds(0, 20, 190, 24);
		passwortTextFieldPanel.add(this.getPasswortTextField());
		center.add(passwortTextFieldPanel);
		BasisPanel passwortButtonPanel = new BasisPanel(Color.YELLOW, null);
		this.getPasswortChangeButton().setText("Ändern");
		this.getPasswortChangeButton().setBounds(50, 20, 100, 24);
		this.getPasswortChangeButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Ändern")) {
					Accountverwaltung.this.getPasswortTextField().setEditable(
							true);
					Accountverwaltung.this.getPasswortChangeButton().setText(
							"Speichern");
					Accountverwaltung.this.getDelete_cancel()
							.setText("Abbruch");
					Accountverwaltung.this.getDelete_cancel().setBackground(
							UIManager.getColor("Button.background"));
					Accountverwaltung.this.getLoginChangeButton().setEnabled(
							false);
				} else {
					String newPasswort = Accountverwaltung.this
							.getPasswortTextField().getText();
					Data.getInstance()
							.getLehrer()
							.editLehrerPasswort(
									newPasswort,
									Data.getInstance().getUser()
											.getLoginPasswort());
					Data.getInstance().getLehrer().setPasswort(newPasswort);
					Data.getInstance().getUser().setLoginPasswort(newPasswort);
					Accountverwaltung.this.getPasswortTextField().setEditable(
							false);
					Accountverwaltung.this.getPasswortChangeButton().setText(
							"Ändern");
					Accountverwaltung.this.getDelete_cancel().setText(
							"Account löschen");
					Accountverwaltung.this.getDelete_cancel().setBackground(
							Color.RED);
					Accountverwaltung.this.getLoginChangeButton().setEnabled(
							true);
				}
			}
		});
		passwortButtonPanel.add(this.getPasswortChangeButton());
		center.add(passwortButtonPanel);
		inner.add(center, BorderLayout.CENTER);
		BasisPanel buttonPanel = new BasisPanel(Color.YELLOW);
		this.getDelete_cancel().setText("Account löschen");
		this.getDelete_cancel().setBackground(Color.RED);
		this.getDelete_cancel().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Abbruch")) {
					if (Accountverwaltung.this.getLoginTextField().isEditable()) {
						Accountverwaltung.this.getLoginTextField().setEditable(
								false);
						Accountverwaltung.this.getLoginChangeButton().setText(
								"Ändern");
						Accountverwaltung.this.getDelete_cancel().setText(
								"Account löschen");
						Accountverwaltung.this.getDelete_cancel()
								.setBackground(Color.RED);
						Accountverwaltung.this.getPasswortChangeButton()
								.setEnabled(true);
					} else {
						Accountverwaltung.this.getPasswortTextField()
								.setEditable(false);
						Accountverwaltung.this.getPasswortChangeButton()
								.setText("Ändern");
						Accountverwaltung.this.getDelete_cancel().setText(
								"Account löschen");
						Accountverwaltung.this.getDelete_cancel()
								.setBackground(Color.RED);
						Accountverwaltung.this.getLoginChangeButton()
								.setEnabled(true);
					}
				} else {

				}

			}
		});
		buttonPanel.add(this.getDelete_cancel());
		inner.add(buttonPanel, BorderLayout.SOUTH);
		outter.add(inner, BorderLayout.CENTER);
		main.add(outter);
		super.add(main, BorderLayout.CENTER);
		super.setVisible(true);
	}

}
