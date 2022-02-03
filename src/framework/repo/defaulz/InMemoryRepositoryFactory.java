package framework.repo.defaulz;

import framework.repo.AbstractRepositoryFactory;
import framework.repo.AccountEntryRepository;
import framework.repo.AccountRepository;
import framework.repo.CustomerRepository;

public class InMemoryRepositoryFactory extends AbstractRepositoryFactory {

    @Override
    public CustomerRepository createCustomerRepository() {
        return new InMemoryCustomerRepository();
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
