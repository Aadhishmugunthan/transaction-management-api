package Sony.EmployeeTransactions.Service;

import Sony.EmployeeTransactions.Entity.TransactionEntity;
import Sony.EmployeeTransactions.dto.TransactionRequest;

public interface TransactionService {

    TransactionEntity createTransaction(TransactionRequest request);
}
