package net.violainedrt.budget.service;

import net.violainedrt.budget.dto.TransactionDto;

public interface TransactionService {
    TransactionDto createTransaction (TransactionDto transactionDto);
}
