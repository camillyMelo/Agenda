package com.example.listacontato.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.listacontato.R;
import com.example.listacontato.view.constants.Constantes;

import dao.UserImplDAO;
import model.Contact;
import model.User;

public class NewContactActivity extends AppCompatActivity implements View.OnClickListener{
    private Button buttonSalvar;
    private EditText editTextApelido;
    private EditText fullnameEditText;
    private EditText phonenumberEditText;
    private User mUser ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findById();
        clickListener();
    }

    private  void findById(){
        buttonSalvar = findViewById(R.id.btn_salvar);
        editTextApelido = findViewById(R.id.edittext_user);
        fullnameEditText = findViewById(R.id.edittext_nome);
        phonenumberEditText = findViewById(R.id.edittext_telefone);
    }
    private  void clickListener(){
        buttonSalvar.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if(view == buttonSalvar){

            getUser();
        }
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void getUser() {
        Bundle bundle = getIntent().getExtras();
        String username = null;
        if (bundle != null) {
            username = getIntent().getStringExtra("username");
        }
        mUser = UserImplDAO.getInstance().findByUsername(username);
        if (mUser != null) {
            saveContact();
        }
    }

    private void saveContact() {
        String apelido = editTextApelido.getText().toString();
        String name = fullnameEditText.getText().toString();
        String telefone = phonenumberEditText.getText().toString();

        if(mUser.getContacts().findByApelido(apelido) == null){
            Contact c = new Contact(apelido, name, telefone);
            mUser.getContacts().addContacts(c);
            Toast.makeText(this, R.string.message_contato_criado, Toast.LENGTH_LONG).show();
            finish();
        }else{
            Toast.makeText(this, R.string.message_contato_existente, Toast.LENGTH_SHORT).show();
        }

    }
}