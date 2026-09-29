package lk.tech.nikita15.service;

import lk.tech.nikita15.dto.MyVoteRequest;
import lk.tech.nikita15.dto.PartieDTO;
import lk.tech.nikita15.exception.BrokeVoteException;
import lk.tech.nikita15.exception.PrisonAppleException;
import lk.tech.nikita15.repository.PartiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartiesService {

    @Autowired
    private PartiesRepository repository;

    public void addVote(MyVoteRequest request) {
        List<PartieDTO> parties = repository.load();
        for (PartieDTO partieDTO : parties) {
            if (partieDTO.getId().equals(request.getId())) {
                Integer currentVoteValue = partieDTO.getVoteCount();
                currentVoteValue++;
                partieDTO.setVoteCount(currentVoteValue);
                repository.save(parties);
                return;
            }
        }

    }

    public List<PartieDTO> readParties() {
        return repository.load();
    }

}
