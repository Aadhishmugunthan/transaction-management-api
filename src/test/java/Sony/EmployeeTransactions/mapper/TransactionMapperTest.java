package Sony.EmployeeTransactions.mapper;

import Sony.EmployeeTransactions.Entity.TransactionEntity;
import Sony.EmployeeTransactions.dto.TransactionRequest;
import Sony.EmployeeTransactions.dto.AddressRequest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransactionMapperTest {

    @Autowired
    private TransactionMapper transactionMapper;

    @Test
    void shouldMapTransactionRequestToEntity() {

        // given
        TransactionRequest request = new TransactionRequest();
        request.setTxnName("TXN_1");
        request.setAmount("1000");

        AddressRequest addressRequest = new AddressRequest();
        addressRequest.setCity("Chennai");
        addressRequest.setState("TN");

        request.setAddressesDtos(List.of(addressRequest));

        // when
        TransactionEntity entity = transactionMapper.toEntity(request);

        // then
        assertNotNull(entity);
        assertEquals("TXN_1", entity.getTxnName());
        assertEquals("1000", entity.getAmount());
        assertNotNull(entity.getAddressEntities());
        assertEquals(1, entity.getAddressEntities().size());
    }
}
