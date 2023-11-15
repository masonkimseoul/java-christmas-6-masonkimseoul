package christmas.View;

import christmas.Domain.BeverageMenu;
import christmas.Domain.Menu;
import christmas.Util.Validation;
import java.text.DecimalFormat;
import java.util.List;

public class OutputView {
    private static final int MONTH = 12;
    private static final String GET_VISIT_DATE_MSG
            = "안녕하세요! 우테코 식당 %d월 이벤트 플래너입니다.\n"
                    + "%d월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해주세요!)\n";
    private static final String GET_MENU_ORDER_MSG
            = "주문하실 메뉴를 메뉴와 개수로 알려 주세요."
                    + "(e.g. 해산물파스타-2,레드와인-1,초코케이크-1)\n";
    private static final String ALL_EVENT_INTRO_MSG
            = "%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
    private static final String ORDERED_MENU_INTRO_MSG
            = "\n<주문 메뉴>\n";
    private static final String ALL_MENUS_MSG
            = "%s %d개\n";
    private static final String GROSS_AMOUNT_INTRO_MSG
            = "\n<할인 전 총주문 금액>\n";
    private static final String SHOW_AMOUNT_MSG
            = "%s원\n";
    private static final String GIFT_EVENT_MENU_INTRO_MSG
            = "\n<증정 메뉴>\n";
    private static final String EVENT_INTRO_MSG
            = "\r\n<혜택 내역>\r\n";
    private static final String X_MAX_EVENT_MSG
            = "크리스마스 디데이 할인: ";
    private static final String WEEKDAY_EVENT_MSG
            = "평일 할인: ";
    private static final String WEEKEND_EVENT_MSG
            = "주말 할인: ";
    private static final String SPECIAL_EVENT_MSG
            = "특별 할인: ";
    private static final String GIFT_EVENT_MSG
            = "증정 이벤트: ";
    private static final String ALL_EVENT_AMOUNT_INTRO_MSG
            = "\n<총혜택 금액>\n";
    private static final String NET_AMOUNT_INTRO_MSG
            = "\n<할인 후 예상 결제 금액>\n";
    private static final String MONTH_EVENT_BADGE_INTRO_MSG
            = "\n<%d월 이벤트 배지>\n";
    private static final String CHAMPAGNE = "샴페인";
    private static final String NONE = "없음";
    private static final int ONE = 1;
    private static final int ZERO = 0;
    private static final int MINUS = -1;

    public static void printVisitDateMsg() {
        System.out.printf(GET_VISIT_DATE_MSG, MONTH, MONTH);
    }

    public static void printMenuOrderMsg() {
        System.out.print(GET_MENU_ORDER_MSG);
    }

    public static void printEventIntroMSG(int date) {
        System.out.printf(ALL_EVENT_INTRO_MSG, MONTH, date);
    }

    public static void printOrderedMenuMsg(List<String[]> orderInput, int date) {
        printEventIntroMSG(date);
        System.out.print(ORDERED_MENU_INTRO_MSG);
        for (String[] item : orderInput) {
            System.out.printf(ALL_MENUS_MSG,item[0], Validation.parseOrderInteger(item[1]));
        }
    }

    public static void printGrossAmountMsg(int amount) {
        System.out.print(GROSS_AMOUNT_INTRO_MSG);
        System.out.printf(SHOW_AMOUNT_MSG, String.format("%,d", amount));
    }

    public static void printNone() {
        System.out.print(NONE);
    }
    public static void printGiftMenuMsg() {
        System.out.printf(GIFT_EVENT_MENU_INTRO_MSG);
    }

    public static void printGiftMenu() {
        System.out.printf(GIFT_EVENT_MENU_INTRO_MSG + ALL_MENUS_MSG, CHAMPAGNE, ONE);
    }

    public static void printEventIntroMsg() {
        System.out.print(EVENT_INTRO_MSG);
    }

    public static void printXMasEventAmountMsg(int amount) {
        if (amount > ZERO) {
            System.out.printf(X_MAX_EVENT_MSG + SHOW_AMOUNT_MSG, String.format("%,d", MINUS * amount));
        }
    }

    public static void printWeekDayEventAmountMsg(int amount) {
        System.out.printf(WEEKDAY_EVENT_MSG + SHOW_AMOUNT_MSG, String.format("%,d", MINUS * amount));
    }

    public static void printWeekEndEventAmountMsg(int amount) {
        System.out.printf(WEEKEND_EVENT_MSG + SHOW_AMOUNT_MSG, String.format("%,d", MINUS * amount));
    }

    public static void printSpecialEventAmountMsg(int amount) {
        System.out.printf(SPECIAL_EVENT_MSG + SHOW_AMOUNT_MSG, String.format("%,d", MINUS * amount));
    }

    public static void printGiftEventAmountMsg(int amount) {
        System.out.printf(GIFT_EVENT_MSG + SHOW_AMOUNT_MSG, String.format("%,d", MINUS * amount));
    }

    public static void printAllEventAmountMsg(int amount) {
        System.out.printf(ALL_EVENT_AMOUNT_INTRO_MSG + SHOW_AMOUNT_MSG, String.format("%,d", MINUS * amount));
    }

    public static void printNetAmountMsg(int amount) {
        System.out.printf(NET_AMOUNT_INTRO_MSG + SHOW_AMOUNT_MSG, String.format("%,d", amount));
    }

    public static void printEventBadgeMsg(String badge) {
        System.out.printf(MONTH_EVENT_BADGE_INTRO_MSG + badge, MONTH);
    }
}
