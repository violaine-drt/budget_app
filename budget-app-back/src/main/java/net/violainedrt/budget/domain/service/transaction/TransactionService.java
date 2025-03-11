package net.violainedrt.budget.domain.service.transaction;
import net.violainedrt.budget.application.dto.TransactionDto;

import java.util.List;

public interface TransactionService {
    TransactionDto createTransaction (TransactionDto transactionDto);
    TransactionDto getTransactionById(Long transactionId);
    List<TransactionDto> getAllTransactions();
    void deleteTransaction(Long transactionId);
}
