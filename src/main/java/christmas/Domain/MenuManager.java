package christmas.Domain;

import christmas.Util.Validation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class MenuManager {
    private static final Map<String, Menu> allMenus = new HashMap<>();

    static {
        Stream.of(AppetizerMenu.values(), MainMenu.values(),
                        DessertMenu.values(), BeverageMenu.values())
                .flatMap(Arrays::stream)
                .forEach(item -> allMenus.put(item.getName(), item));
    }

    public static Menu getMenuByName(String menuName) {
        Menu menu = allMenus.get(menuName);
        Validation.validateNullMenu(menu);
        return menu;
    }
}
