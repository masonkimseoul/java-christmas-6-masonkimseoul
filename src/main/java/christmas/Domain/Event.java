package christmas.Domain;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Event {
    private final int date;
    private final boolean isWeekDay;
    private final boolean isSpecial;

    private static final int DEFAULT_DISCOUNT = 1000;
    private static final int TICK = 100;
    private static final int START_DATE = 1;
    private static final int X_MAS_DATE = 25;
    private static final int ZERO = 0;
    private static final int GIFT_EVENT_THRESHOLD = 120000;
    private static final List<Integer> SPECIAL_EVENT;

    public Event(int date) {
        this.date = date;
        this.isWeekDay = (date % 7 > 3);
        this.isSpecial = isSpecialDate(date);
    }

    static {
        SPECIAL_EVENT = Collections.unmodifiableList(
                Arrays.asList(3, 10, 17, 24, 25, 31));
    }

    private static boolean isSpecialDate(int date) {
        return SPECIAL_EVENT.contains(date);
    }

    public int calcXMasDDayDiscount() {
        if (this.date <= X_MAS_DATE ) {
            return DEFAULT_DISCOUNT + (this.date - START_DATE) * TICK;
        }
        return ZERO;
    }

    public boolean isGitfAvailable(int grossAmount) {
        return GIFT_EVENT_THRESHOLD <= grossAmount;
    }

    public boolean isWeekDayEvent() {
        return isWeekDay;
    }

    public boolean isSpecialEvent() {
        return isSpecial;
    }

    public int getDate() {
        return this.date;
    }
}