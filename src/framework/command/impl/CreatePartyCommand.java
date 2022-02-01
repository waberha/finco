package framework.command.impl;

import framework.account.Account;
import framework.command.PartyCommand;
import framework.party.Party;
import framework.repo.AccountRepository;
import framework.repo.PartyRepository;

public class CreatePartyCommand extends PartyCommand {

    private final AccountRepository accountRepository;
    private final Account account;

    // Package protecting constructor
    CreatePartyCommand(PartyRepository partyRepository, AccountRepository accountRepository, Party party, Account account) {
        super(partyRepository, party);
        this.accountRepository = accountRepository;
        this.account = account;
    }

    @Override
    public void execute() {
        account.setOwner(party);
        partyRepository.save(party);
        accountRepository.save(account);
    }

    public Account getAccount() {
        return account;
    }
}
