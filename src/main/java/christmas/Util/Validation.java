package christmas.Util;

public class Validation {
    private static final String INPUT_TYPE_ERROR_MSG = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 31;

    private static int parseInteger(String input){
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_TYPE_ERROR_MSG);
        }
    }

    private static void validateDateRange(int input) {
        if (input < MIN_VALUE || input > MAX_VALUE) {
            throw new IllegalArgumentException(INPUT_TYPE_ERROR_MSG);
        }
    }

    public static int validateVisitDate(String input){
        int visitDate = parseInteger(input);
        validateDateRange(visitDate);
        return visitDate;
    }
}
