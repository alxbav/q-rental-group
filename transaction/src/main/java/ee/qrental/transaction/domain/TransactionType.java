package ee.qrental.transaction.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionType {
    private Long id;
    private String name;
    private String description;
    private Boolean negative;
    private String comment;
}
