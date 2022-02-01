package framework.command.impl;

import framework.account.Account;
import framework.command.AccountCommand;
import framework.party.Party;
import framework.repo.AccountRepository;
import framework.repo.PartyRepository;

import java.util.Optional;

public class CreateAccountCommand extends AccountCommand {

    private final PartyRepository partyRepository;
    private final String name;

    // Package protecting constructor
    CreateAccountCommand(PartyRepository partyRepository, AccountRepository accountRepository, Account account, String name) {
        super(accountRepository, account);
        this.partyRepository = partyRepository;
        this.name = name;
    }

    @Override
    public void execute() {

        Party party = partyRepository.findById(name)
                .orElseThrow(() -> new RuntimeException("Unknown party"));

        account.setOwner(party);
        accountRepository.save(account);
    }

    public Account getAccount() {
        return account;
    }
}
