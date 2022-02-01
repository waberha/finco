package framework.repo.defaulz;

import framework.repo.AbstractRepositoryFactory;
import framework.repo.AccountEntryRepository;
import framework.repo.AccountRepository;
import framework.repo.PartyRepository;

public class InMemoryRepositoryFactory extends AbstractRepositoryFactory {

    @Override
    public PartyRepository createPartyRepository() {
        return new InMemoryPartyRepository();
    }

    @Override
    public AccountRepository createAccountRepository() {
        return new InMemoryAccountRepository();
    }

    @Override
    public AccountEntryRepository createAccountEntryRepository() {
        return new InMemoryAccountEntryRepository();
    }
}
