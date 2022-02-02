package framework;

import framework.account.Account;
import framework.account.AccountEntry;
import framework.command.CommandManager;
import framework.command.impl.CommandFactory;
import framework.party.Party;
import framework.repo.AbstractRepositoryFactory;
import framework.repo.AccountEntryRepository;
import framework.repo.AccountRepository;
import framework.repo.PartyRepository;
import framework.repo.defaulz.InMemoryRepositoryFactory;
import framework.rule.Rule;
import framework.rule.RuleManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class FinCo {

    private final Controller controller;

    public FinCo(FinCoBuilder builder) {

        AbstractRepositoryFactory repositoryFactory = Optional
                .ofNullable(builder.repositoryFactory)
                .orElse(new InMemoryRepositoryFactory()); // default repo

        PartyRepository partyRepository = repositoryFactory.createPartyRepository();
        AccountRepository accountRepository = repositoryFactory.createAccountRepository();
        AccountEntryRepository accountEntryRepository = repositoryFactory.createAccountEntryRepository();

        CommandManager commandManager = new CommandManager();

        RuleManager ruleManager = new RuleManager();
        ruleManager.addPartyRules(builder.partyRules);
        ruleManager.addAccountRules(builder.accountRules);
        ruleManager.addAccountEntryRules(builder.accountEntryRules);

        controller = new Controller(commandManager, new CommandFactory(ruleManager, partyRepository, accountRepository, accountEntryRepository));
    }

    public Controller run() {
        return controller;
    }

    public static class FinCoBuilder {

        private AbstractRepositoryFactory repositoryFactory;
        private final Collection<Rule<Party>> partyRules = new ArrayList<>();
        private final Collection<Rule<Account>> accountRules = new ArrayList<>();
        private final Collection<Rule<AccountEntry>> accountEntryRules = new ArrayList<>();

        public FinCoBuilder partyRule(Rule<Party> rule) {
            partyRules.add(rule);
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
