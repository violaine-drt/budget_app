package net.violainedrt.budget.entity;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

public class Categorie {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private Categorie parent; //définit relation parent-enfant au sein de la table

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;


    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
}
