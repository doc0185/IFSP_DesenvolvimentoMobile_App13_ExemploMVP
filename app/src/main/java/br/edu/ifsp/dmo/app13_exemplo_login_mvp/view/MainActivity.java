package br.edu.ifsp.dmo.app13_exemplo_login_mvp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.ifsp.dmo.app13_exemplo_login_mvp.R;
import br.edu.ifsp.dmo.app13_exemplo_login_mvp.contracts.MainContract;
import br.edu.ifsp.dmo.app13_exemplo_login_mvp.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainContract.Presenter presenter;
    private EditText usuario, senha;
    private Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);
        findViews();
        setListener();
    }

    @Override
    protected void onDestroy() {
        presenter.detach();
        super.onDestroy();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void findViews(){
        usuario = findViewById(R.id.edit_username);
        senha = findViewById(R.id.edit_password);
        botao = findViewById(R.id.button);
    }

    private void setListener(){
        botao.setOnClickListener(v -> logar());
    }

    private void logar(){
        presenter.login(usuario.getText().toString(), Integer.parseInt(senha.getText().toString()));
    }
}