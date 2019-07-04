package com.yosra.bibliophiles.service;

import com.yosra.bibliophiles.Repository.VoteRepository;
import com.yosra.bibliophiles.domain.Vote;
import org.springframework.stereotype.Service;

@Service
public class VoteService {

    private final VoteRepository voteRepository;

    public VoteService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public Vote save(Vote vote) {
        return voteRepository.save(vote);
    }
}
