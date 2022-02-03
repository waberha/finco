package framework.command.impl;

import framework.command.CustomerCommand;
import framework.customer.Customer;
import framework.repo.CustomerRepository;

public class RemoveCustomerCommand extends CustomerCommand {

    private final String name;

    // Package protecting constructor
    RemoveCustomerCommand(CustomerRepository customerRepository, Customer customer, String name) {
        super(customerRepository, customer);
        this.name = name;
    }

    @Override
    public void execute() {
        customerRepository.findById(name).ifPresent(customerRepository::delete);
        notify(customer);
    }
}
