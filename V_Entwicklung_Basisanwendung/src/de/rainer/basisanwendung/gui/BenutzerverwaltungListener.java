package de.rainer.basisanwendung.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;

import de.rainer.basisanwendung.data.Data;

public class BenutzerverwaltungListener implements ActionListener,
		MouseListener {

	public BenutzerverwaltungListener() {
		super();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		JTable table = (JTable) e.getSource();
		for (int row : table.getSelectedRows()) {
			int beginX = (int) table.getCellRect(row, 0, true).getX();
			int beginY = (int) table.getCellRect(row, 0, true).getY();
			int cellHeight = (int) table.getCellRect(row, 0, true).getHeight();
			int cellWidth = (int) table.getCellRect(row, 0, true).getWidth();
			int endX = cellWidth * 3;
			int endY = beginY + cellHeight;
			if ((e.getX() > beginX && e.getX() < endX)
					&& (e.getY() > beginY && e.getY() < endY)) {
				if (e.isPopupTrigger()) {
					JPopupMenu menu = new JPopupMenu();
					JMenuItem headItem = new JMenuItem(
							"Benutzer administrieren");
					menu.add(headItem);
					menu.addSeparator();
					JMenuItem edit = new JMenuItem("bearbeiten");
					edit.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							new BenutzerBearbeiten((String) table.getValueAt(
									row, 0));
						}
					});
					if (table.getSelectedRows().length > 1) {
						edit.setEnabled(false);
					}
					menu.add(edit);
					JMenuItem delete = new JMenuItem("löschen");
					delete.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							for (int row : table.getSelectedRows()) {
								Data.getInstance()
										.getBenutzer()
										.deleteBenutzer(
												(String) table.getValueAt(row,
														0));
							}
							Data.getInstance().notifyAllObserver(false);
						}
					});
					menu.add(delete);
					menu.show(((JTable) e.getSource()), e.getX(), e.getY());
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JDialog d = new JDialog();
		d.setVisible(true);
	}

}