package christmas.Domain;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum DessertMenu implements Menu{
    CHOCO_CAKE("초코케이크", 15000),
    ICE_CREAM("아이스크림", 5000);

    private final String name;
    private final int price;

    DessertMenu(String name, int price) {
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

    private static final Map<String, DessertMenu> dessertMenus
            = Stream.of(DessertMenu.values())
            .collect(Collectors.toMap(d -> d.name, d -> d));

    public static DessertMenu getByName(String name) {
        return dessertMenus.get(name);
    }
}
