package commerce.cart.event;

import com.fasterxml.uuid.Generators;
import commerce.cart.uuid.TImeBasedUUID;

public class ItemAdded extends BaseEvent {
    private String productNo;
    private String productName;
    private int quantity;

    public ItemAdded(String productNo, String productName, int quantity) {
        this.productNo = productNo;
        this.productName = productName;
        this.quantity = quantity;
    }
}
