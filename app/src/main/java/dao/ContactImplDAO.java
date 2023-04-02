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
            Contact cont = null;
            if (database.isEmpty()){
                return null;
            }else{
                for(Contact contacts : database) {
                    if(contacts != null) {
                        if (contacts.getApelido().equals(username)) {
                            cont = contacts;
                        }
                    }
                }
            }
        return cont;

    }

    @Override
    public List<Contact> findAll() {
        return database;
    }
}
