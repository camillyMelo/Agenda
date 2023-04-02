package com.example.listacontato.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.listacontato.R;

import dao.UserImplDAO;
import model.User;

public class NewUserActivity extends AppCompatActivity implements View.OnClickListener{
    private Button buttonSalvar;
    private EditText editTextUsername;
    private EditText editTextSenha;
    private EditText editTextConfSenha;

    private User mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findById();
        clickListener();
    }

    private  void findById(){
        buttonSalvar = findViewById(R.id.btn_save);
        editTextUsername = findViewById(R.id.edittext_user);
        editTextSenha = findViewById(R.id.edittext_password);
        editTextConfSenha = findViewById(R.id.edittext_confPassword);
    }

    private  void clickListener(){
        buttonSalvar.setOnClickListener(this);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onClick(View view) {
        if(view == buttonSalvar){
            addUser();
        }
    }
    private void addUser(){
        String usuario = editTextUsername.getText().toString();
        String senha = editTextSenha.getText().toString();
        String confSenha = editTextConfSenha.getText().toString();

        if(usuario.isEmpty() || senha.isEmpty() || confSenha.isEmpty()){
            Toast.makeText(this, R.string.preencher_todos_campos, Toast.LENGTH_LONG).show();
        }else if (!senha.equals(confSenha)){
            Toast.makeText(this, R.string.message_senhas_diferentes, Toast.LENGTH_LONG).show();

        }else{
            if(UserImplDAO.getInstance().findByUsername(usuario) == null){
                User u = new User(usuario, senha);
                UserImplDAO.getInstance().userAdd(u);
                Toast.makeText(this, R.string.message_usuario_criado, Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, R.string.message_usuario_existente, Toast.LENGTH_SHORT).show();
            }
        }
    }
}