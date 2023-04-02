package model;

public class Contact {

    private String apelido;
    private String name;
    private String phoneNumber;
    public Contact(String nickname, String name, String phoneNumber){
        this.apelido = nickname;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public String getApelido() {
        return apelido;
    }
    public void setApelido(String apelido) {
        this.apelido = apelido;
    }
    public String getName() {
        return name;
    }
    public void setName(String nome) {
        this.name = name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
