package christmas.Domain;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum MainMenu implements Menu{
    T_BONE_STEAK("티본스테이크", 55000),
    BBQ_RIB("바비큐립", 54000),
    SEAFOOD_PASTA("해산물파스타", 35000),
    X_MAX_PASTA("크리스마스파스타", 25000);

    private final String name;
    private final int price;

    MainMenu(String name, int price) {
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

    private static final Map<String, MainMenu> mainMenus
            = Stream.of(MainMenu.values())
            .collect(Collectors.toMap(m -> m.name, m -> m));

    public static MainMenu getByName(String name) {
        return mainMenus.get(name);
    }
}
