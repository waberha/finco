package framework.repo;

import framework.account.AccountEntry;

public abstract class AbstractRepositoryFactory {

    public abstract PartyRepository createPartyRepository();
    public abstract AccountRepository createAccountRepository();
    public abstract AccountEntryRepository createAccountEntryRepository();
}
