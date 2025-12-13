package Sony.EmployeeTransactions.mapper;

import Sony.EmployeeTransactions.Entity.TransactionEntity;
import Sony.EmployeeTransactions.dto.TransactionRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    TransactionEntity toEntity(TransactionRequest request);
}
