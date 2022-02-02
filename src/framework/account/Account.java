package framework.account;

import framework.party.Party;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public abstract class Account implements IAccount {

    protected  Party owner;
    protected final String accountNo;
    protected double balance;
    protected final Collection<AccountEntry> entries = new ArrayList<>();

    public Account(Party owner) {
        this.owner = owner;
        this.accountNo = UUID.randomUUID().toString().substring(0, 8);
        this.owner.addAccount(this);
    }

    public Collection<AccountEntry> getEntries() {
        return entries;
    }

    public Party getOwner() {
        return owner;
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
}
