package framework.repo;

import java.util.Collection;
import java.util.Optional;

public interface Repository<T,S> {

    void save(T t);
    void delete(T t);
    Optional<T> findById(S s);
    Collection<T> findAll();
}
