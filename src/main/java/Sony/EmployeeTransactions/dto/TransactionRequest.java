package Sony.EmployeeTransactions.dto;

import java.util.List;

public class TransactionRequest {

    private String id;
    private String txnName;
    private String amount;
    private List<AddressRequest> addressesDtos;

    public TransactionRequest() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTxnName() {
        return txnName;
    }

    public void setTxnName(String txnName) {
        this.txnName = txnName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public List<AddressRequest> getAddressesDtos() {
        return addressesDtos;
    }

    public void setAddressesDtos(List<AddressRequest> addressesDtos) {
        this.addressesDtos = addressesDtos;
    }
}
