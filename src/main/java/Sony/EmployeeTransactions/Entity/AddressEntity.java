package Sony.EmployeeTransactions.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class AddressEntity {

    @Id
    private String id;

    private String city;
    private String state;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    @JsonManagedReference
    private TransactionEntity transaction;

    // ✅ No-args constructor
    public AddressEntity() {
    }

    // ✅ All-args constructor
    public AddressEntity(String id, String city, String state, TransactionEntity transaction) {
        this.id = id;
        this.city = city;
        this.state = state;
        this.transaction = transaction;
    }

    // ✅ Getters & Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public TransactionEntity getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionEntity transaction) {
        this.transaction = transaction;
    }
}
