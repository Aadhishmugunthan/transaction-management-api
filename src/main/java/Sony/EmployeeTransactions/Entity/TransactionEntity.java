package Sony.EmployeeTransactions.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;

import java.util.List;

@Entity
@Table(name = "TRANSACTION_TABLE")
public class TransactionEntity {

    @Id
    private String id;

    private String txnName;
    private String amount;

    @OneToMany(
            mappedBy = "transaction",
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private List<AddressEntity> addressEntities;

    //  No-args constructor
    public TransactionEntity() {
    }

    //  All-args constructor
    public TransactionEntity(String id, String txnName, String amount, List<AddressEntity> addressEntities) {
        this.id = id;
        this.txnName = txnName;
        this.amount = amount;
        this.addressEntities = addressEntities;
    }

    //  Getters & Setters

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

    public List<AddressEntity> getAddressEntities() {
        return addressEntities;
    }

    public void setAddressEntities(List<AddressEntity> addressEntities) {
        this.addressEntities = addressEntities;
    }
}
