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
@NoArgsConstructor
@Data
public class Link extends Auditable{

    @Id
    @GeneratedValue
    Long id;
    String title;
    String category;
    String author;
    String url;

    //comments
    @OneToMany(mappedBy = "link")
    private List<Comment> comments = new ArrayList<>();




}
