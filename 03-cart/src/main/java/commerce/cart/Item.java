package commerce.cart;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
    //
    private String productNo;
    private String productName;
    private int quantity;

    public Item(String productNo, String productName, int quantity) {
        this.productNo = productNo;
        this.productName = productName;
        this.quantity = quantity;
    }

    public void changeQuantity(int quantity) {
        this.quantity = quantity;
    }
}
