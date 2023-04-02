package dao;

import java.util.ArrayList;
import java.util.List;

import model.Contact;

public class ContactImplDAO implements ContactDAO {
    private List<Contact> database = new ArrayList<Contact>();
    public ContactImplDAO(){

    }
    @Override
    public void addContacts(Contact contact) {
        if (contact != null) {
            database.add(contact);
        }
    }

    @Override
    public Contact findByApelido(String username) {
        return database.stream()
                .filter(user1 -> user1.getApelido() == username)
                .findAny()
                .orElse(null);

    }

    @Override
    public List<Contact> findAll() {
        return database;
    }
}
