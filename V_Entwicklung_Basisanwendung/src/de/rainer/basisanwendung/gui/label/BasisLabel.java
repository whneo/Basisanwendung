package de.rainer.basisanwendung.gui.label;

import java.awt.Font;

import javax.swing.JLabel;

public class BasisLabel extends JLabel {

	private static final long serialVersionUID = 2098440264088151577L;

	public BasisLabel(String text, Font font, int hAlignment) {
		super(text);
		super.setFont(font);
		if (hAlignment != -1) {
			super.setHorizontalAlignment(hAlignment);
		}
	}

	public BasisLabel() {
		this(null, null, -1);
	}

	public BasisLabel(String text, Font font) {
		this(text, font, -1);
	}
	
	public BasisLabel(Font font, int hAlignment) {
		this("", font, hAlignment);
	}
}
