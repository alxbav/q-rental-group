package ee.qrental.transaction.application.port.in.utils;

import lombok.Getter;

import static java.lang.String.format;

public enum Week {
    FIRST("Jan", 1),
    SECOND("Jan", 2),
    THIRD("Jan", 3),
    FORTH("Jan-Feb", 4),
    FIFTH("Feb", 5),
    SIXTH( "Feb", 6),
    SEVENTH( "Feb", 7),
    EIGHTH( "Feb", 8)

    ;
    private String month;

    @Getter
    private Integer number;

     Week(String month, Integer number) {
        this.month = month;
        this.number = number;
    }
    public String getDisplayValue(){
         return format("Week %d ( %s )", number, month);
    }
}
