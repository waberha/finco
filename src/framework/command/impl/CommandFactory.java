package framework.command.impl;

import framework.account.Account;
import framework.party.Party;
import framework.repo.AccountEntryRepository;
import framework.repo.AccountRepository;
import framework.repo.PartyRepository;
import framework.rule.RuleManager;

public class CommandFactory {

    protected final PartyRepository partyRepository;
    protected final AccountRepository accountRepository;
    protected final AccountEntryRepository accountEntryRepository;
    protected final RuleManager ruleManager;

    public CommandFactory(RuleManager ruleManager, PartyRepository partyRepository, AccountRepository accountRepository, AccountEntryRepository accountEntryRepository) {
        this.ruleManager = ruleManager;
        this.partyRepository = partyRepository;
        this.accountRepository = accountRepository;
        this.accountEntryRepository = accountEntryRepository;
    }

    public CreatePartyCommand createCreatePartyCommand(Party party, Account account) {
        CreatePartyCommand command = new CreatePartyCommand(partyRepository, accountRepository, party, account);
        command.attachObserver(ruleManager.getPartyRuleManager());
        return command;
    }

    public RemovePartyCommand createRemovePartyCommand(String name) {
        RemovePartyCommand command = new RemovePartyCommand(partyRepository, null, name);
        command.attachObserver(ruleManager.getPartyRuleManager());
        return command;
    }

    public CreateAccountCommand createCreateAccountCommand(String name, Account account) {
        CreateAccountCommand command = new CreateAccountCommand(partyRepository, accountRepository, account, name);
        command.attachObserver(ruleManager.getAccountRuleManager());
        return command;
    }

    public RemoveAccountCommand createRemoveAccountCommand(String accountNo) {
        RemoveAccountCommand command = new RemoveAccountCommand(accountRepository, null, accountNo);
        command.attachObserver(ruleManager.getAccountRuleManager());
        return command;
    }

    public WithdrawMoneyCommand createWithdrawMoneyCommand(String accountNo, double amount) {
        WithdrawMoneyCommand command =  new WithdrawMoneyCommand(accountRepository, accountEntryRepository, accountNo, amount);
        command.attachObserver(ruleManager.getAccountEntryRuleManager());
        return command;
    }

    public DepositMoneyCommand createDepositMoneyCommand(String accountNo, double amount) {
        DepositMoneyCommand command = new DepositMoneyCommand(accountRepository, accountEntryRepository, accountNo, amount);
        command.attachObserver(ruleManager.getAccountEntryRuleManager());
        return command;
    }
}
