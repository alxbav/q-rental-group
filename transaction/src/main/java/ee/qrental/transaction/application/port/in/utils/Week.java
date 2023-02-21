package ee.qrental.transaction.application.port.in.utils;

import lombok.Getter;

import static java.lang.String.format;

public enum Week {
    FIRST("Jan", 1),
    SECOND("Jan", 2),
    THIRD("Jan", 3),
    FORTH("Jan", 4),
    FIFTH("Jan-Feb", 5),
    SIXTH( "Feb", 6),
    SEVENTH( "Feb", 7),
    EIGHTH( "Feb", 8),
    NINTH( "Feb-Mar", 9),
    TENTH( "Mar", 10),
    ELEVENTH( "Mar", 11),
    TWELFTH( "Mar", 12),
    THIRTEENTH( "Mar", 13),
    FOURTEENTH( "Apr", 14),
    FIFTEENTH( "Apr", 15),
    SIXTEENTH( "Apr", 16),
    SEVENTEENTH( "Apr", 17),
    EIGHTEENTH( "May", 18),
    NINETEENTH( "May", 19),
    TWENTIETH( "May", 20),
    TWENTY_FIRST( "May", 21),
    TWENTY_SECOND( "May-Jun", 22),
    TWENTY_THIRD( "Jun", 23),
    TWENTY_FORTH( "Jun", 24),
    TWENTY_FIFTH( "Jun", 25),
    TWENTY_SIXTH( "Jun-Jul", 26),
    TWENTY_SEVENTH( "Jul", 27),
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
