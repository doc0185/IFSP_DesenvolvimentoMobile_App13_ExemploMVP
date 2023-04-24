package br.edu.ifsp.dmo.app13_exemplo_login_mvp.contracts;

public interface MainContract {
    interface View{
        void showMessage(String message);
    }

    interface Presenter{
        void detach();
        void login(String usuario, int senha);
    }
}
