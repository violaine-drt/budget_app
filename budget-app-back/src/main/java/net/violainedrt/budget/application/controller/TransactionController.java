package net.violainedrt.budget.application.controller;


import lombok.AllArgsConstructor;
import net.violainedrt.budget.application.dto.TransactionDto;
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
    public ResponseEntity<TransactionDto> createTransaction(@RequestBody TransactionDto transactionDto){
        TransactionDto savedTransaction = transactionService.createTransaction(transactionDto);
        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
    }

    //Build Get Transaction REST API
    @GetMapping("{id}")
    public ResponseEntity<TransactionDto> getTransactionById(@PathVariable("id") Long transactionId){
        TransactionDto transactionDto = transactionService.getTransactionById(transactionId);
        return ResponseEntity.ok(transactionDto);
    }

    //Build Get All transactions REST API
    @GetMapping
    public ResponseEntity<List<TransactionDto>> getAllTransactions(){
        List<TransactionDto> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable("id") Long transactionId){
        transactionService.deleteTransaction(transactionId);
        return ResponseEntity.ok("Transaction deleted successfully");
    }
}
