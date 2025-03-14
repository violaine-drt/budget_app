package net.violainedrt.budget.infrastructure.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories", uniqueConstraints = { @UniqueConstraint(columnNames = {"name", "user_id"})})
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "name is mandatory on category entity")
    @Column(name = "name", nullable = false, unique = true, length = 150)
    private String name;

    @NotNull(message = "colorCode is mandatory on category entity")
    @Column(name = "color_code", nullable = false, length = 7)
    private String colorCode;

    @NotNull(message = "isFlagged is mandatory on category entity")
    @Column(name = "is_flagged", nullable = false)
    private Boolean isFlagged;

    @NotNull(message = "isDefault is mandatory on category entity")
    @Column(name = "is_default", nullable = false)
    private Boolean isDefault;

    @NotNull(message = "user is mandatory on category entity")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @CreationTimestamp  // Automatiquement généré lors de l'insertion
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
