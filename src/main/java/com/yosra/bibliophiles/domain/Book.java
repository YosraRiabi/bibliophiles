package com.yosra.bibliophiles.domain;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Book extends Auditable{
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String category;
    private String author;
    private String place;

    // comments
    @OneToMany(mappedBy = "book")
    private List<Comment> comments = new ArrayList<>();
}
