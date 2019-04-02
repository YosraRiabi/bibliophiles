package com.yosra.bibliophiles.Repository;

import com.yosra.bibliophiles.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
