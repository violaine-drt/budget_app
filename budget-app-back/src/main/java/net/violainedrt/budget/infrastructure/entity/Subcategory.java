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
@Table(name = "subcategories", uniqueConstraints = { @UniqueConstraint(columnNames = {"name", "category_id"})})
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "name is mandatory on subcategory entity")
    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @NotNull(message = "colorCode is mandatory on subcategory entity")
    @Column(name = "color_code", nullable = false, length = 7)
    private String colorCode;

    @NotNull(message = "isFlagged is mandatory on subcategory entity")
    @Column(name = "is_flagged", nullable = false)
    private Boolean isFlagged;

    @NotNull(message = "category is mandatory on subcategory entity")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Category category;

    @CreationTimestamp  // Automatiquement généré lors de l'insertion
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
