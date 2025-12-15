package Sony.EmployeeTransactions.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "TRANSACTION_TABLE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}
