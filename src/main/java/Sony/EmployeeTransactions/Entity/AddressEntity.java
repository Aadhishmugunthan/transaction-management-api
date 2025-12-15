package Sony.EmployeeTransactions.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ADDRESS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity {

    @Id
    private String id;

    private String city;
    private String state;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    @JsonManagedReference
    private TransactionEntity transaction;

}
