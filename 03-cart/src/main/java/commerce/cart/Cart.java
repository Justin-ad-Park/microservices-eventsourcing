package commerce.cart;

import commerce.cart.event.ItemAdded;
import commerce.cart.event.ItemRemoved;
import commerce.cart.event.QuantityChanged;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cart {
    private String cartId;
    private List<Item> items;

    private List<Object> events;

    public Cart(String cartid) {
        this.cartId = cartId;
        this.items = new ArrayList<>();
        this.events = new ArrayList<>();
    }

    public void addItem(String productNo, String productName, int quantity) {
        this.items.add(new Item(productNo, productName, quantity));
        ItemAdded event = new ItemAdded(productNo, productName, quantity);
        this.events.add(event);
    }

    public void changeQuantity(String productNo, int quantity) {
        Optional<Item> foundItem = this.findItem(productNo);
        if (foundItem.isEmpty()) {
            return;
        }
        foundItem.get().changeQuantity(quantity);

        QuantityChanged event = new QuantityChanged(productNo, quantity);
        this.events.add(event);

    }

    private Optional<Item> findItem(String productNo) {
        return this.items.stream().filter(item -> { return productNo.equals(item.getProductNo()); }).findFirst();
    }

    public void removeltem(String productNo) {
        Optional<Item> foundItem = this.findItem(productNo);
        if(foundItem.isEmpty()) {
            return;
        }

        this.items.remove(foundItem.get());

        ItemRemoved event = new ItemRemoved(productNo);
        this.events.add(event);
    }

    public List<Object> getEvents() {
        return this.events;
    }
}