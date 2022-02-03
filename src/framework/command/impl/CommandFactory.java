package framework.command.impl;

import framework.account.Account;
import framework.customer.Customer;
import framework.repo.AccountEntryRepository;
import framework.repo.AccountRepository;
import framework.repo.CustomerRepository;
import framework.rule.RuleManager;

public class CommandFactory {

    protected final CustomerRepository customerRepository;
    protected final AccountRepository accountRepository;
    protected final AccountEntryRepository accountEntryRepository;
    protected final RuleManager ruleManager;

    public CommandFactory(RuleManager ruleManager, CustomerRepository customerRepository, AccountRepository accountRepository, AccountEntryRepository accountEntryRepository) {
        this.ruleManager = ruleManager;
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
        this.accountEntryRepository = accountEntryRepository;
    }

    public CreateCustomerCommand createAddCustomerCommand(Customer customer, Account account) {
        CreateCustomerCommand command = new CreateCustomerCommand(customerRepository, accountRepository, customer, account);
        command.attachObserver(ruleManager.getCustomerRuleManager());
        return command;
    }

    public RemoveCustomerCommand createRemoveCustomerCommand(String name) {
        RemoveCustomerCommand command = new RemoveCustomerCommand(customerRepository, null, name);
        command.attachObserver(ruleManager.getCustomerRuleManager());
        return command;
    }

    public CreateAccountCommand createAddAccountCommand(String name, Account account) {
        CreateAccountCommand command = new CreateAccountCommand(customerRepository, accountRepository, account, name);
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
