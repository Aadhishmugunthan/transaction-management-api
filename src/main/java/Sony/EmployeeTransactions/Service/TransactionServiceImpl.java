package Sony.EmployeeTransactions.Service;

import Sony.EmployeeTransactions.Entity.AddressEntity;
import Sony.EmployeeTransactions.Entity.TransactionEntity;
import Sony.EmployeeTransactions.Repository.TransactionRepository;
import Sony.EmployeeTransactions.dto.TransactionRequest;
import Sony.EmployeeTransactions.mapper.TransactionMapper;
import org.springframework.stereotype.Service;

@Service   //
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;
    private final TransactionMapper mapper;

    public TransactionServiceImpl(TransactionRepository repository,
                                  TransactionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public TransactionEntity createTransaction(TransactionRequest request) {

        // DTO -> Entity
        TransactionEntity entity = mapper.toEntity(request);

        if (entity.getAddressEntities() != null) {
            entity.getAddressEntities()
                    .forEach(a -> a.setTransaction(entity));
        }

        return repository.save(entity);
    }
}
