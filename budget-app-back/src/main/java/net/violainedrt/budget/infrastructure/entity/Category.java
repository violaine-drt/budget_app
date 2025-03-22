package net.violainedrt.budget.infrastructure.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
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
    @Size(min = 1, max = 150, message = "Name must be between 1 and 150 characters")
    @Column(name = "name", nullable = false, unique = true, length = 150)
    private String name;

    @NotNull(message = "colorCode is mandatory on category entity")
    @Pattern(regexp = "^#[0-9A-Fa-f]{6}$", message = "Color code mus be valid hexadecimal (ex: #FFFFFF)")
    @Column(name = "color_code", nullable = false, length = 9)
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
