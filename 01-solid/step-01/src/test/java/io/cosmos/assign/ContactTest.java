package io.cosmos.assign;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactTest {
    @Test
    void getPhoneNumber() {
        Contact contact = new Contact(Contact.ContactType.Mobile, "01012345678");
        Assertions.assertEquals("01012345678", contact.getPhoneNumber());
    }
}
