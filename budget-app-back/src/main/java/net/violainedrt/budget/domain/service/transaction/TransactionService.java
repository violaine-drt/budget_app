package net.violainedrt.budget.domain.service.transaction;
import net.violainedrt.budget.application.dto.transaction.*;

import java.util.List;

public interface TransactionService {
    QueryTransactionDto createTransaction (CreateTransactionDto transaction);
    QueryTransactionDto getTransactionById(Long transactionId);
    List<QueryTransactionDto> getAllTransactions();
    QueryTransactionDto updateTransaction (Long transactionId, UpdateTransactionDto transaction);
    void deleteTransaction(Long transactionId);
}
