package com.finalgo.application.bean;

/**
 * Objet permettant le transfert des données de Login du front vers le back
 */
public class LoginBean {

    private String username;
    private String password;

    public LoginBean() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
