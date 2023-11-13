package christmas.Domain;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Menu {
    public enum AppetizerMenu {
        MUSHROOM_SOUP("양송이수프", 6000),
        TAPAS("타파스", 5500),
        CAESAR_SALAD("시저샐러드", 8000);

        private final String name;
        private final int price;

        AppetizerMenu(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public int getPrice() {
            return this.price;
        }
    }

    public enum MainMenu {
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

        public int getPrice() {
            return this.price;
        }
    }

    public enum DessertMenu {
        CHOCO_CAKE("초코케이크", 15000),
        ICE_CREAM("아이스크림", 5000);

        private final String name;
        private final int price;

        DessertMenu(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public int getPrice() {
            return this.price;
        }
    }

    public enum BeverageMenu {
        ZERO_COKE("제로콜라", 3000),
        RED_WINE("레드와인", 60000),
        CHAMPAGNE("샴페인", 25000);

        private final String name;
        private final int price;

        BeverageMenu(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public int getPrice() {
            return this.price;
        }
    }

    private static final Map<String, AppetizerMenu> appetizerMap
            = Stream.of(AppetizerMenu.values())
            .collect(Collectors.toMap(a -> a.name, a -> a));
    private static final Map<String, MainMenu> mainMap
            = Stream.of(MainMenu.values())
            .collect(Collectors.toMap(m -> m.name, m -> m));
    private static final Map<String, DessertMenu>dessertMap
            = Stream.of(DessertMenu.values())
            .collect(Collectors.toMap(d -> d.name, d -> d));
    private static final Map<String, BeverageMenu> beverageMap
            = Stream.of(BeverageMenu.values())
            .collect(Collectors.toMap(b -> b.name, b -> b));

    public static AppetizerMenu getAppetizerMenuByName(String name) {
        return appetizerMap.get(name);
    }

    public static MainMenu getMainMenuByName(String name) {
        return mainMap.get(name);
    }

    public static DessertMenu getDessertMenuByName(String name) {
        return dessertMap.get(name);
    }

    public static BeverageMenu getBeverageMenuByName(String name) {
        return beverageMap.get(name);
    }
}
