package net.violainedrt.budget.mapper;

import net.violainedrt.budget.dto.TransactionDto;
import net.violainedrt.budget.entity.Transaction;

public class TransactionMapper {
    public static TransactionDto mapToTransactionDto(Transaction transaction){
        return new TransactionDto(
                transaction.getId(),
                transaction.getDescription(),
                transaction.getSupplier(),
                transaction.getAmount(),
                transaction.getDate(),
                transaction.getCategory(),
                transaction.getType(),
                transaction.getUser()
        );
    }
    public static Transaction mapToTransaction(TransactionDto transactionDto){
        return new Transaction(
                transactionDto.getId(),
                transactionDto.getDescription(),
                transactionDto.getSupplier(),
                transactionDto.getAmount(),
                transactionDto.getDate(),
                transactionDto.getCategory(),
                transactionDto.getType(),
                transactionDto.getUser()
        );
    }


}
