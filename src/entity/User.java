package entity;

public class User {

    private String login;
    private String pass;
    private City city;
    private String role;

    public User() {
    }

    public User(String login, String pass, City city, String role) {
        this.login = login;
        this.pass = pass;
        this.city = city;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
