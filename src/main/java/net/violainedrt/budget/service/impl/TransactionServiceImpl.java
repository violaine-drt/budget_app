package net.violainedrt.budget.service.impl;

import lombok.AllArgsConstructor;
import net.violainedrt.budget.dto.TransactionDto;
import net.violainedrt.budget.entity.Category;
import net.violainedrt.budget.entity.Transaction;
import net.violainedrt.budget.mapper.CategoryMapper;
import net.violainedrt.budget.mapper.TransactionMapper;
import net.violainedrt.budget.repository.TransactionRepository;
import net.violainedrt.budget.service.TransactionService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private TransactionRepository transactionRepository;
    @Override
    public TransactionDto createTransaction(TransactionDto transactionDto) {
        Transaction transaction = TransactionMapper.mapToTransaction(transactionDto);
        Transaction savedTransaction = transactionRepository.save(transaction);
        return TransactionMapper.mapToTransactionDto(savedTransaction);
    }
}
