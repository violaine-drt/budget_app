package net.violainedrt.budget.application.controller;


import lombok.AllArgsConstructor;
import net.violainedrt.budget.application.dto.transaction.*;
import net.violainedrt.budget.domain.service.transaction.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private TransactionService transactionService;
    // Build Add Transaction REST API
    @PostMapping
    public ResponseEntity<QueryTransactionDto> createTransaction(@RequestBody CreateTransactionDto transaction){
        QueryTransactionDto savedTransaction = transactionService.createTransaction(transaction);
        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
    }

    //Build Get Transaction REST API
    @GetMapping("{id}")
    public ResponseEntity<QueryTransactionDto> getTransactionById(@PathVariable("id") Long transactionId){
        QueryTransactionDto transaction = transactionService.getTransactionById(transactionId);
        return ResponseEntity.ok(transaction);
    }

    //Build Get All transactions REST API
    @GetMapping
    public ResponseEntity<List<QueryTransactionDto>> getAllTransactions(){
        List<QueryTransactionDto> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

    //Build update Transaction REST API
    @PutMapping("{id}")
    public ResponseEntity<QueryTransactionDto> updateTransaction(@PathVariable("id") Long transactionId, @RequestBody UpdateTransactionDto transaction) {
        QueryTransactionDto updatedTransaction = transactionService.updateTransaction(transactionId, transaction);
        return ResponseEntity.ok(updatedTransaction);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable("id") Long transactionId){
        transactionService.deleteTransaction(transactionId);
        return ResponseEntity.ok("Transaction deleted successfully");
    }
}
