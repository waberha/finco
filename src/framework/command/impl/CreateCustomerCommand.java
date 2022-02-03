package framework.command.impl;

import framework.account.Account;
import framework.command.CustomerCommand;
import framework.customer.Customer;
import framework.repo.AccountRepository;
import framework.repo.CustomerRepository;

public class CreateCustomerCommand extends CustomerCommand {

    private final AccountRepository accountRepository;
    private final Account account;

    // Package protecting constructor
    CreateCustomerCommand(CustomerRepository customerRepository, AccountRepository accountRepository, Customer customer, Account account) {
        super(customerRepository, customer);
        this.accountRepository = accountRepository;
        this.account = account;
    }

    @Override
    public void execute() {
        account.setCustomer(customer);
        customerRepository.save(customer);
        accountRepository.save(account);
        notify(customer);
    }

    public Account getAccount() {
        return account;
    }
}
