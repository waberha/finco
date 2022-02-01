package framework.repo.defaulz;

import framework.party.Party;
import framework.repo.PartyRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class InMemoryPartyRepository implements PartyRepository {

    private final Collection<Party> parties = new ArrayList<>();

    @Override
    public void save(Party party) {
        Optional<Party> oldParty = findById(party.getName());
        if (oldParty.isPresent()) update(oldParty.get(), party);
        else parties.add(party);
    }

    @Override
    public void delete(Party party) {
        parties.remove(party);
    }

    @Override
    public Optional<Party> findById(String s) {
        return parties.stream()
                .filter(p -> p.getName().equals(s))
                .findAny();
    }

    @Override
    public Collection<Party> findAll() {
        return parties;
    }

    private void update(Party oldParty, Party newParty) {
        oldParty.setCity(newParty.getCity());
        oldParty.setState(newParty.getState());
        oldParty.setStreet(newParty.getStreet());
        oldParty.setZip(newParty.getZip());
        oldParty.setEmail(newParty.getEmail());
    }
}
