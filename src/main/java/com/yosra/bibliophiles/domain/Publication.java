package com.yosra.bibliophiles.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
public class Publication {

    @Id
    @GeneratedValue
    Long id;
    String text;



}
