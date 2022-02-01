package framework.rule;

public interface Rule<T> {
    boolean isApplicable(T t);
    void apply(T t);
}
