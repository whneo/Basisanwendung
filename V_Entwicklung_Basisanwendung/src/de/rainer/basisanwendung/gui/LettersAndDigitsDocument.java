package de.rainer.basisanwendung.gui;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import de.rainer.basisanwendung.data.Data;

public class LettersAndDigitsDocument extends PlainDocument {

	private static final long serialVersionUID = 1L;
	private String fieldType;

	private String getFieldType() {
		return fieldType;
	}

	private void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public LettersAndDigitsDocument(String fieldType) {
		super();
		this.setFieldType(fieldType);
	}

	public LettersAndDigitsDocument() {
		this("fieldtype");
	}

	@Override
	public void insertString(int offs, String s, AttributeSet a) {
		if (Character.isLetterOrDigit(s.charAt(0)) && s.length() == 1) {
			try {
				super.insertString(offs, s, a);
				if (this.getFieldType().equals("benutzer")) {
					Data.getInstance().getUser().setLoginBenutzer(
							Data.getInstance().getUser().getLoginBenutzer() + s);
				} else {
					Data.getInstance().getUser().setLoginPasswort(
							Data.getInstance().getUser().getLoginPasswort() + s);
				}
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		}
	}
}