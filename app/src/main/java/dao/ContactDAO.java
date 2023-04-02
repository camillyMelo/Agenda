package dao;

import java.util.List;

import model.Contact;

public interface ContactDAO {

    void addContacts(Contact contact);
    Contact findByApelido(String username);
    List<Contact> findAll();
}
