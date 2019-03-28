package com.yosra.bibliophiles.Repository;

import com.yosra.bibliophiles.domain.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface bookRepository extends JpaRepository<Link, Long> {
}
