package de.rainer.basisanwendung;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import de.rainer.basisanwendung.datenbank.ElementaryDbManager;
import de.rainer.basisanwendung.gui.Login;
import de.rainer.basisanwendung.gui.MainPanel;

public class Basisanwendung {

	public static final int FRAME_WIDTH = 1600;
	public static final int FRAME_HEIGHT = 1000;
	public static final JFrame MAINFRAME = new JFrame();

	public static void main(String[] args) {
		ElementaryDbManager.getInstance().createDatabase();
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension d = t.getScreenSize();
		int x = (int) ((d.getWidth() - Basisanwendung.FRAME_WIDTH) / 2);
		int y = (int) ((d.getHeight() - Basisanwendung.FRAME_HEIGHT) / 2);
		Basisanwendung.MAINFRAME.setBounds(x, y, Basisanwendung.FRAME_WIDTH,
				Basisanwendung.FRAME_HEIGHT);
		Basisanwendung.MAINFRAME.setTitle("ElementarySchool");
		Basisanwendung.MAINFRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Basisanwendung.MAINFRAME.setResizable(false);
		Basisanwendung.MAINFRAME.add(new MainPanel());
		// Basisanwendung.MAINFRAME.add(new AdminPanel());
		Basisanwendung.MAINFRAME.setVisible(true);
		new Login();
	}

}