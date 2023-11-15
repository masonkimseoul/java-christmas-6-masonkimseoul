package christmas.Domain;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum AppetizerMenu implements Menu{
    MUSHROOM_SOUP("양송이수프", 6000),
    TAPAS("타파스", 5500),
    CAESAR_SALAD("시저샐러드", 8000);

    private final String name;
    private final int price;

    AppetizerMenu(String name, int price) {
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

    private static final Map<String, AppetizerMenu> appetizerMenus
            = Stream.of(AppetizerMenu.values())
            .collect(Collectors.toMap(a -> a.name, a -> a));

    public static AppetizerMenu getByName(String name) {
        return appetizerMenus.get(name);
    }
}
