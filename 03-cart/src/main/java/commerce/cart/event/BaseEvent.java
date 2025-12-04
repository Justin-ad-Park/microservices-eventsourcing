package commerce.cart.event;

import commerce.cart.uuid.TImeBasedUUID;

public class BaseEvent {
    private String eventId;
    private long time;

    protected BaseEvent() {
        this.eventId = TImeBasedUUID.generateTimeBasedId();
        this.time = System.currentTimeMillis();
    }
}
