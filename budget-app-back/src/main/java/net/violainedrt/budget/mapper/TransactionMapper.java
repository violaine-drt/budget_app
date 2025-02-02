package net.violainedrt.budget.mapper;

import net.violainedrt.budget.dto.TransactionDto;
import net.violainedrt.budget.entity.Transaction;

public class TransactionMapper {
    public static TransactionDto mapToTransactionDto(Transaction transaction) {
        return new TransactionDto(
                transaction.getId(),
                transaction.getDescription(),
                transaction.getCounterparty(),
                transaction.getAmount(),
                transaction.getDateTime(),
                transaction.getFinancialType(),
                transaction.getCategory(),
                transaction.getSubcategory(),
                transaction.getUser(),
                transaction.getCreatedAt(),
                transaction.getUpdatedAt()
        );
    }

    public static Transaction mapToTransaction(TransactionDto transactionDto) {
        return new Transaction(
                transactionDto.getId(),
                transactionDto.getDescription(),
                transactionDto.getCounterparty(),
                transactionDto.getAmount(),
                transactionDto.getDateTime(),
                transactionDto.getFinancialType(),
                transactionDto.getCategory(),
                transactionDto.getSubcategory(),
                transactionDto.getUser(),
                transactionDto.getCreatedAt(),
                transactionDto.getUpdatedAt()
        );
    }


}
