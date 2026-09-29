package lk.tech.nikita15.controller;

import lk.tech.nikita15.dto.MyVoteRequest;
import lk.tech.nikita15.dto.PartieDTO;
import lk.tech.nikita15.service.PartiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PartiesController {

    @Autowired
    private PartiesService partiesService;

    @PostMapping("/vote")
    public void addVote(@RequestBody MyVoteRequest request) {
        partiesService.addVote(request);
    }

    @GetMapping("/vote")
    public List<PartieDTO> readParties() {
        return partiesService.readParties();
    }
}
