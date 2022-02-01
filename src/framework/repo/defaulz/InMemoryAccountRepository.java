package framework.repo.defaulz;

import framework.account.Account;
import framework.repo.AccountRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class InMemoryAccountRepository implements AccountRepository {

    private final Collection<Account> accounts = new ArrayList<>();

    @Override
    public void save(Account account) {
        Optional<Account> oldAccount = findById(account.getAccountNo());
        if (oldAccount.isPresent()) update(oldAccount.get(), account);
        else accounts.add(account);
    }

    @Override
    public void delete(Account account) {
        accounts.remove(account);
    }

    @Override
    public Optional<Account> findById(String s) {
        return accounts.stream()
                .filter(a -> a.getAccountNo().equals(s))
                .findAny();
    }

    @Override
    public Collection<Account> findAll() {
        return accounts;
    }

    private void update(Account oldAccount, Account newAccount) {
        oldAccount.setBalance(newAccount.getBalance());
    }
}
