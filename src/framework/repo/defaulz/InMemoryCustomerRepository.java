package framework.repo.defaulz;

import framework.customer.Customer;
import framework.repo.CustomerRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class InMemoryCustomerRepository implements CustomerRepository {

    private final Collection<Customer> parties = new ArrayList<>();

    @Override
    public void save(Customer customer) {
        Optional<Customer> oldCustomer = findById(customer.getName());
        if (oldCustomer.isPresent()) update(oldCustomer.get(), customer);
        else parties.add(customer);
    }

    @Override
    public void delete(Customer customer) {
        parties.remove(customer);
    }

    @Override
    public Optional<Customer> findById(String s) {
        return parties.stream()
                .filter(p -> p.getName().equals(s))
                .findAny();
    }

    @Override
    public Collection<Customer> findAll() {
        return parties;
    }

    private void update(Customer oldCustomer, Customer newCustomer) {
        oldCustomer.setCity(newCustomer.getCity());
        oldCustomer.setState(newCustomer.getState());
        oldCustomer.setStreet(newCustomer.getStreet());
        oldCustomer.setZip(newCustomer.getZip());
        oldCustomer.setEmail(newCustomer.getEmail());
    }
}
