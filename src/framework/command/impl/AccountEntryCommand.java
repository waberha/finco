package framework.command.impl;

import framework.account.AccountEntry;
import framework.command.Command;
import framework.repo.AccountEntryRepository;

public abstract class AccountEntryCommand extends Command<AccountEntry> {

    protected final AccountEntryRepository accountEntryRepository;

    AccountEntryCommand(AccountEntryRepository accountEntryRepository) {
        this.accountEntryRepository = accountEntryRepository;
    }
}
