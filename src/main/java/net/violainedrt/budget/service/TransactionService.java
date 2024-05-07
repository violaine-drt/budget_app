package net.violainedrt.budget.service;
import net.violainedrt.budget.dto.TransactionDto;

import java.util.List;

public interface TransactionService {
    TransactionDto createTransaction (TransactionDto transactionDto);
    TransactionDto getTransactionById(Long transactionId);
    List<TransactionDto> getAllTransactions();
    void deleteTransaction(Long transactionId);
}
