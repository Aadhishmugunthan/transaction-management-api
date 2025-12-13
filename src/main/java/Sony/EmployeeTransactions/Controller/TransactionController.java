package Sony.EmployeeTransactions.Controller;

import Sony.EmployeeTransactions.Entity.TransactionEntity;
import Sony.EmployeeTransactions.Service.TransactionService;
import Sony.EmployeeTransactions.dto.TransactionRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping
    public TransactionEntity createTransaction(
            @RequestBody TransactionRequest request) {

        return service.createTransaction(request);
    }
}
