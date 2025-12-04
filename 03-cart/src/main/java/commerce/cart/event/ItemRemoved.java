package commerce.cart.event;

public class ItemRemoved extends BaseEvent {
    private String productNo;

    public ItemRemoved(String productNo) {
        this.productNo = productNo;
    }
}
