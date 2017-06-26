package de.rainer.basisanwendung.user;

import java.util.ArrayList;

import de.rainer.basisanwendung.data.IDataLogin;
import de.rainer.basisanwendung.data.IObserver;

public class AktivUser implements IDataLogin {

	private ArrayList<IObserver> observerList;
	private int id;
	private String loginBenutzer;
	private String loginPasswort;
	private String loginTyp;

	private ArrayList<IObserver> getObserverList() {
		return this.observerList;
	}

	private void setObserverList(ArrayList<IObserver> observerList) {
		this.observerList = observerList;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginBenutzer() {
		return this.loginBenutzer;
	}

	public void setLoginBenutzer(String loginBenutzer) {
		this.loginBenutzer = loginBenutzer;
	}

	public String getLoginPasswort() {
		return this.loginPasswort;
	}

	public void setLoginPasswort(String loginPasswort) {
		this.loginPasswort = loginPasswort;
	}

	public String getLoginTyp() {
		return this.loginTyp;
	}

	@Override
	public void setObservedLoginTyp(String loginTyp) {
		this.loginTyp = loginTyp;
	}

	public AktivUser(int id, ArrayList<IObserver> observerList, String loginBenutzer,
			String loginPasswort, String loginTyp) {
		super();
		this.setId(id);
		this.setObserverList(observerList);
		this.setLoginBenutzer(loginBenutzer);
		this.setLoginPasswort(loginPasswort);
		this.setObservedLoginTyp(loginTyp);
	}

	public AktivUser() {
		this(1, new ArrayList<IObserver>(), "", "", "");
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

}