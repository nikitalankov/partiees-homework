package lk.tech.nikita15.service;

import lk.tech.nikita15.dto.NewPartieRequest;
import lk.tech.nikita15.dto.PartieDTO;
import lk.tech.nikita15.repository.PartiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AdminService {
    @Autowired
    private PartiesRepository repository;

    public void deletePartie(Integer id) {
        //List<PartieDTO> parties = repository.load();
        //parties.removeIf(partieDTO -> partieDTO.getId().equals(id));
        List<PartieDTO> filtredList = repository.load().stream()
                .filter(p -> !p.getId().equals(id))
                .toList();
        repository.save(filtredList);
    }

    public void addPartie(NewPartieRequest request) {
        List<PartieDTO> parties = repository.load();
        Integer lastId;
        if (parties.isEmpty()) {
            lastId = 0;
        } else {
            lastId = parties.getLast().getId();
            lastId++;
        }
        PartieDTO partieDTO = new PartieDTO(lastId, request.getPartieName(), 0);
        parties.add(partieDTO);
        repository.save(parties);
    }
    public void renamePartie(Integer id, String newName) {
//        repository.load().stream()
//                .filter(p -> Objects.equals(id, p.getId()))
//                .findFirst()
//                .ifPresent(p -> p.setName(newName));
        List<PartieDTO> parties = repository.load();
        for (PartieDTO partieDTO : parties) {
            if (partieDTO.getId().equals(id)) {
                partieDTO.setName(newName);
                repository.save(parties);
                break;
            }
        }
    }
}

