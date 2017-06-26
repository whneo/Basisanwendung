package de.rainer.basisanwendung.data;

public interface IObservableData {
	public abstract void addObserver(IObserver observer);

	public abstract void removeObserver(IObserver observer);

	public abstract void notifyAllObserver(boolean setLabel);
}