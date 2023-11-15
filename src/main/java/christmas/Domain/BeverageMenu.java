package christmas.Domain;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum BeverageMenu implements Menu{
    ZERO_COKE("제로콜라", 3000),
    RED_WINE("레드와인", 60000),
    CHAMPAGNE("샴페인", 25000);

    private final String name;
    private final int price;

    BeverageMenu(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    private static final Map<String, BeverageMenu> beverageMenus
            = Stream.of(BeverageMenu.values())
            .collect(Collectors.toMap(b -> b.name, b -> b));

    public static BeverageMenu getByName(String name) {
        return beverageMenus.get(name);
    }
}
