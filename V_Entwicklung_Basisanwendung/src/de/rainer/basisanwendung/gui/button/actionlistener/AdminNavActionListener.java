package de.rainer.basisanwendung.gui.button.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.rainer.basisanwendung.data.Data;

public class AdminNavActionListener implements ActionListener {

	private final Data data = Data.getInstance();
	
	private Data getData() {
		return data;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Logout": {
			this.getData().clearData();
			this.getData().notifyAllObserver(true);
			break;
		}
		default: {
			this.getData().setObservedUsedButton(
					e.getActionCommand());
			this.getData().notifyAllObserver(true);
			break;
		}
		}
	}

}
