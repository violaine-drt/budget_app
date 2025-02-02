package net.violainedrt.budget.service.impl;

import lombok.AllArgsConstructor;
import net.violainedrt.budget.dto.TransactionDto;
import net.violainedrt.budget.entity.Transaction;
import net.violainedrt.budget.exception.ResourceNotFoundException;
import net.violainedrt.budget.mapper.TransactionMapper;
import net.violainedrt.budget.repository.TransactionRepository;
import net.violainedrt.budget.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public TransactionDto getTransactionById(Long transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction does not exist with given ID : " + transactionId));
        return TransactionMapper.mapToTransactionDto(transaction);
    }

    @Override
    public List<TransactionDto> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactions.stream().map((transaction) -> TransactionMapper.mapToTransactionDto(transaction))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTransaction(Long transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId).orElseThrow(
                () -> new ResourceNotFoundException("Transaction does not exist with given id: " + transactionId)
        );
        transactionRepository.deleteById(transactionId);
    }
}
