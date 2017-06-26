package de.rainer.basisanwendung.gui.button;

import javax.swing.JButton;

import de.rainer.basisanwendung.gui.button.actionlistener.AdminNavActionListener;

public class AdminNavButton extends JButton {

	private static final long serialVersionUID = -7827495051906323604L;

	public AdminNavButton(String text){
		super(text);
		super.setSelected(false);
		super.setFocusable(false);
		super.setEnabled(true);
		super.addActionListener(new AdminNavActionListener());
	}
}
