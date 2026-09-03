package com.zeinab.banking.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {

    private String id;
    private TransactionType type;
    private BigDecimal amount;
    private LocalDateTime createdAt;

    public Transaction(
            String id,
            TransactionType type,
            BigDecimal amount
    ) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.createdAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public TransactionType getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}