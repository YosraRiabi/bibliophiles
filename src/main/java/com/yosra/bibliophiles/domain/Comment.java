package com.yosra.bibliophiles.domain;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.yosra.bibliophiles.domain.Book;


@Entity
@Data
@NoArgsConstructor
public class Comment extends Auditable {
    @Id
    @GeneratedValue
    private Long id;
    private String body;

    //link
    @ManyToOne
    private Link link;

    //book
    @ManyToOne
    private Book book;
}
