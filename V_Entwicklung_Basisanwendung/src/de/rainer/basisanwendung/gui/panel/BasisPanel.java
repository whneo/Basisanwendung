package de.rainer.basisanwendung.gui.panel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.border.Border;

public class BasisPanel extends JPanel {

	private static final long serialVersionUID = 2149449761221955805L;

	public BasisPanel(Border border, Color bgColor, LayoutManager layout) {
		super();
		if (border != null) {
			super.setBorder(border);
		}
		super.setBackground(bgColor);
		super.setLayout(layout);
	}

	public BasisPanel() {
		this(null, null, new FlowLayout());
	}

	public BasisPanel(Color bgColor) {
		this(null, bgColor, new FlowLayout());
	}

	public BasisPanel(Border border, Color bgColor) {
		this(border, bgColor, new FlowLayout());
	}

	public BasisPanel(Color bgColor, LayoutManager layout) {
		this(null, bgColor, layout);
	}
}
