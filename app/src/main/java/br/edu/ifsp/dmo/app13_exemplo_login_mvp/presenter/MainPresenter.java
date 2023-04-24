package br.edu.ifsp.dmo.app13_exemplo_login_mvp.presenter;

import br.edu.ifsp.dmo.app13_exemplo_login_mvp.contracts.MainContract;
import br.edu.ifsp.dmo.app13_exemplo_login_mvp.model.User;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private User user;

    public MainPresenter(MainContract.View view){
        this.view = view;
        user = User.getInstance();
    }

    @Override
    public void detach() {
        this.view = null;
    }

    @Override
    public void login(String usuario, int senha) {
        if(user.autenticate(usuario, senha)){
            view.showMessage("Usuário autenticado com sucesso");
        } else{
            view.showMessage("Usuário ou senha inválidos");
        }
    }
}
