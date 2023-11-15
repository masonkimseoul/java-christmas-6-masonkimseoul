package christmas.Controller;

import christmas.Domain.BeverageMenu;
import christmas.Domain.DessertMenu;
import christmas.Domain.Event;
import christmas.Domain.MainMenu;
import christmas.Domain.Menu;
import christmas.Domain.MenuManager;
import christmas.Domain.Order;
import christmas.Util.Validation;
import christmas.View.InputView;
import christmas.View.OutputView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChristmasController {
    private static final String SPRTR_COMMA = ",";
    private static final String SPRTR_DASH = "-";
    private static final int EVENT_THRESHOLD = 10000;

    private Order order = new Order();
    private Event event;
    private List<String[]> orderInput;

    public void run() {
        OutputView.printVisitDateMsg();
        getEstimatedVisitDate();
        OutputView.printMenuOrderMsg();
        setOrderByInput(parsingOrderInput(InputView.getOrders()));
        OutputView.printOrderedMenuMsg(orderInput, event.getDate());
        OutputView.printGrossAmountMsg(order.getGrossAmount());
        //OutputView.printGiftMenu();
        applyAllEvent();
        OutputView.printAllEventAmountMsg(order.getDiscountAmount());
        OutputView.printNetAmountMsg(order.calcNetAmount());
        OutputView.printEventBadgeMsg(order.calcEventBadge());
    }

    public void getEstimatedVisitDate() {
        this.event = new Event(InputView.getVisitDate());
    }


    private List<String[]> parsingOrderInput (String input) {
        this.orderInput = new ArrayList<>();
        String[] items = input.split(SPRTR_COMMA);

        for (String item : items) {
            String[] menuItem = item.split(SPRTR_DASH);
            orderInput.add(menuItem);
        }

        return orderInput;
    }

    public void setOrderByInput(List<String[]> orderInput) {
        for(String[] item : orderInput) {
            Menu orderedMenu = MenuManager.getMenuByName(item[0]);
            this.order.addMenuAtCart(orderedMenu, Validation.parseInteger(item[1]));
        }
    }

    public void applyAllEvent() {
        if (order.getGrossAmount() >= EVENT_THRESHOLD) {
            OutputView.printXMasEventAmountMsg(
                    order.discountAmount(event.calcXMasDDayDiscount()));

            if(event.isWeekDayEvent()) {
                OutputView.printWeekDayEventAmountMsg(order.countDessertMenu() * event.calcDailyDiscount());
            }
            if(!event.isWeekDayEvent()) {
                OutputView.printWeekEndEventAmountMsg(order.countMainMenu() * event.calcDailyDiscount());
            }

            if(event.isSpecialEvent()) {
                OutputView.printSpecialEventAmountMsg(
                        order.discountAmount(event.calcSpecialDiscount()));
            }

            if(event.isGitfAvailable(order.getGrossAmount())) {
                OutputView.printGiftEventAmountMsg(
                        order.applyGiftEvent(BeverageMenu.CHAMPAGNE));
            }
        }
    }
}
