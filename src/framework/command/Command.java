package framework.command;

import framework.observer.Observable;

public abstract class Command<T> extends Observable<T> {

    public abstract void execute();
}
