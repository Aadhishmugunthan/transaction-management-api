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
    private String id;        // Primary Key (String)

    private String txnName;   // Transaction name
    private String amount;    // Amount as String

    @OneToMany(
            mappedBy = "transaction",
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private List<AddressEntity> addresses;

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

    public List<AddressEntity> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressEntity> addresses) {
        this.addresses = addresses;
    }
}
