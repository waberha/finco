package framework.command;

import framework.party.Party;
import framework.repo.PartyRepository;

public abstract class PartyCommand extends Command<Party> {

    protected final PartyRepository partyRepository;
    protected final Party party;

    public PartyCommand(PartyRepository partyRepository, Party party) {
        this.partyRepository = partyRepository;
        this.party = party;
    }
}
