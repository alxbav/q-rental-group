package ee.qrental.transaction.domain;


import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Constant {

    private static final Integer COMMENT_MAX_SIZE = 150;
    private Long id;
    private String name;
    private Double value;
    private String description;
    private Boolean negative;


    public Constant(Long id, String name, Double value, String description, Boolean negative) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.description = description;
        this.negative = negative;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNegative(Boolean negative) {
        validateNegative(negative);
        this.negative = negative;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    private void validateNegative(final Boolean negative) {
        if (negative == null) {
            throw new RuntimeException("Constant property 'negative' must not be NULL. Value must be TRUE or FALSE");
        }
    }

}
