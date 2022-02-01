package framework.repo.defaulz;

import framework.account.AccountEntry;
import framework.repo.AccountEntryRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class InMemoryAccountEntryRepository implements AccountEntryRepository {

    private final Collection<AccountEntry> entries = new ArrayList<>();

    @Override
    public void save(AccountEntry entry) {
        entries.add(entry);
    }

    @Override
    public void delete(AccountEntry entry) {
        throw new UnsupportedOperationException("Account entry can't be delete");
    }

    @Override
    public Optional<AccountEntry> findById(String s) {
        return entries.stream()
                .filter(ae -> ae.getId().equals(s))
                .findAny();
    }

    @Override
    public Collection<AccountEntry> findAll() {
        return entries;
    }
}
