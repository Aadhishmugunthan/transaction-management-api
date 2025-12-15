package Sony.EmployeeTransactions.mapper;

import Sony.EmployeeTransactions.Entity.TransactionEntity;
import Sony.EmployeeTransactions.dto.TransactionRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = AddressMapper.class)
public interface TransactionMapper {

    @Mapping(source = "addressesDtos", target = "addressEntities")
    @Mapping(target = "addressEntities[].transaction", ignore = true)
    TransactionEntity toEntity(TransactionRequest request);
}
