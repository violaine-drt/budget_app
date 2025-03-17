package net.violainedrt.budget.infrastructure.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "name is mandatory on user entity")
    @Size(min = 1, max = 150, message = "Name must be between 1 and 150 characters")
    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @NotNull(message = "email is mandatory on user entity")
    @Size(min = 1, max = 255, message = "Email must be between 3 and 250 characters")
    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;

    @NotNull(message = "password is mandatory on user entity")
    @Size(min = 1, max = 255, message = "Password must be between 1 and 255 characters")
    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @NotNull(message = "balance is mandatory on user entity")
    @Digits(integer = 15, fraction = 2, message = "balance takes up to 15 digits and up to 2 decimal places")
    @Column(name = "balance", nullable = false, precision = 15, scale = 2)
    private BigDecimal userBalance;

    @NotNull(message = "lastLogin is mandatory on user entity")
    @Column(name = "last_login", nullable = false)
    private LocalDateTime lastLogin;

    @CreationTimestamp  // Automatiquement généré lors de l'insertion
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
