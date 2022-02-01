package framework.command.impl;

import framework.command.PartyCommand;
import framework.party.Party;
import framework.repo.PartyRepository;

public class RemovePartyCommand extends PartyCommand {

    private final String name;

    // Package protecting constructor
    RemovePartyCommand(PartyRepository partyRepository, Party party, String name) {
        super(partyRepository, party);
        this.name = name;
    }

    @Override
    public void execute() {
        partyRepository.findById(name)
                .ifPresent(partyRepository::delete);
    }
}
