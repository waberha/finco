package framework.command.impl;

import framework.account.Account;
import framework.command.AccountCommand;
import framework.customer.Customer;
import framework.repo.AccountRepository;
import framework.repo.CustomerRepository;

public class CreateAccountCommand extends AccountCommand {

    private final CustomerRepository customerRepository;
    private final String name;

    // Package protecting constructor
    CreateAccountCommand(CustomerRepository customerRepository, AccountRepository accountRepository, Account account, String name) {
        super(accountRepository, account);
        this.customerRepository = customerRepository;
        this.name = name;
    }

    @Override
    public void execute() {

        Customer customer = customerRepository.findById(name)
                .orElseThrow(() -> new RuntimeException("Unknown customer"));

        account.setCustomer(customer);
        accountRepository.save(account);
        notify(account);
    }

    public Account getAccount() {
        return account;
    }
}
