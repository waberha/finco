package framework.observer;

import java.util.Collection;
import java.util.HashSet;

public abstract class Observable<T> {

    protected final Collection<Observer<T>> observers = new HashSet<>();

    public void attachObserver(Observer<T> observer) {
        observers.add(observer);
    }

    public void detachObserver(Observer<T> observer) {
        observers.remove(observer);
    }

    public void notify(T t) {
        for (Observer<T> observer : observers) {
            observer.update(t);
        }
    }
}
