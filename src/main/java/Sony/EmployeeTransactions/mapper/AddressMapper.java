package Sony.EmployeeTransactions.mapper;


import Sony.EmployeeTransactions.Entity.AddressEntity;
import Sony.EmployeeTransactions.dto.AddressRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel ="spring")
public interface AddressMapper {
    @Mapping(target = "transaction", ignore = true)
    AddressEntity toEntity(AddressRequest dto);

}
