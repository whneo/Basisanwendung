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

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Warning extends JDialog {

	private static final long serialVersionUID = 1L;

	public Warning(String str) {
		super();
		this.init(str);
	}

	public Warning() {
		this("");
	}

	private void init(String str) {			
//			super.setBounds(470, 250, 600, 250);
			
			Toolkit t = Toolkit.getDefaultToolkit();
			Dimension d = t.getScreenSize();
			int width = 0;
			int height = 0;
			if (str.equals("Loginname existiert bereits !")) {
				width = 600;
				height = 250;
			} else {
			width = 400;
			height = 150;
			}
			int x = (int) ((d.getWidth() - width) / 2);
			int y = (int) ((d.getHeight() - height) / 2);
			
			super.setBounds(x, y, width, height);
		
			super.setUndecorated(true);
		super.setModal(true);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBackground(Color.YELLOW);
		panel.setBorder(new LineBorder(Color.RED, 5));
		JPanel labelPanel = new JPanel();
		labelPanel.setBackground(Color.YELLOW);
		JLabel label = new JLabel(str);
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelPanel.add(label);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.YELLOW);
		JButton button = new JButton("OK");
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Warning.this.dispatchEvent(new WindowEvent(Warning.this,
						WindowEvent.WINDOW_CLOSING));
			}
		});
		button.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				Warning.this.dispatchEvent(new WindowEvent(Warning.this,
						WindowEvent.WINDOW_CLOSING));
			}
		});
		buttonPanel.add(button);
		panel.add(buttonPanel, BorderLayout.SOUTH);
		panel.add(labelPanel, BorderLayout.CENTER);
		super.add(panel);
		super.setVisible(true);
	}
}