package framework.command;

import framework.customer.Customer;
import framework.repo.CustomerRepository;

public abstract class CustomerCommand extends Command<Customer> {

    protected final CustomerRepository customerRepository;
    protected final Customer customer;

    public CustomerCommand(CustomerRepository customerRepository, Customer customer) {
        this.customerRepository = customerRepository;
        this.customer = customer;
    }
}
