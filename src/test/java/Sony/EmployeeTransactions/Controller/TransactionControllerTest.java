package Sony.EmployeeTransactions.Controller;

import Sony.EmployeeTransactions.Entity.TransactionEntity;
import Sony.EmployeeTransactions.Service.TransactionService;
import Sony.EmployeeTransactions.dto.TransactionRequest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TransactionController.class)
public class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionService transactionService;

    @Test
    void shouldCreateTransaction() throws Exception {

        when(transactionService.createTransaction(any(TransactionRequest.class)))
                .thenReturn(new TransactionEntity());

        String json = """
        {
          "id": "TXN200",
          "txnName": "Test Txn",
          "amount": 1000,
          "addressesDtos": []
        }
        """;

        mockMvc.perform(post("/transactions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());

        verify(transactionService).createTransaction(any(TransactionRequest.class));
    }
}
