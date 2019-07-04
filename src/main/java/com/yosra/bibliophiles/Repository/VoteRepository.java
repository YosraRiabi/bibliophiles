package com.yosra.bibliophiles.Repository;

import com.yosra.bibliophiles.domain.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote,Long> {
}
