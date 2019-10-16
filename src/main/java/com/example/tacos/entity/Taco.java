package com.example.tacos.entity;
import lombok.Data;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
public class Taco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @ManyToMany(targetEntity=Ingredient.class)
    @Size(min=1, message="You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;
    private Date createdAt;
    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }
}
