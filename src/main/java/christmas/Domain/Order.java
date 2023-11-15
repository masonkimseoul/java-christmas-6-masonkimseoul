package christmas.Domain;

import java.util.ArrayList;
import java.util.List;

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

    public int getGrossAmount() {
        return this.grossAmount;
    }
    public int getDiscountAmount() {
        return this.discountedAmount;
    }

    public void addMenuAtCart(Menu menu, int count) {
        for(int i = 0; i < count; i++){
            this.Cart.add(menu);
            grossAmount += menu.getPrice();
        }
    }

    public int countDessertMenu() {
        int count = 0;
        for(Menu menu : this.Cart) {
            if (menu.getClass() == DessertMenu.CHOCO_CAKE.getClass()) {
                count += 1;
            }
        }

        return count;
    }

    public int countMainMenu() {
        int count = 0;
        for(Menu menu : this.Cart) {
            if (menu.getClass() == MainMenu.T_BONE_STEAK.getClass()) {
                count += 1;
            }
        }

        return count;
    }

    public int discountAmount(int amount) {
        this.discountedAmount += amount;
        return amount;
    }

    public int applyGiftEvent(Menu menu) {
        this.Cart.add(menu);
        this.discountedAmount += menu.getPrice();
        return menu.getPrice();
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
    
    public int calcNetAmount(boolean isGift) {
        if (isGift) {
            return this.grossAmount - this.discountedAmount + BeverageMenu.CHAMPAGNE.getPrice();
        }
        return this.grossAmount - this.discountedAmount;
    }
}
