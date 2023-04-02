package com.example.listacontato.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.listacontato.R;
import com.example.listacontato.view.constants.Constantes;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextUsuario;
    private EditText editTextSenha;
    private Button buttonLogin;
    private Button buttonNovoUsuário;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findById();
        clickListener();
    }

    @Override
    public void onClick(View view) {
        if(view == buttonLogin){
            abrirActivityContact();
        }
        if(view == buttonNovoUsuário){
            addNovoUsuario();
        }
    }

    private  void findById(){
        editTextUsuario = findViewById(R.id.edittext_usuario);
        editTextSenha = findViewById(R.id.edittext_senha);
        buttonLogin = findViewById(R.id.btn_login);
        buttonNovoUsuário = findViewById(R.id.btn_novo_usuario);
    }
    private  void clickListener(){
        buttonLogin.setOnClickListener(this);
        buttonNovoUsuário.setOnClickListener(this);
    }
    private void abrirActivityContact(){
        String usuario = editTextUsuario.getText().toString();
        String senha = editTextSenha.getText().toString();

        Bundle bundle = new Bundle();
        bundle.putString(Constantes.USERNAME, usuario);
        bundle.putString(Constantes.PASSWORD, senha);

        if(usuario.matches("") || senha.matches("")){
            Toast.makeText(this, R.string.preencher_todos_campos, Toast.LENGTH_LONG).show();
        }else{
            Intent intent = new Intent(this, ContactsActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
    private void addNovoUsuario(){
        Intent intent = new Intent(this, NewUserActivity.class);
        startActivity(intent);
    }

}