package model;

import dao.ContactImplDAO;

public class User {

    private String username;
    private String senha;
    private ContactImplDAO database;

    public User(String username, String senha) {
        this.database = new ContactImplDAO();
        this.username = username;
        this.senha = senha;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    @Override
    public String toString() {
        return getUsername() + " - " + getSenha();
    }
    public void addContact(ContactImplDAO database) {
        this.database = database;
    }
    public ContactImplDAO getContacts(){
        return database;
    }
}
