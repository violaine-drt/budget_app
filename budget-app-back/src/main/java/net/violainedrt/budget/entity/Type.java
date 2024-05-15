package net.violainedrt.budget.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter //lombok annotation, automatically generates getter methods
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity // specifies a class is a JPA entity
@Table(name = "types")
public class Type {
    @Id //JPA annotation specifying Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //JPA annotation, indicates PK is generated automatically. Strategy : PK generation will be done with identity from Postgre
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;

}
