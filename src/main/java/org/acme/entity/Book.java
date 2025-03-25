package org.acme.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private int numberOfPages;

    @ManyToOne
    private long authorId;

    @ManyToMany
    private long categoryId;
}
