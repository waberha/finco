package framework;

import framework.account.Account;
import framework.account.AccountEntry;
import framework.command.CommandManager;
import framework.command.impl.CommandFactory;
import framework.customer.Customer;
import framework.repo.AbstractRepositoryFactory;
import framework.repo.AccountEntryRepository;
import framework.repo.AccountRepository;
import framework.repo.CustomerRepository;
import framework.repo.defaulz.InMemoryRepositoryFactory;
import framework.rule.Rule;
import framework.rule.RuleManager;
import framework.ui.UIRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class FinCo {

    private final Controller controller;

    private FinCo(FinCoBuilder builder) {

        AbstractRepositoryFactory repositoryFactory = Optional
                .ofNullable(builder.repositoryFactory)
                .orElse(new InMemoryRepositoryFactory()); // default repo

        CustomerRepository customerRepository = repositoryFactory.createCustomerRepository();
        AccountRepository accountRepository = repositoryFactory.createAccountRepository();
        AccountEntryRepository accountEntryRepository = repositoryFactory.createAccountEntryRepository();

        CommandManager commandManager = new CommandManager();

        RuleManager ruleManager = new RuleManager();
        ruleManager.addCustomerRules(builder.customerRules);
        ruleManager.addAccountRules(builder.accountRules);
        ruleManager.addAccountEntryRules(builder.accountEntryRules);

        controller = new Controller(commandManager, new CommandFactory(ruleManager, customerRepository, accountRepository, accountEntryRepository));
    }

    public Controller run() {
        return controller;
    }

    // Default entry point
    public static void main(String[] args) {

        UIRunner uiRunner = new UIRunner.UIRunnerBuilder().build();
        uiRunner.run(new FinCo.FinCoBuilder().build());
    }

    public static class FinCoBuilder {

        private AbstractRepositoryFactory repositoryFactory;
        private final Collection<Rule<Customer>> customerRules = new ArrayList<>();
        private final Collection<Rule<Account>> accountRules = new ArrayList<>();
        private final Collection<Rule<AccountEntry>> accountEntryRules = new ArrayList<>();

        public FinCoBuilder customerRule(Rule<Customer> rule) {
            customerRules.add(rule);
            return this;
        }

        public FinCoBuilder accountRule(Rule<Account> rule) {
            accountRules.add(rule);
            return this;
        }

        public FinCoBuilder accountEntryRule(Rule<AccountEntry> rule) {
            accountEntryRules.add(rule);
            return this;
        }

        public FinCoBuilder repositoryFactory(AbstractRepositoryFactory repositoryFactory) {
            this.repositoryFactory = repositoryFactory;
            return this;
        }

        public FinCo build() {
            return new FinCo(this);
        }
    }
}
