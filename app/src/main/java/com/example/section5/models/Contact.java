package com.example.section5.models;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;

public class Contact implements Serializable {

    private final String name;
    private final String phone;
    private final String avatarURL;

    private final String email;


    public Contact(String name, String phone, String avatarURL, String email) {
        this.name = name;
        this.phone = phone;
        this.avatarURL = avatarURL;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    @NotNull
    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", avatarURL='" + avatarURL + '\'' +
                '}';
    }

    public static ArrayList<Contact> generateDummyContacts(int size) {
        ArrayList<Contact> contacts = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            contacts.add(new Contact("Contact Name " + i, "Contact Phone " + i, "https://picsum.photos/200/300", "Contact Email " + i));
        }
        return contacts;
    }
}
