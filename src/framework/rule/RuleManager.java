package framework.rule;

import framework.account.Account;
import framework.account.AccountEntry;
import framework.observer.Observer;
import framework.customer.Customer;

import java.util.ArrayList;
import java.util.Collection;

public class RuleManager {

    private final Collection<Rule<Customer>> customerRules = new ArrayList<>();
    private final Collection<Rule<Account>> accountRules = new ArrayList<>();
    private final Collection<Rule<AccountEntry>> accountEntryRules = new ArrayList<>();

    public void addCustomerRules(Collection<Rule<Customer>> rules) {
        customerRules.addAll(rules);
    }

    public void addAccountRules(Collection<Rule<Account>> rules) {
        accountRules.addAll(rules);
    }

    public void addAccountEntryRules(Collection<Rule<AccountEntry>> rules) {
        accountEntryRules.addAll(rules);
    }

    public CustomerRuleManager getCustomerRuleManager() {
        // Lazy loading rule manager
        if (customerRuleManager == null) customerRuleManager = new CustomerRuleManager();
        return customerRuleManager;
    }

    public AccountRuleManager getAccountRuleManager() {
        // Lazy loading rule manager
        if (accountRuleManager == null) accountRuleManager = new AccountRuleManager();
        return accountRuleManager;
    }

    public AccountEntryRuleManager getAccountEntryRuleManager() {
        // Lazy loading rule manager
        if (accountEntryRuleManager == null) accountEntryRuleManager = new AccountEntryRuleManager();
        return accountEntryRuleManager;
    }

    public class CustomerRuleManager implements Observer<Customer> {

        // package-protected constructor
        CustomerRuleManager(){
        }

        @Override
        public void update(Customer customer) {
            for (Rule<Customer> rule : customerRules) {
                if (rule.isApplicable(customer)) rule.apply(customer);
            }
        }
    }

    public class AccountRuleManager implements Observer<Account> {

        // package-protected constructor
        AccountRuleManager() {
        }

        @Override
        public void update(Account account) {
            for (Rule<Account> rule : accountRules) {
                if (rule.isApplicable(account)) rule.apply(account);
            }
        }
    }

    public class AccountEntryRuleManager implements Observer<AccountEntry> {

        // package-protected constructor
        AccountEntryRuleManager() {
        }

        @Override
        public void update(AccountEntry entry) {
            for (Rule<AccountEntry> rule : accountEntryRules) {
                if (rule.isApplicable(entry)) rule.apply(entry);
            }
        }
    }

    private CustomerRuleManager customerRuleManager;
    private AccountRuleManager accountRuleManager;
    private AccountEntryRuleManager accountEntryRuleManager;
}
