package de.rainer.basisanwendung.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import zahlenpyramide.IZahlenpyramideApi;
import de.rainer.basisanwendung.Basisanwendung;
import de.rainer.basisanwendung.data.Data;
import de.rainer.basisanwendung.data.IObserver;
import de.rainer.buchstabensalat.data.IExternObserver;
import de.rainer.buchstabensalat.schnittstelle.IBuchstabensalatApi;

public class MainPanel extends JPanel implements IObserver, IExternObserver,
		IBuchstabensalatApi {

	private static final long serialVersionUID = 1L;

	private JPanel center;

	private JPanel getCenter() {
		return this.center;
	}

	private void setCenter(JPanel center) {
		this.center = center;
	}

	public MainPanel(JPanel center) {
		super();
		Data.getInstance().addObserver(this);
		this.addExternObserver(this);
		this.setCenter(center);
		this.init();
	}

	public MainPanel() {
		this(new JPanel());
	}

	private void init() {
		super.setLayout(new BorderLayout());
		super.setBackground(Color.YELLOW);
		super.setBorder(new LineBorder(Color.BLACK, 2));
		this.initNorth();
		this.initSouth();
		this.initSide();
		this.initCenter();
		super.setVisible(true);
	}

	private void initNorth() {
		JLabel ueberschrift = new JLabel("ElementarySchool");
		ueberschrift.setFont(new Font("Tahoma", Font.BOLD, 40));
		ueberschrift.setForeground(Color.BLACK);
		ueberschrift.setHorizontalAlignment(SwingConstants.CENTER);
		super.add(ueberschrift, BorderLayout.NORTH);
	}

	private void initSouth() {
		JPanel south = new JPanel();
		south.setBackground(Color.YELLOW);
		south.setLayout(new GridLayout(1, 2));
		JLabel copyright = new JLabel("Entwickelt von der Zeitner GmbH");
		Font font = new Font("Tahoma", Font.PLAIN, 20);
		copyright.setFont(font);
		copyright.setForeground(Color.BLACK);
		copyright.setHorizontalAlignment(SwingConstants.LEFT);
		JLabel jahr = new JLabel("2017");
		jahr.setFont(font);
		jahr.setForeground(Color.BLACK);
		jahr.setHorizontalAlignment(SwingConstants.RIGHT);
		south.add(copyright);
		south.add(jahr);
		super.add(south, BorderLayout.SOUTH);
	}

	private void initCenter() {
		this.getCenter().setBackground(Color.WHITE);
		this.getCenter().setBorder(new LineBorder(Color.BLACK, 2));
		super.add(this.getCenter(), BorderLayout.CENTER);
	}

	private void initSide() {
		JPanel east = new JPanel();
		east.setBackground(Color.YELLOW);
		super.add(east, BorderLayout.EAST);
		JPanel west = new JPanel();
		west.setBackground(Color.YELLOW);
		super.add(west, BorderLayout.WEST);
	}

	private void switchPanel() {
		boolean loginFlag = false;
		super.setVisible(false);
		super.remove(this.getCenter());
		switch (Data.getInstance().getUser().getLoginTyp()) {
		case "Admin": {
			this.setCenter(new AdminPanel());
			super.add(this.getCenter(), BorderLayout.CENTER);
			break;
		}
		case "Eltern": {
			this.setCenter(new AdminPanel());
			super.add(this.getCenter(), BorderLayout.CENTER);
			break;
		}
		case "Lehrer": {
			this.setCenter(new AdminPanel());
			super.add(this.getCenter(), BorderLayout.CENTER);
			break;
		}
		case "Benutzer": {
			switch (Data.getInstance().getSpiel()) {
			case "Buchstabensalat": {
				this.setCenter(this.startBuchstabensalat(Data.getInstance()
						.getUser().getLoginBenutzer()));
				break;
			}
			case "Zahlenpyramide": {
				Basisanwendung.MAINFRAME.setDefaultCloseOperation(0);
				this.setCenter(IZahlenpyramideApi.starteZahlenpyramide());
				break;
			}
			default: {
				Basisanwendung.MAINFRAME
						.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.setCenter(new SpielePanel());
				break;
			}
			}
			super.add(this.getCenter(), BorderLayout.CENTER);
			break;
		}
		default: {
			this.setCenter(new JPanel());
			this.initCenter();
			loginFlag = true;
			break;
		}
		}
		super.setVisible(true);
		if (loginFlag) {
			new Login();
		}
	}

	@Override
	public void update(boolean setLabel) {
		this.switchPanel();
	}

	@Override
	public void externUpdate() {
		Data.getInstance().setSpiel("");
		this.switchPanel();
	}

}