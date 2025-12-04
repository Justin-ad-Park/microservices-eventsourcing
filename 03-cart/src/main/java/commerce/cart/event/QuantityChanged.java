package commerce.cart.event;

public class QuantityChanged extends BaseEvent {
    private String productNo;
    private int quantity;

    private QuantityChanged(String productNo, int quantity) {
        this.productNo = productNo;
        this.quantity = quantity;
    }

}
