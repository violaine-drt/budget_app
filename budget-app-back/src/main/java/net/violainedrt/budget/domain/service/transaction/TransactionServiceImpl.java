package net.violainedrt.budget.domain.service.transaction;

import lombok.RequiredArgsConstructor;
import net.violainedrt.budget.application.dto.TransactionDto;
import net.violainedrt.budget.domain.mapper.TransactionMapper;
import net.violainedrt.budget.infrastructure.entity.Transaction;
import net.violainedrt.budget.common.exception.ResourceNotFoundException;
import net.violainedrt.budget.infrastructure.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final SupplierRepository supplierRepository;
    private final CategoryRepository categoryRepository;
    private final SubcategoryRepository subcategoryRepository;
    private final TransactionMapper transactionMapper;

    @Override
    public TransactionDto createTransaction(TransactionDto transactionDto) {
        Transaction transaction = transactionMapper.toTransactionEntity(transactionDto, userRepository, categoryRepository, subcategoryRepository, supplierRepository);
        Transaction savedTransaction = transactionRepository.save(transaction);
        return transactionMapper.toTransactionDto(savedTransaction);
    }

    @Override
    public TransactionDto getTransactionById(Long transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction does not exist with given ID : " + transactionId));
        return transactionMapper.toTransactionDto(transaction);
    }

    @Override
    public List<TransactionDto> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactions.stream().map(transaction -> transactionMapper.toTransactionDto(transaction))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTransaction(Long transactionId) {
    transactionRepository.findById(transactionId).orElseThrow(
                () -> new ResourceNotFoundException("Transaction does not exist with given id: " + transactionId)
        );
        transactionRepository.deleteById(transactionId);
    }
}
