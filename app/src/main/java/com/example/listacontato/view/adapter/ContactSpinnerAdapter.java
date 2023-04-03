package com.example.listacontato.view.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.List;

import model.Contact;

public class ContactSpinnerAdapter extends ArrayAdapter<Contact> {

    private List<Contact> listContact;
    public ContactSpinnerAdapter(@NonNull Context context, int resource, @NonNull List<Contact> values) {
        super(context, resource, values);
    }
    
     @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView textView = new TextView(getContext());
        if(getItem(position) == null){
            textView.setText("");
        }else {
            textView.setText(getItem(position).getApelido());
        }
        return textView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView textView = new TextView(getContext());
        if(getItem(position) == null){
            textView.setText("");
        }else {
            textView.setText(String.format("Apelido: %s/nNome: %s", getItem(position).getApelido(), getItem(position).getName()));
        }
        textView.setPadding(8, 8, 8, 8);
        return textView;
    }
}
