package net.violainedrt.budget.infrastructure.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.violainedrt.budget.common.enums.FinancialType;
import net.violainedrt.budget.common.enums.Periodicity;
import org.hibernate.annotations.*;


import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "goals")
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "maxAmount is mandatory on goal entity")
    @Digits(integer = 15, fraction = 2, message = "maxAmount takes up to 15 digits and up to 2 decimal places")
    @Column(name = "maximum_amount", nullable = false, precision = 15, scale = 2)
    private BigDecimal maxAmount;

    @NotNull(message = "periodicity is mandatory on goal entity")
    @Enumerated(EnumType.STRING)
    @Column(name = "periodicity", nullable = false)
    private Periodicity periodicity;

    @NotNull(message = "financialType is mandatory on goal entity")
    @Enumerated(EnumType.STRING)
    @Column(name = "financial_type", nullable = false)
    private FinancialType financialType;

    @NotNull(message = "category is mandatory on goal entity")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private net.violainedrt.budget.infrastructure.entity.Category category;

    @NotNull(message = "user is mandatory on goal entity")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    //On garde nullable la sous-catégorie, un goal pouvant être appliqué à une catégorie entière
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subcategory_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Subcategory subcategory;

    @CreationTimestamp  // Automatiquement généré lors de l'insertion
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
