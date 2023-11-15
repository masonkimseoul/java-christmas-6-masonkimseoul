package christmas.Controller;

import christmas.Domain.Menu;
import christmas.Domain.MenuManager;
import christmas.Domain.Order;
import christmas.Util.Validation;
import christmas.View.InputView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChristmasController {
    private static final String SPRTR_COMMA = ",";
    private static final String SPRTR_DASH = "-";

    private Order order = new Order();


    private List<String[]> parsingOrderInput (String input) {
        List<String[]> orderInput = new ArrayList<>();
        String[] items = input.split(SPRTR_COMMA);

        for (String item : items) {
            String[] menuItem = item.split(SPRTR_DASH);
            orderInput.add(menuItem);
        }

        return orderInput;
    }

    public void setOrderByInput() {
        List<String[]> orderInput = parsingOrderInput(InputView.getOrders());

        for(String[] item : orderInput) {
            Menu orderedMenu = MenuManager.getMenuByName(item[0]);
            order.addMenuAtCart(orderedMenu, Validation.parseInteger(item[1]));
        }
    }
}
