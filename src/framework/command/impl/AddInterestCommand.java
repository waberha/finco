package framework.command.impl;

import framework.account.Account;
import framework.account.AccountEntry;
import framework.command.AccountCommand;
import framework.repo.AccountEntryRepository;
import framework.repo.AccountRepository;

import java.util.Collection;

public class AddInterestCommand extends AccountCommand {

    private final AccountEntryRepository accountEntryRepository;

    public AddInterestCommand(AccountRepository accountRepository, AccountEntryRepository accountEntryRepository, Account account) {
        super(accountRepository, account);
        this.accountEntryRepository = accountEntryRepository;
    }

    @Override
    public void execute() {

        Collection<Account> accounts = accountRepository.findAll();

        for(Account account : accounts) {
            double interest = account.addInterest();
            AccountEntry entry = new AccountEntry(account, interest);
            accountEntryRepository.save(entry);
            notify(account);
        }
    }
}
