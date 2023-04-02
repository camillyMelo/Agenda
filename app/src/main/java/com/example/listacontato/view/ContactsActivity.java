package com.example.listacontato.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.listacontato.R;
import com.example.listacontato.view.adapter.ContactSpinnerAdapter;
import com.example.listacontato.view.constants.Constantes;

import java.util.List;

import dao.UserImplDAO;
import model.Contact;
import model.User;

public class ContactsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    private Spinner mSpinner;
    private TextView nameTextView;
    private TextView telefoneTextView;
    private Button buttonNovoContato;
    private Button buttonCall;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findById();
        clickListener();
        getUsers();
        populateSpinner();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSpinner.setSelection(0);
    }

    private void findById(){
        mSpinner = findViewById(R.id.spinner_contacts);
        nameTextView = findViewById(R.id.textview_name);
        telefoneTextView = findViewById(R.id.textview_phone);
        buttonNovoContato = findViewById(R.id.btn_create_new_contact);
        buttonCall = findViewById(R.id.btn_call);
    }
    private  void clickListener(){
        mSpinner.setOnItemSelectedListener(this);
        buttonNovoContato.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if (view == buttonNovoContato) {
            registerNewContact(user);
        }
        if (view == buttonCall){
            call();
        }
    }

    private void call() {
        Toast.makeText(this, R.string.ligando, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Contact contact = (Contact) mSpinner.getItemAtPosition(position);
        if(contact != null){
            openDetailsActivity(contact);
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        nameTextView.setVisibility(View.GONE);
    }

    private void populateSpinner(){
        if(user != null) {
            List<Contact> dataset = user.getContacts().findAll();
            dataset.add(0, null);
            ContactSpinnerAdapter adapter = new ContactSpinnerAdapter(this, android.R.layout.simple_spinner_item, dataset);
            mSpinner.setAdapter(adapter);
        }
    }
    private void openDetailsActivity(Contact contact){
        nameTextView.setVisibility(View.VISIBLE);
        telefoneTextView.setVisibility(View.VISIBLE);
        nameTextView.setText(contact.getName());
        telefoneTextView.setText(contact.getPhoneNumber());
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void getUsers(){
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            String usuario = getIntent().getStringExtra(Constantes.USERNAME);
            String senha = getIntent().getStringExtra(Constantes.PASSWORD);
            if (UserImplDAO.getInstance().validateUser(usuario, senha)) {
                user = UserImplDAO.getInstance().findByUsername(usuario);

                    Toast.makeText(this, R.string.message_welcome, Toast.LENGTH_LONG).show();

                  } else {
                Toast.makeText(this, R.string.message_usuario_nao_cadastrado, Toast.LENGTH_LONG).show();
                finish();
            }
        }
    }
    private void registerNewContact(User user) {
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            String usuario = getIntent().getStringExtra(Constantes.USERNAME);
            String senha = getIntent().getStringExtra(Constantes.PASSWORD);

       }

        Intent intent = new Intent(this, NewContactActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
