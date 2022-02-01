package framework.command.impl;

import framework.account.Account;
import framework.account.AccountEntry;
import framework.repo.AccountEntryRepository;
import framework.repo.AccountRepository;

import java.util.Optional;

public class WithdrawMoneyCommand extends AccountEntryCommand {

    private final AccountRepository accountRepository;
    private final String accountNo;
    private final double amount;

    // Package protecting constructor
    WithdrawMoneyCommand(AccountRepository accountRepository, AccountEntryRepository accountEntryRepository, String accountNo, double amount) {
        super(accountEntryRepository);
        this.accountRepository = accountRepository;
        this.accountNo = accountNo;
        this.amount = amount;
    }

    @Override
    public void execute() {

        Optional<Account> account = accountRepository.findById(accountNo);
        if (!account.isPresent()) throw new RuntimeException("Unknown account number");

        AccountEntry entry = new AccountEntry(account.get(), Math.abs(amount) * -1);
        accountEntryRepository.save(entry);
    }
}
