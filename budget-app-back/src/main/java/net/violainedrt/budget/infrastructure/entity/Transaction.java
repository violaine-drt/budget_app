package net.violainedrt.budget.infrastructure.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.violainedrt.budget.common.enums.FinancialType;
import org.hibernate.annotations.*;


import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //nullable
    @Column(name = "description", length = 255)
    private String description;

    @NotNull(message = "amount is mandatory on transaction entity")
    @Column(name = "amount", nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;

    @NotNull(message = "date is mandatory on transaction entity")
    @Column(name = "date", nullable = false)
    private LocalDateTime dateTime;

    @NotNull(message = "financialType is mandatory on transaction entity")
    @Enumerated(EnumType.STRING)
    @Column(name = "financial_type", nullable = false)
    private FinancialType financialType;

    //Prévoir une category divers
    @NotNull(message = "category is mandatory on transaction entity")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false) // Si pas de catégorie, ce sera la catég divers : à gérer dans le service
    private net.violainedrt.budget.infrastructure.entity.Category category;

    //nullable
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subcategory", referencedColumnName = "id")
    private net.violainedrt.budget.infrastructure.entity.Subcategory subcategory;

    @NotNull(message = "user is mandatory on transaction entity")
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;


    //Prévoir un supplier divers
    @NotNull(message = "supplier is mandatory on transaction entity")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier", referencedColumnName = "id", nullable = false) // Si pas de supplier, ce sera le supplier divers : à gérer dans le service
    private net.violainedrt.budget.infrastructure.entity.Supplier supplier;

    @CreationTimestamp  // Automatiquement généré lors de l'insertion
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;


}
