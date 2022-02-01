package framework.command.impl;

import framework.account.Account;
import framework.party.Party;
import framework.repo.AccountEntryRepository;
import framework.repo.AccountRepository;
import framework.repo.PartyRepository;

public class CommandFactory {

    protected final PartyRepository partyRepository;
    protected final AccountRepository accountRepository;
    protected final AccountEntryRepository accountEntryRepository;

    public CommandFactory(PartyRepository partyRepository, AccountRepository accountRepository, AccountEntryRepository accountEntryRepository) {
        this.partyRepository = partyRepository;
        this.accountRepository = accountRepository;
        this.accountEntryRepository = accountEntryRepository;
    }

    public CreatePartyCommand createCreatePartyCommand(Party party, Account account) {
        return new CreatePartyCommand(partyRepository, accountRepository, party, account);
    }

    public RemovePartyCommand createRemovePartyCommand(String name) {
        return new RemovePartyCommand(partyRepository, null, name);
    }

    public CreateAccountCommand createCreateAccountCommand(String name, Account account) {
        return new CreateAccountCommand(partyRepository, accountRepository, account, name);
    }

    public RemoveAccountCommand createRemoveAccountCommand(String accountNo) {
        return new RemoveAccountCommand(accountRepository, null, accountNo);
    }

    public WithdrawMoneyCommand createWithdrawMoneyCommand(String accountNo, double amount) {
        return new WithdrawMoneyCommand(accountRepository, accountEntryRepository, accountNo, amount);
    }

    public DepositMoneyCommand createDepositMoneyCommand(String accountNo, double amount) {
        return new DepositMoneyCommand(accountRepository, accountEntryRepository, accountNo, amount);
    }
}
