package de.rainer.basisanwendung.data;

import java.util.ArrayList;

import de.rainer.basisanwendung.user.Admin;
import de.rainer.basisanwendung.user.AktivUser;
import de.rainer.basisanwendung.user.Benutzer;
import de.rainer.basisanwendung.user.Eltern;
import de.rainer.basisanwendung.user.Lehrer;

public class Data implements IDataButton {

	private static Data instance;
	private ArrayList<IObserver> observerList;
	private AktivUser user;
	private Admin admin;
	private Benutzer benutzer;
	private Lehrer lehrer;
	private Eltern eltern;
	private String usedButton;
	private String Spiel;

	public static Data getInstance() {
		if (Data.instance == null) {
			Data.setInstance(new Data());
		}
		return Data.instance;
	}

	private static void setInstance(Data instance) {
		Data.instance = instance;
	}

	private ArrayList<IObserver> getObserverList() {
		return this.observerList;
	}

	private void setObserverList(ArrayList<IObserver> observerList) {
		this.observerList = observerList;
	}

	public AktivUser getUser() {
		return user;
	}

	private void setUser(AktivUser user) {
		this.user = user;
	}

	public Admin getAdmin() {
		return admin;
	}

	private void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Benutzer getBenutzer() {
		return benutzer;
	}

	private void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}

	public Lehrer getLehrer() {
		return lehrer;
	}

	private void setLehrer(Lehrer lehrer) {
		this.lehrer = lehrer;
	}

	public Eltern getEltern() {
		return eltern;
	}

	private void setEltern(Eltern eltern) {
		this.eltern = eltern;
	}

	public String getUsedButton() {
		return usedButton;
	}

	@Override
	public void setObservedUsedButton(String usedButton) {
		this.usedButton = usedButton;
	}

	public String getSpiel() {
		return this.Spiel;
	}

	public void setSpiel(String spiel) {
		Spiel = spiel;
	}

	private Data(ArrayList<IObserver> observerList, AktivUser user,
			Admin admin, Benutzer benutzer, Lehrer lehrer, Eltern eltern,
			String usedButton, String spiel) {
		super();
		this.setObserverList(observerList);
		this.setUser(user);
		this.setAdmin(admin);
		this.setBenutzer(benutzer);
		this.setLehrer(lehrer);
		this.setEltern(eltern);
		this.setObservedUsedButton(usedButton);
		this.setSpiel(spiel);
	}

	private Data() {
		this(new ArrayList<IObserver>(), new AktivUser(), new Admin(),
				new Benutzer(), new Lehrer(), new Eltern(), "", "");
	}

	@Override
	public void addObserver(IObserver observer) {
		this.getObserverList().add(observer);

	}

	@Override
	public void removeObserver(IObserver observer) {
		this.getObserverList().remove(observer);

	}

	@Override
	public void notifyAllObserver(boolean setLabel) {
		if (this.getObserverList().size() > 0) {
			for (int i = 0; i < this.getObserverList().size(); i++) {
				this.getObserverList().get(i).update(setLabel);
			}
		}
	}

	public void clearData() {
		this.setUser(new AktivUser());
		this.setAdmin(new Admin());
		this.setBenutzer(new Benutzer());
		this.setLehrer(new Lehrer());
		this.setEltern(new Eltern());
		this.setObservedUsedButton("");
		this.setSpiel("");
	}
}