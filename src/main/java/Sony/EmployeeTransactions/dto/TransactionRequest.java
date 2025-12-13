package Sony.EmployeeTransactions.dto;

import lombok.Data;

import java.util.List;

@Data
public class TransactionRequest {
    private String id;
    private String txnName;
    private String amount;
    private List<AddressRequest> addresses;

}
