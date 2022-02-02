package framework.rule;

import framework.account.Account;
import framework.account.AccountEntry;
import framework.observer.Observer;
import framework.party.Party;

import java.util.ArrayList;
import java.util.Collection;

public class RuleManager {

    private final Collection<Rule<Party>> partyRules = new ArrayList<>();
    private final Collection<Rule<Account>> accountRules = new ArrayList<>();
    private final Collection<Rule<AccountEntry>> accountEntryRules = new ArrayList<>();

    public void addPartyRules(Collection<Rule<Party>> rules) {
        partyRules.addAll(rules);
    }

    public void addAccountRules(Collection<Rule<Account>> rules) {
        accountRules.addAll(rules);
    }

    public void addAccountEntryRules(Collection<Rule<AccountEntry>> rules) {
        accountEntryRules.addAll(rules);
    }

    public PartyRuleManager getPartyRuleManager() {
        // Lazy loading rule manager
        if (partyRuleManager == null) partyRuleManager = new PartyRuleManager();
        return partyRuleManager;
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

    public class PartyRuleManager implements Observer<Party> {

        // package-protected constructor
        PartyRuleManager(){
        }

        @Override
        public void update(Party party) {
            for (Rule<Party> rule : partyRules) {
                if (rule.isApplicable(party)) rule.apply(party);
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

    private PartyRuleManager partyRuleManager;
    private AccountRuleManager accountRuleManager;
    private AccountEntryRuleManager accountEntryRuleManager;
}
