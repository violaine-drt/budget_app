package net.violainedrt.budget.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.violainedrt.budget.common.enums.FinancialType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


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

    @Column(name = "description")
    private String description;

    @Column(name = "counterparty")
    private String counterparty;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "date", nullable = false)
    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "financial_type", nullable = false)
    private FinancialType financialType;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private net.violainedrt.budget.infrastructure.entity.Category category;

    @ManyToOne
    @JoinColumn(name = "subcategory", referencedColumnName = "id")
    private net.violainedrt.budget.infrastructure.entity.Subcategory subcategory;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "supplier", referencedColumnName = "id")
    private net.violainedrt.budget.infrastructure.entity.Supplier supplier;

    @CreationTimestamp  // Automatiquement généré lors de l'insertion
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;


}
