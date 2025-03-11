package net.violainedrt.budget.domain.mapper;

import jakarta.persistence.EntityNotFoundException;
import net.violainedrt.budget.application.dto.TransactionDto;
import net.violainedrt.budget.infrastructure.entity.*;
import net.violainedrt.budget.infrastructure.repository.*;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {UserRepository.class, CategoryRepository.class, SubcategoryRepository.class, SupplierRepository.class},  injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface TransactionMapper {


    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "subcategory.id", target = "subcategoryId")
    @Mapping(source = "supplier.id", target = "supplierId")
    TransactionDto toTransactionDto (Transaction transactionEntity);

    @Mapping(source = "userId", target = "user", qualifiedByName = "mapUserIdToUser")
    @Mapping(source = "categoryId", target = "category", qualifiedByName = "mapCategoryIdToCategory")
    @Mapping(source = "subcategoryId", target = "subcategory", qualifiedByName = "mapSubcategoryIdToSubcategory")
    @Mapping(source = "supplierId", target = "supplier", qualifiedByName = "mapSupplierIdToSupplier")
    Transaction toTransactionEntity (TransactionDto transactionDto, @Context UserRepository userRepository, @Context CategoryRepository categoryRepository, @Context SubcategoryRepository subcategoryRepository, @Context SupplierRepository supplierRepository);

    @Named("mapUserIdToUser")
    default User mapUserIdToUser(Long userId, @Context UserRepository userRepository) {
        if (userId == null) {
            return null;
        }
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Utilisateur avec l'ID " + userId + " introuvable."));
    }

    @Named("mapCategoryIdToCategory")
    default Category mapCategoryIdToCategory (Long categoryId, @Context CategoryRepository categoryRepository) {
        if (categoryId == null) {
            return null;
        }
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Categorie avec l'ID " + categoryId + " introuvable."));
    }

    @Named("mapSubcategoryIdToSubcategory")
    default Subcategory mapSubcategoryIdToSubcategory (Long subcategoryId, @Context SubcategoryRepository subcategoryRepository) {
        if (subcategoryId == null) {
            return null;
        }
        return subcategoryRepository.findById(subcategoryId)
                .orElseThrow(() -> new EntityNotFoundException("Sous-categorie avec l'ID " + subcategoryId + " introuvable."));
    }

    @Named("mapSupplierIdToSupplier")
    default Supplier mapSupplierIdToSupplier (Long supplierId, @Context SupplierRepository supplierRepository) {
        if (supplierId == null) {
            return null;
        }
        return supplierRepository.findById(supplierId)
                .orElseThrow(() -> new EntityNotFoundException("Contact avec l'ID " + supplierId + " introuvable."));
    }

}
