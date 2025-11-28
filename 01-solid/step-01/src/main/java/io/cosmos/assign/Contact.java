package io.cosmos.assign;

public class Contact {
    ContactType contactType;
    String phoneNumber;

    public Contact(ContactType contactType, String number) {
        this.contactType = contactType;
        this.phoneNumber = number;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public enum ContactType {Mobile, Landline}
}
