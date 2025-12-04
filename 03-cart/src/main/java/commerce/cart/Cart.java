package commerce.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cart {
    private String cartId;
    private List<Item> items;

    public Cart(String cartid) {
        this.cartId = cartId;
        this.items = new ArrayList<>();
    }

    public void addItem(String productNo, String productName, int quantity) {
        this.items.add(new Item(productNo, productName, quantity));
    }

    public void changeQuantity(String productNo, int quantity) {
        Optional<Item> foundItem = this.findItem(productNo);
        if (foundItem.isEmpty()) {
            return;
        }
        foundItem.get().changeQuantity(quantity);
    }

    private Optional<Item> findItem(String productNo) {
        return this.items.stream().filter(item -> { return productNo.equals(item.getProductNo()); }).findFirst();
    }

    public void removeltem(String productNo) {
        Optional<Item> foundItem = this.findItem(productNo);
        if (foundItem.isPresent()) {
            this.items.remove(foundItem.get());
        }
    }
}