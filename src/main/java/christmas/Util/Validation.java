package christmas.Util;

import christmas.Domain.Menu;
import java.util.List;

public class Validation {
    private static final String INPUT_DATE_ERROR_MSG = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static final String INPUT_ORDERS_ERROR_MSG = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 31;

    private static void validateDateRange(int input) {
        if (input < MIN_VALUE || input > MAX_VALUE) {
            throw new IllegalArgumentException(INPUT_DATE_ERROR_MSG);
        }
    }

    private static void validateFilledOrders(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(INPUT_ORDERS_ERROR_MSG);
        }
    }

    public static int parseInteger(String input){
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_DATE_ERROR_MSG);
        }
    }

    public static int validateVisitDate(String input){
        int visitDate = parseInteger(input);
        validateDateRange(visitDate);
        return visitDate;
    }

    public static String validateOrders(String input) {
        validateFilledOrders(input);
        return input;
    }

    public static void validateDuplicatedMenu(List<Menu> cart, Menu menu) {
        if (cart.contains(menu)) {
            cart.clear();
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
