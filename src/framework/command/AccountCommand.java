package framework.command;

import framework.account.Account;
import framework.repo.AccountRepository;

public abstract class AccountCommand extends Command<Account> {

    protected final AccountRepository accountRepository;
    protected final Account account;

    public AccountCommand(AccountRepository accountRepository, Account account) {
        this.accountRepository = accountRepository;
        this.account = account;
    }
}
