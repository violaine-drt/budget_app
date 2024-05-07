package net.violainedrt.budget.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    private String supplier;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    @JoinColumn(name= "category_id", referencedColumnName = "id", nullable = false)
    private Category category; //définit clé étrangère vers Category

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "type_id", referencedColumnName = "id", nullable = false)
    private Type type;

    @ManyToOne
    @JoinColumn(name= "user_id", referencedColumnName = "id", nullable = false)
    private User user;

}
