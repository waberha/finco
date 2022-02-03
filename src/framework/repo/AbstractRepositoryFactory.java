package framework.repo;

public abstract class AbstractRepositoryFactory {

    public abstract CustomerRepository createCustomerRepository();
    public abstract AccountRepository createAccountRepository();
    public abstract AccountEntryRepository createAccountEntryRepository();
}
