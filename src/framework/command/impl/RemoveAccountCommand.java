package framework.command.impl;

import framework.account.Account;
import framework.command.AccountCommand;
import framework.repo.AccountRepository;

public class RemoveAccountCommand extends AccountCommand {

    private final String accountNo;

    // Package protecting constructor
    RemoveAccountCommand(AccountRepository accountRepository, Account account, String accountNo) {
        super(accountRepository, account);
        this.accountNo = accountNo;
    }

    @Override
    public void execute() {
        accountRepository.findById(accountNo)
                .ifPresent(accountRepository::delete);
    }
}
