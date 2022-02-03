package framework.account;

import framework.customer.Customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public abstract class Account implements IAccount {

    protected Customer customer;
    protected final String accountNo;
    protected double balance;
    protected final Collection<AccountEntry> entries = new ArrayList<>();

    public Account() {
        this.accountNo = UUID.randomUUID().toString().substring(0, 8);
        this.customer.addAccount(this);
    }

    public Account(Customer customer) {
        this.customer = customer;
        this.accountNo = UUID.randomUUID().toString().substring(0, 8);
        setCustomer(customer);
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        this.customer.addAccount(this);
    }

    public Collection<AccountEntry> getEntries() {
        return entries;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void addEntry(AccountEntry entry) {
        entries.add(entry);
    }

    public abstract double addInterest();
}
