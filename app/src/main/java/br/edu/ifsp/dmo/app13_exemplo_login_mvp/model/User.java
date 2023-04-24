package br.edu.ifsp.dmo.app13_exemplo_login_mvp.model;

public class User {
    private static User instance = null;
    private String username;
    private int password;

    private User(){
        username = "aluno";
        password = 123;
    }

    public static User getInstance(){
        if(instance == null){
            instance = new User();
        }
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public boolean autenticate(String username, int password){
        return this.username.equals(username) && this.password == password;
    }
}
