package Sony.EmployeeTransactions.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Sony.EmployeeTransactions.Entity.TransactionEntity;

public interface TransactionRepository
        extends JpaRepository<TransactionEntity, String> {
}
