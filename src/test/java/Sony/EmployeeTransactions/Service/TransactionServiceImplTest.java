package Sony.EmployeeTransactions.Service;

import Sony.EmployeeTransactions.Entity.AddressEntity;
import Sony.EmployeeTransactions.Entity.TransactionEntity;
import Sony.EmployeeTransactions.Repository.TransactionRepository;
import Sony.EmployeeTransactions.dto.TransactionRequest;
import Sony.EmployeeTransactions.mapper.TransactionMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransactionServiceImplTest {

    @Mock
    private TransactionRepository repository;

    @Mock
    private TransactionMapper mapper;

    @InjectMocks
    private TransactionServiceImpl service;

    @Test
    void shouldCreateTransactionAndSetBackReference() {

        // 1️⃣ GIVEN (input)
        TransactionRequest request = new TransactionRequest();
        request.setId("TXN100");

        TransactionEntity entity = new TransactionEntity();
        entity.setId("TXN100");

        AddressEntity address = new AddressEntity();
        address.setId("ADDR1");

        entity.setAddressEntities(List.of(address));

        when(mapper.toEntity(request)).thenReturn(entity);
        when(repository.save(entity)).thenReturn(entity);

        // 2️⃣ WHEN (call service)
        TransactionEntity result = service.createTransaction(request);

        // 3️⃣ THEN (verify)
        assertNotNull(result);
        assertEquals("TXN100", result.getId());

        // 🔥 MOST IMPORTANT ASSERTION
        assertEquals(entity, address.getTransaction());

        verify(mapper, times(1)).toEntity(request);
        verify(repository, times(1)).save(entity);
    }
}
