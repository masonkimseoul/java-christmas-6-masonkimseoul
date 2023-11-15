package christmas.Domain;

import java.util.ArrayList;
import java.util.List;

enum Badge {
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);

    private final String name;
    private final int badgeThreshold;

    Badge(String name, int badgeThreshold) {
        this.name = name;
        this.badgeThreshold = badgeThreshold;
    }

    public String getName() {
        return this.name;
    }

    public int getBadgeThresholdThreshold() {
        return this.badgeThreshold;
    }
}

public class Order {
    private static final int ZERO = 0;

    private static final String NONE = "없음";

    private final List<Menu> Cart;
    private String eventBadge;
    private int grossAmount;
    private int discountedAmount;

    public Order() {
        this.Cart = new ArrayList<>();
        this.eventBadge = NONE;
        this.grossAmount = ZERO;
        this.discountedAmount = ZERO;
    }

    public void addMenuAtCart(Menu menu, int count) {
        for(int i = 0; i < count; i++){
            this.Cart.add(menu);
            grossAmount += menu.getPrice();
        }
    }

    public void discountAmount(int amount) {
        this.discountedAmount += amount;
    }

    public void discountMenuPrice(Menu menuType, int amount) {
        for(Menu item : Cart) {
            if(item.getClass() == menuType.getClass()) {
                discountAmount(amount);
            }
        }
    }

    public void applyGiftEvent(Menu menu) {
        this.Cart.add(menu);
        this.discountedAmount += menu.getPrice();
    }

    public String calcEventBadge() {
        Badge[] badges = Badge.values();

        for(Badge badge : badges) {
            if (this.discountedAmount >= badge.getBadgeThresholdThreshold()) {
                this.eventBadge = badge.getName();
            }
        }
        return this.eventBadge;
    }
    
    public int calcNetAmount() {
        return this.grossAmount - this.discountedAmount;
    }
}
