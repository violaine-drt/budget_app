package net.violainedrt.budget.infrastructure.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @NotNull(message = "email is mandatory on user entity")
    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;

    @NotNull(message = "password is mandatory on user entity")
    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @NotNull(message = "balance is mandatory on user entity")
    @Column(name = "balance", nullable = false)
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
