package com.yosra.bibliophiles.Repository;

import com.yosra.bibliophiles.domain.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface publicationRepository extends JpaRepository<Publication, Long> {
}
