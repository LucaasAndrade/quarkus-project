package org.acme.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.OneToMany;

@Entity
@Data
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue
    @OneToMany
    private Long id;

    private String name;

}
