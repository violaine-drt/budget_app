package net.violainedrt.budget.domain.service.transaction;

import lombok.RequiredArgsConstructor;
import net.violainedrt.budget.application.dto.transaction.*;
import net.violainedrt.budget.domain.mapper.TransactionMapper;
import net.violainedrt.budget.domain.service.user.UserServiceImpl;
import net.violainedrt.budget.infrastructure.entity.Transaction;
import net.violainedrt.budget.common.exception.ResourceNotFoundException;
import net.violainedrt.budget.infrastructure.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final SupplierRepository supplierRepository;
    private final CategoryRepository categoryRepository;
    private final SubcategoryRepository subcategoryRepository;
    private final TransactionMapper transactionMapper;

    //@todo : ajouter un système de logs
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private Transaction findTransactionById(Long transactionId) {
        return transactionRepository.findById(transactionId)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction does not exist with given ID: " + transactionId));
    }

    @Override
    @Transactional
    public QueryTransactionDto createTransaction(CreateTransactionDto transaction) {
        Transaction newTransactionEntity = transactionMapper.toTransactionEntity(transaction, userRepository, categoryRepository, subcategoryRepository, supplierRepository);
        Transaction savedTransaction = transactionRepository.save(newTransactionEntity);
        return transactionMapper.toTransactionDto(savedTransaction);
    }

    @Override
    public QueryTransactionDto getTransactionById(Long transactionId) {
        Transaction transaction = findTransactionById(transactionId);
        return transactionMapper.toTransactionDto(transaction);
    }

    @Override
    public List<QueryTransactionDto> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactions.stream().map(transactionMapper::toTransactionDto)
                .toList();
    }


    @Override
    @Transactional
    public QueryTransactionDto updateTransaction(Long transactionId, UpdateTransactionDto transaction) {
        Transaction toUpdateTransaction = findTransactionById(transactionId);
        transactionMapper.updateTransactionFromDto(transaction, toUpdateTransaction);
        Transaction updatedTransaction = transactionRepository.save(toUpdateTransaction);
        return transactionMapper.toTransactionDto(updatedTransaction);
    }

    @Override
    @Transactional
    public void deleteTransaction(Long transactionId) {
    findTransactionById(transactionId);
        transactionRepository.deleteById(transactionId);
    }
}
