package com.yosra.bibliophiles.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

@Getter
@Setter
public class Vote extends Auditable {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private short direction;

    @NonNull
    @ManyToOne
    private Link link;

    @NonNull
    @ManyToOne
    private Book book;

    public Vote() {
    }

    public Vote(@NonNull short direction, @NonNull Link link) {
        this.direction = direction;
        this.link = link;
    }

    public Vote(@NonNull short direction, @NonNull Book book) {
        this.direction = direction;
        this.book = book;
    }
}
